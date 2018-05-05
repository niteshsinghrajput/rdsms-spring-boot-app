package com.rdsms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rdsms.entity.Branch;
import com.rdsms.entity.Candidate;
import com.rdsms.entity.User;

@Transactional
@Repository
public class CandidateDAO implements ICandidateDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getCandidates() {
		String hql = "FROM com.rdsms.entity.Candidate as c ORDER BY c.candidateId";
		return (List<Candidate>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Candidate getCandidateById(int candidateId) {
		Candidate candidate = entityManager.find(Candidate.class, candidateId);
		return candidate;
	}

	@Override
	public Candidate createCandidate(Candidate candidate) {
		
		
		User createdBy = entityManager.find(User.class, candidate.getCreatedBy().getUserId());
		User updatedBy = entityManager.find(User.class, candidate.getUpdatedBy().getUserId());
		Branch rdbranch = entityManager.find(Branch.class, candidate.getRdbranch().getBranchId());
		candidate.setCreatedBy(createdBy);
		candidate.setUpdatedBy(updatedBy);
		candidate.setRdbranch(rdbranch);
		entityManager.persist(candidate);
		Candidate c = lastInsertedCandidate();
		return c;
	}

	@Override
	public Candidate updateCandidate(int candidateId, Candidate candidate) {
		
		User createdBy = entityManager.find(User.class, candidate.getCreatedBy().getUserId());
		User updatedBy = entityManager.find(User.class, candidate.getUpdatedBy().getUserId());
		Branch branch = entityManager.find(Branch.class, candidate.getRdbranch().getBranchId());
		
		Candidate existingCandidate = entityManager.find(Candidate.class, candidateId);
		existingCandidate.setName(candidate.getName());
		existingCandidate.setFatherName(candidate.getFatherName());
		existingCandidate.setMotherName(candidate.getMotherName());
		existingCandidate.setDob(candidate.getDob());
		existingCandidate.setAddress(candidate.getAddress());
		existingCandidate.setLandmark(candidate.getLandmark());
		existingCandidate.setCity(candidate.getCity());
		existingCandidate.setDistrict(candidate.getDistrict());
		existingCandidate.setState(candidate.getState());
		existingCandidate.setPostalCode(candidate.getPostalCode());
		existingCandidate.setReligion(candidate.getReligion());
		existingCandidate.setCategory(candidate.getCategory());
		existingCandidate.setNationality(candidate.getNationality());
		existingCandidate.setKnownLanguages(candidate.getKnownLanguages());
		existingCandidate.setPrimaryMobile(candidate.getAlternateMobile());
		existingCandidate.setAlternateMobile(candidate.getAlternateMobile());
		existingCandidate.setPhotoId(candidate.getPhotoId());
		existingCandidate.setBank(candidate.getBank());
		existingCandidate.setBranch(candidate.getBranch());
		existingCandidate.setIfscCode(candidate.getIfscCode());
		existingCandidate.setAccountNumber(candidate.getAccountNumber());
		existingCandidate.setActive(candidate.isActive());
		existingCandidate.setCreatedOn(candidate.getCreatedOn());
		existingCandidate.setUpdatedOn(candidate.getUpdatedOn());
		existingCandidate.setCreatedBy(createdBy);
		existingCandidate.setUpdatedBy(updatedBy);
		existingCandidate.setRdbranch(branch);
		entityManager.flush();
		Candidate updatedBranch = getCandidateById(candidateId);
		
		return updatedBranch;
	}

	@Override
	public boolean deleteCandidate(int candidateId) {
		
		Candidate candidate = entityManager.find(Candidate.class, candidateId);
		entityManager.remove(candidate);
		entityManager.flush();
		
		boolean status = entityManager.contains(candidate);
		if(status)
			return false;
		else
			return true;
	}
	
	private Candidate lastInsertedCandidate() {
		String hql = "FROM com.rdsms.entity.Candidate as c order by c.candidateId DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Candidate candidate = (Candidate)query.getSingleResult();
		return candidate;
	}

}
