package com.rdsms.service;

import java.util.List;

import com.rdsms.entity.ID;

public interface IdService {
	
	List<ID> getIds();
	ID getId(int id);
	List<ID> getIdsByBranch(int branchId);
	List<ID> getAvailableIds();
	ID createId(ID id);
	ID updateId(int id, ID idData);
	boolean deleteId(int id);

}
