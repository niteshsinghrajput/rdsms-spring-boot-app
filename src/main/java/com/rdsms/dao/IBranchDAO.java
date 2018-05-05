package com.rdsms.dao;

import java.util.List;

import com.rdsms.entity.Branch;

/**
 * 
 * @author Nitesh
 *
 */
public interface IBranchDAO {

	List<Branch> getBranches();
	Branch getBranchById(int branchId);
	Branch createBranch(Branch branch);
	Branch updateBranch(int branchId, Branch branch);
	boolean deleteBranch(int branchId);
	
}
