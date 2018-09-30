package com.rdsms.service;

import java.util.List;

import com.rdsms.entity.Branch;
import com.rdsms.entity.Candidate;

/**
 * 
 * @author Nitesh
 *
 */
public interface IBranchService {
	List<Branch> getBranches();
	Branch getBranchById(int branchId);
	Branch createBranch(Branch branch);
	Branch updateBranch(int branchId, Branch branch);
	boolean deleteBranch(int branchId);
	int getCandidatesByBranchId(int branchId);
	
}
