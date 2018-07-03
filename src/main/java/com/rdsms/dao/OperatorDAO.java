package com.rdsms.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.rdsms.entity.Operator;
import com.rdsms.entity.User;

/**
 * 
 * @author Nitesh
 *
 */


@Transactional
@Repository
public class OperatorDAO implements IOperatorDAO{

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Operator> getOperators() {
		String sql = "FROM com.rdsms.entity.Operator as o order by o.operatorId";
		return (List<Operator>)entityManager.createQuery(sql).getResultList();
	}

	@Override
	public Operator getOperatorById(int operatorId) {
		return entityManager.find(Operator.class, operatorId);
	}

	@Override
	public Operator createOperator(Operator operator) {
		
		User createdBy = entityManager.find(User.class, operator.getCreatedBy().getUserId());
		User updatedBy = entityManager.find(User.class, operator.getUpdatedBy().getUserId());
		operator.setCreatedBy(createdBy);
		operator.setUpdatedBy(updatedBy);
		entityManager.persist(operator);
		Operator lastCreatedOperator = getLastInsertedOperator();
		return lastCreatedOperator;
	}

	@Override
	public Operator updateOperator(int operatorId, Operator operator) {
		
		User createdBy = entityManager.find(User.class, operator.getCreatedBy().getUserId());
		User updatedBy = entityManager.find(User.class, operator.getUpdatedBy().getUserId());
		Operator existingOperator = getOperatorById(operatorId);
		existingOperator.setOperatorName(operator.getOperatorName());
		existingOperator.setDescription(operator.getDescription());
		existingOperator.setCreatedBy(createdBy);
		existingOperator.setUpdatedBy(updatedBy);
		existingOperator.setCreatedOn(operator.getCreatedOn());
		existingOperator.setUpdatedOn(operator.getUpdatedOn());
		existingOperator.setActive(operator.isActive());
		entityManager.flush();
		
		Operator updatedOperator = getOperatorById(operatorId);
		return updatedOperator;
	}

	@Override
	public boolean deleteOperator(int operatorId) {
		
		Operator operator = getOperatorById(operatorId);
		entityManager.remove(operator);
		entityManager.flush();
		
		boolean status = entityManager.contains(operator);
		if(status)
			return false;
		else
			return true;
	}
	
	private Operator getLastInsertedOperator() {
		
		String hql = "FROM com.rdsms.entity.Operator as o order by o.operatorId DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Operator operator = (Operator)query.getSingleResult();
		return operator;
		
	}

}
