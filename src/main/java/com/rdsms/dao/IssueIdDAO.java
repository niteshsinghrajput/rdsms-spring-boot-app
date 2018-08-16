package com.rdsms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rdsms.entity.Candidate;
import com.rdsms.entity.ID;
import com.rdsms.entity.IdAllocation;
import com.rdsms.entity.User;

@Repository
@Transactional
public class IssueIdDAO implements IIssueIdDAO {
	
	@Autowired
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<IdAllocation> getAllocatedIds() {
		String sql = "FROM com.rdsms.entity.IdAllocation as i order by i.issueId DESC";
		return manager.createQuery(sql).getResultList();
	}

	@Override
	public IdAllocation getAllocatedId(int id) {
		return manager.find(IdAllocation.class, id);
	}

	@Override
	public IdAllocation allocateId(IdAllocation id) {
		
		ID idData = manager.find(ID.class, id.getIdd().getId());
		User createdBy = manager.find(User.class, id.getCreatedBy().getUserId());
		User updatedBy = manager.find(User.class, id.getUpdatedBy().getUserId());
		Candidate candidate = manager.find(Candidate.class, id.getCandidate().getCandidateId());
		id.setIdd(idData);
		id.setCandidate(candidate);
		id.setCreatedBy(createdBy);
		id.setUpdatedBy(updatedBy);
		manager.persist(id);
		
		IdAllocation allocatedId = getLastInsertedId();
		return allocatedId;
	}

	@Override
	public IdAllocation updateId(int id, IdAllocation idData) {
		
		IdAllocation allocatedId = manager.find(IdAllocation.class, id);
		
		ID existingIdData = manager.find(ID.class, idData.getIdd().getId());
		User createdBy = manager.find(User.class, idData.getCreatedBy().getUserId());
		User updatedBy = manager.find(User.class, idData.getUpdatedBy().getUserId());
		Candidate candidate = manager.find(Candidate.class, idData.getCandidate().getCandidateId());
		
		allocatedId.setCandidate(candidate);
		allocatedId.setActive(idData.isActive());
		allocatedId.setCreatedBy(createdBy);
		allocatedId.setUpdatedBy(updatedBy);
		allocatedId.setUpdatedOn(idData.getUpdatedOn());
		allocatedId.setIdd(existingIdData);
		
		manager.flush();
		IdAllocation updatedAllocationId = getAllocatedId(id);
		return updatedAllocationId;
	}

	@Override
	public boolean deallocateId(int id) {
		
		IdAllocation allocatedId = manager.find(IdAllocation.class, id);
		manager.remove(allocatedId);
		manager.flush();
		boolean status = manager.contains(allocatedId);
		if(status)
			return false;
		else
			return true;
	}
	
	private IdAllocation getLastInsertedId() {
		String sql = "FROM com.rdsms.entity.IdAllocation as i order by i.issueId DESC";
		Query query = manager.createQuery(sql).setMaxResults(1);
		return (IdAllocation) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IdAllocation> getAllocatedIdsByCandidateId(int candidateId) {
		String sql = "SELECT * FROM id_allocation as id WHERE CandidateId = :candidateId ORDER BY id.issueId";
		Query query  = manager.createNativeQuery(sql);
		query.setParameter("candidateId", candidateId);
		
		List<Object[]> rows = query.getResultList();
		List<IdAllocation> allocatedIds = new ArrayList<IdAllocation>(rows.size());
		
		for (Object[] row : rows) {
			IdAllocation allocatedId = manager.find(IdAllocation.class, row[0]);
			allocatedIds.add(allocatedId);
		    
		}
		return allocatedIds;
	}

}
