package com.rdsms.dao;

import java.util.List;

import com.rdsms.entity.Candidate;

/**
 * 
 * @author Nitesh
 *
 */
public interface ICandidateDAO {
	
	List<Candidate> getCandidates();
	Candidate getCandidateById(int candidateId);
	Candidate createCandidate(Candidate candidate);
	Candidate updateCandidate(int candidateId, Candidate candidate);
	boolean deleteCandidate(int candidateId);

}
