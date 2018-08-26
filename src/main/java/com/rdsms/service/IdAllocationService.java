package com.rdsms.service;

/**
 * @author Nitesh
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdsms.dao.IIssueIdDAO;
import com.rdsms.entity.IdAllocation;

@Service
public class IdAllocationService implements IIdAllocationService {
	
	@Autowired
	private IIssueIdDAO idDAO;

	@Override
	public List<IdAllocation> getAllocatedIds() {
		return idDAO.getAllocatedIds();
	}

	@Override
	public List<IdAllocation> getAllocatedIdsByCandidate(int candidateId) {
		return idDAO.getAllocatedIdsByCandidateId(candidateId);
	}

	@Override
	public IdAllocation allocateId(IdAllocation id) {
		return idDAO.allocateId(id);
	}

	@Override
	public IdAllocation updateId(int id, IdAllocation idData) {
		return idDAO.updateId(id, idData);
	}

	@Override
	public boolean deallocateId(int id) {
		return idDAO.deallocateId(id);
	}

	@Override
	public IdAllocation getAllocatedId(int allocatedId) {
		return idDAO.getAllocatedId(allocatedId);
	}

}
