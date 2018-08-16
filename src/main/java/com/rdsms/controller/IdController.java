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

import com.rdsms.entity.ID;
import com.rdsms.entity.IdAllocation;
import com.rdsms.service.IdAllocationService;
import com.rdsms.service.IdService;

/**
 * 
 * @author Nitesh
 *
 */

@Controller
@RequestMapping("idservice")
public class IdController {
	
	@Autowired
	private IdService service;
	
	@Autowired
	private IdAllocationService allocationService;
	
	@GetMapping("id")
	public ResponseEntity<List<ID>> getIds(){
		List<ID> ids = service.getIds();
		return new ResponseEntity<List<ID>>(ids, HttpStatus.OK);
	}
	
	@GetMapping("idbybranch/{branchId}")
	public ResponseEntity<List<ID>> getIdsByBranch(@PathVariable("branchId") int branchId){
		List<ID> ids = service.getIdsByBranch(branchId);
		return new ResponseEntity<List<ID>>(ids, HttpStatus.OK);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<ID> getIDData(@PathVariable("id") int id){
		ID idData = service.getId(id);
		return new ResponseEntity<ID>(idData,HttpStatus.OK);
		
	}
	
	@PostMapping("id")
	public ResponseEntity<ID> createID(@RequestBody ID idData){
		ID addedID = service.createId(idData);
		return new ResponseEntity<ID>(addedID,HttpStatus.OK);
	}
	
	@PutMapping("id/{id}")
	public ResponseEntity<ID> updateID(@PathVariable("id") int id, @RequestBody ID idData){
		ID updatedID = service.updateId(id, idData);
		return new ResponseEntity<ID>(updatedID,HttpStatus.OK);
	}
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<String> deleteID(@PathVariable("id") int id){
		String message;
		boolean isDeleted = service.deleteId(id);
		if(isDeleted) {
			message = "ID(id="+id+") has been deleted successfully";
		}else {
			message = "Error while deleting ID(id="+id+") from database";
		}
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("allocatedid")
	public ResponseEntity<List<IdAllocation>> getAllocatedIds(){
		List<IdAllocation> allocatedIdList = allocationService.getAllocatedIds();
		return new ResponseEntity<List<IdAllocation>>(allocatedIdList, HttpStatus.OK);
	}

	@GetMapping("allocatedidofcandidate/{candidateId}")
	public ResponseEntity<List<IdAllocation>> getAllocatedIdsByCandidateId(@PathVariable("candidateId") int candidateId){
		List<IdAllocation> allocatedIdList = allocationService.getAllocatedIdsByCandidate(candidateId);
		return new ResponseEntity<List<IdAllocation>>(allocatedIdList, HttpStatus.OK);
	}
	
	@GetMapping("allocatedid/{allocatedId}")
	public ResponseEntity<IdAllocation> getAllocationIdDetail(@PathVariable("allocatedId") int allocatedId) {
		IdAllocation id = allocationService.getAllocatedId(allocatedId);
		return new ResponseEntity<IdAllocation>(id,HttpStatus.OK);
	}
	
	@PostMapping("allocateid")
	public ResponseEntity<IdAllocation> allocateId(@RequestBody IdAllocation idAllocation) {
		IdAllocation id = allocationService.allocateId(idAllocation);
		return new ResponseEntity<IdAllocation>(id,HttpStatus.OK);
	}
	
	@DeleteMapping("deallocateid/{issuedId}")
	public ResponseEntity<String> deallocateId(@PathVariable("issuedId") int issuedId){
		boolean isDeallocated = allocationService.deallocateId(issuedId);
		String message;
		if(isDeallocated) {
			message = "AllocatedId(Id="+issuedId+") has been deleted successfully";
		}else {
			message = "Error while deleting AllocatedId(Id="+issuedId+") from database";
		}
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
