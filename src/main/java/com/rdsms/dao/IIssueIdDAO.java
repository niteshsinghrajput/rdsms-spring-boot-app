package com.rdsms.dao;

import java.util.List;

import com.rdsms.entity.IdAllocation;

public interface IIssueIdDAO {

	List<IdAllocation> getAllocatedIds();
	IdAllocation getAllocatedId(int id);
	IdAllocation allocateId(IdAllocation id);
	IdAllocation updateId(int id, IdAllocation idData);
	boolean deallocateId(int id);
	List<IdAllocation> getAllocatedIdsByCandidateId(int candidateId);
	
}
