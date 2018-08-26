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

import com.rdsms.entity.Candidate;
import com.rdsms.service.ICandidateService;

/**
 * 
 * @author Nitesh
 *
 */

@Controller
@RequestMapping("candidateservice")
public class CandidateController {
	
	@Autowired
	private ICandidateService service;
	
	@GetMapping("candidates")
	public ResponseEntity<List<Candidate>> getCandidates() {
		List<Candidate> candidates = service.getCandidates();
		return new ResponseEntity<List<Candidate>>(candidates,HttpStatus.OK);
	}
	
	@GetMapping("availablecandidates")
	public ResponseEntity<List<Candidate>> getAvailableCandidates() {
		List<Candidate> candidates = service.getAvailableCandidates();
		return new ResponseEntity<List<Candidate>>(candidates,HttpStatus.OK);
	}
	
	@GetMapping("candidates/{candidateId}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable("candidateId") int candidateId) {
		Candidate candidate = service.getCandidateById(candidateId);
		return new ResponseEntity<Candidate>(candidate,HttpStatus.OK);
	}
	
	@PostMapping("candidates")
	public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
		Candidate createdCandidate = service.createCandidate(candidate);
		return new ResponseEntity<Candidate>(createdCandidate,HttpStatus.OK);
	}
	
	@PutMapping("candidates/{candidateId}")
	public ResponseEntity<Candidate> updateCandidate(@PathVariable("candidateId") int candidateId, @RequestBody Candidate candidate) {
		Candidate updatedCandidate = service.updateCandidate(candidateId, candidate);
		return new ResponseEntity<Candidate>(updatedCandidate,HttpStatus.OK);
		
	}
	
	@DeleteMapping("candidates/{candidateId}")
	public ResponseEntity<String> deleteCandidate(@PathVariable("candidateId") int candidateId) {
		String message;
		boolean isDeleted = service.deleteCandidate(candidateId);
		if(isDeleted) {
			message = "Candidate(id="+candidateId+") has been deleted successfully";
		}else {
			message = "Error while deleting candidate(id="+candidateId+") from database";
		}
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}

}
