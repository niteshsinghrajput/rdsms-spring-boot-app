package com.rdsms.service;

/**
 * @author Nitesh
 */

import java.util.List;
import com.rdsms.entity.IdAllocation;

public interface IIdAllocationService {
	
	List<IdAllocation> getAllocatedIds();
	List<IdAllocation> getAllocatedIdsByCandidate(int candidateId);
	IdAllocation getAllocatedId(int allocatedId);
	IdAllocation allocateId(IdAllocation id);
	IdAllocation updateId(int id, IdAllocation idData);
	boolean deallocateId(int id);

}
