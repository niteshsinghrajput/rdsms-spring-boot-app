package com.rdsms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rdsms.entity.Operator;
import com.rdsms.entity.OperatorType;

/**
 * 
 * @author Nitesh
 *
 */

@Transactional
@Repository
public class OperatorTypeDAO implements IOperatorTypeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<OperatorType> getOperatorTypes() {
		
		String sql = "FROM com.rdsms.entity.OperatorType as ot order by ot.operatorTypeId";
		return entityManager.createQuery(sql).getResultList();
	}

	@Override
	public OperatorType getOperatorTypeByOperatorTypeId(int operatorTypeId) {
		return entityManager.find(OperatorType.class, operatorTypeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OperatorType> getOperatorTypeByOperatorId(int operatorId) {
		
		String hql = "FROM com.rdsms.entity.OperatorType as o WHERE operatorId = :operatorId ORDER BY o.operatorTypeId";
		Query query  = entityManager.createQuery(hql);
		query.setParameter("operatorId", operatorId);
		return (List<OperatorType>) query.getResultList();
	}

	@Override
	public OperatorType createOperatorType(OperatorType operatorType) {
		entityManager.persist(operatorType);
		OperatorType type = getLastInsertedOperatorTYpe();
		Operator operator = entityManager.find(Operator.class, type.getOperator().getOperatorId());
		type.setOperator(operator);
		return type;
	}

	@Override
	public OperatorType updateOperatorType(int operatorTypeId, OperatorType operatorType) {
		OperatorType existingOperatorType = entityManager.find(OperatorType.class, operatorTypeId);
		existingOperatorType.setOperatorType(operatorType.getOperatorType());	
		Operator operator = entityManager.find(Operator.class, operatorType.getOperator().getOperatorId());
		existingOperatorType.setOperator(operator);
		existingOperatorType.setActive(operatorType.isActive());
		entityManager.flush();
		OperatorType updatedOperatorType = getOperatorTypeByOperatorTypeId(operatorTypeId);
		return updatedOperatorType;
	}

	@Override
	public boolean deleteOperatorType(int operatorTypeId) {
		OperatorType operatorType = entityManager.find(OperatorType.class, operatorTypeId);
		entityManager.remove(operatorType);
		entityManager.flush();
		boolean status = entityManager.contains(operatorType);
		if(status)
			return false;
		else
			return true;
	}
	
	private OperatorType getLastInsertedOperatorTYpe() {
		
		String hql = "FROM com.rdsms.entity.OperatorType as ot order by ot.operatorTypeId DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		OperatorType operator = (OperatorType)query.getSingleResult();
		return operator;
		
	}

}
