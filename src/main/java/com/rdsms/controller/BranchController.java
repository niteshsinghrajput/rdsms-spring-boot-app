package com.rdsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdsms.entity.Branch;
import com.rdsms.service.IBranchService;

@Controller
@RequestMapping("branchservice")
public class BranchController {
	
	@Autowired
	private IBranchService service;
	
	@GetMapping("branches")
	public ResponseEntity<List<Branch>> getBranches(){
		List<Branch> branches = service.getBranches();
		return new ResponseEntity<List<Branch>>(branches,HttpStatus.OK);
	}
	
	@GetMapping("branches/{branchId}")
	public ResponseEntity<Branch> getBranchById(@PathVariable("branchId") int branchId){
		Branch branch = service.getBranchById(branchId);
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}

	@PostMapping("branches")
	public ResponseEntity<Branch> createBranch(@RequestBody Branch branch){
		Branch br = service.createBranch(branch);
		return new ResponseEntity<Branch>(br,HttpStatus.OK);
	}
	
	@PutMapping("branches/{branchId}")
	public ResponseEntity<Branch> updateBranch(@PathVariable("branchId") int branchId, @RequestBody Branch branch){
		Branch br = service.updateBranch(branchId, branch);
		return new ResponseEntity<Branch>(br,HttpStatus.OK);
	}
	
	@DeleteMapping("branches/{branchId}")
	public ResponseEntity<String> deleteBranch(@PathVariable("branchId") int branchId) {
		
		boolean isDeleted = service.deleteBranch(branchId);
		String message;
		if(isDeleted) {
			message = "Branch(BranchId="+branchId+") has been deleted successfully";
		}else {
			message = "Error while deleting Branch(BranchId="+branchId+") from database";
		}
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
