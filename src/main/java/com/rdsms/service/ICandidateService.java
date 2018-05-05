package com.rdsms.service;

import java.util.List;

import com.rdsms.entity.Candidate;

public interface ICandidateService {
	
	List<Candidate> getCandidates();
	Candidate createCandidate(Candidate candidate);
	Candidate getCandidateById(int candidateId);
	Candidate updateCandidate(int candidateId,Candidate candidate);
	boolean deleteCandidate(int candidateId);

}
