package com.rdsms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdsms.dao.IBranchDAO;
import com.rdsms.entity.Branch;
import com.rdsms.entity.Candidate;

@Service
public class BranchService implements IBranchService {

	@Autowired
	private IBranchDAO dao;
	
	@Override
	public List<Branch> getBranches() {
		return dao.getBranches();
	}

	@Override
	public Branch getBranchById(int branchId) {
		return dao.getBranchById(branchId);
	}

	@Override
	public Branch createBranch(Branch branch) {
		return dao.createBranch(branch);
	}

	@Override
	public Branch updateBranch(int branchId, Branch branch) {
		return dao.updateBranch(branchId, branch);
	}

	@Override
	public boolean deleteBranch(int branchId) {
		return dao.deleteBranch(branchId);
	}
	
	@Override
	public int getCandidatesByBranchId(int branchId){
		return dao.getCandidatesByBranchId(branchId);
	}

}
