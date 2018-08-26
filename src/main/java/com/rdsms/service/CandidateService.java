package com.rdsms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdsms.dao.ICandidateDAO;
import com.rdsms.entity.Candidate;

@Service
public class CandidateService implements ICandidateService{

	@Autowired
	private ICandidateDAO dao;
	
	@Override
	public List<Candidate> getCandidates() {
		return dao.getCandidates();
	}

	@Override
	public Candidate createCandidate(Candidate candidate) {
		return dao.createCandidate(candidate);
	}

	@Override
	public Candidate getCandidateById(int candidateId) {
		return dao.getCandidateById(candidateId);
	}

	@Override
	public Candidate updateCandidate(int candidateId, Candidate candidate) {
		return dao.updateCandidate(candidateId, candidate);
	}

	@Override
	public boolean deleteCandidate(int candidateId) {
		return dao.deleteCandidate(candidateId);
	}

	@Override
	public List<Candidate> getAvailableCandidates() {
		return dao.getAvailableCandidates();
	}

}
