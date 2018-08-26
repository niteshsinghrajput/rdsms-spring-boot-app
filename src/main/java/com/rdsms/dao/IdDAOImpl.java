package com.rdsms.dao;

import java.util.ArrayList;

/**
 * @author Nitesh
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rdsms.entity.Branch;
import com.rdsms.entity.ID;
import com.rdsms.entity.IdAllocation;
import com.rdsms.entity.Operator;
import com.rdsms.entity.User;


@Repository
@Transactional
public class IdDAOImpl implements IdDAO {
	
	@Autowired
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ID> getIDs() {
		String sql = "FROM com.rdsms.entity.ID as i order by i.id DESC";
		return manager.createQuery(sql).getResultList();
	}

	@Override
	public ID getID(int id) {
		return manager.find(ID.class, id);
	}

	@Override
	public ID createId(ID id) {
		
		User createdBy = manager.find(User.class, id.getCreatedBy().getUserId());
		User updatedBy = manager.find(User.class, id.getUpdatedBy().getUserId());
		Branch rdbranch = manager.find(Branch.class, id.getRdbranch().getBranchId());
		Operator operator = manager.find(Operator.class, id.getOperator().getOperatorId());
		
		id.setOperator(operator);
		id.setRdbranch(rdbranch);
		id.setCreatedBy(createdBy);
		id.setUpdatedBy(updatedBy);
		manager.persist(id);
		
		ID lastAddedId = getLastInsertedId();
		return lastAddedId;
	}

	@Override
	public ID updateId(int id, ID idData) {
		
		ID existingId = getID(id);
		
		User createdBy = manager.find(User.class, idData.getCreatedBy().getUserId());
		User updatedBy = manager.find(User.class, idData.getUpdatedBy().getUserId());
		Branch rdbranch = manager.find(Branch.class, idData.getRdbranch().getBranchId());
		Operator operator = manager.find(Operator.class, idData.getOperator().getOperatorId());
		
		existingId.setCreatedBy(createdBy);
		existingId.setUpdatedBy(updatedBy);
		existingId.setRdbranch(rdbranch);
		existingId.setOperator(operator);
		existingId.setActive(idData.isActive());
		existingId.setMobile(idData.getMobile());
		existingId.setIdNumber(idData.getIdNumber());
		
		manager.flush();
		ID updatedId = getID(id);
		return updatedId;
	}

	@Override
	public boolean deleteId(int id) {
		ID idData = manager.find(ID.class, id);
		manager.remove(idData);
		manager.flush();
		boolean status = manager.contains(idData);
		if(status)
			return false;
		else
			return true;
	}
	
	private ID getLastInsertedId() {
		String sql = "FROM com.rdsms.entity.ID as i order by i.id DESC";
		Query query = manager.createQuery(sql).setMaxResults(1);
		return (ID) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ID> getIDsByBranch(int branchId) {
		
		String sql = "SELECT * FROM id as i WHERE BranchId = :branchId ORDER BY i.Id";
		Query query  = manager.createNativeQuery(sql);
		query.setParameter("branchId", branchId);
		
		List<Object[]> rows = query.getResultList();
		List<ID> ids = new ArrayList<ID>(rows.size());
		for (Object[] row : rows) {
			ID idData = manager.find(ID.class, row[0]);
			ids.add(idData);
		}
		return ids;
	}

	@Override
	public List<ID> getAvailableIDsByBranch(int branchId) {
		return null;
	}

	@Override
	public List<ID> getIDsByOperator(int operatorId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ID> getAvailableIds() {
		String hql = "FROM com.rdsms.entity.ID as i order by i.id DESC";
		List<ID> idList = manager.createQuery(hql).getResultList();
		List<ID> availableIds = new ArrayList<ID>();
		for(ID id: idList) {
			String sql = "SELECT * FROM id_allocation WHERE id= :id";
			Query query  = manager.createNativeQuery(sql);
			query.setParameter("id", id.getId());
			
			System.out.println(query);
			List<Object[]> rows = query.getResultList();
			if(rows.size() >=2) {
				continue;
			}else {
				availableIds.add(id);
			}
		}
		return availableIds;
	}

}
