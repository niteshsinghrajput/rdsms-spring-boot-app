package com.rdsms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rdsms.entity.Branch;
import com.rdsms.entity.Director;
import com.rdsms.entity.User;

/**
 * 
 * @author Nitesh
 *
 */

@Transactional
@Repository
public class BranchDAO implements IBranchDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Branch> getBranches() {
		String hql = "FROM com.rdsms.entity.Branch as b order by b.branchId";
		return (List<Branch>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Branch getBranchById(int branchId) {
		return entityManager.find(Branch.class, branchId);
	}

	@Override
	public Branch createBranch(Branch branch) {
		
		Director director = entityManager.find(Director.class, branch.getDirector().getDirectorId());
		User createdBy = entityManager.find(User.class, branch.getCreatedBy().getUserId());
		User updatedBy = entityManager.find(User.class, branch.getUpdatedBy().getUserId());
		branch.setCreatedBy(createdBy);
		branch.setUpdatedBy(updatedBy);
		branch.setDirector(director);
		entityManager.persist(branch);
		
		Branch br = getLastInsertedBranch();
		return br;
		
	}

	@Override
	public Branch updateBranch(int branchId, Branch branch) {
		
		System.out.println("Branch Before Update... "+branch);
		Director director = entityManager.find(Director.class, branch.getDirector().getDirectorId());
		User createdBy = entityManager.find(User.class, branch.getCreatedBy().getUserId());
		User updatedBy = entityManager.find(User.class, branch.getUpdatedBy().getUserId());
		
		Branch existingBranch = getBranchById(branchId);
		existingBranch.setBranchName(branch.getBranchName());
		existingBranch.setAddress(branch.getAddress());
		existingBranch.setCity(branch.getCity());
		existingBranch.setDistrict(branch.getDistrict());
		existingBranch.setCreatedBy(createdBy);
		existingBranch.setDirector(director);
		existingBranch.setUpdatedBy(updatedBy);
		existingBranch.setActive(branch.isActive());
		existingBranch.setCreatedOn(branch.getCreatedOn());
		
		System.out.println("After updating the values :::: "+existingBranch);
		
		entityManager.flush();
		Branch br = getBranchById(branchId);
		return br;
	}

	@Override
	public boolean deleteBranch(int branchId) {

		Branch branch = getBranchById(branchId);
		entityManager.remove(branch);
		entityManager.flush();
		
		boolean status = entityManager.contains(branch);
		if(status)
			return false;
		else
			return true;
	}
	
	private Branch getLastInsertedBranch() {
		
		String hql = "FROM com.rdsms.entity.Branch as br order by br.branchId DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Branch branch = (Branch)query.getSingleResult();
		return branch;
		
	}

}
