package com.rdsms.dao;
/**
 * @author Nitesh
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rdsms.entity.Director;
import com.rdsms.entity.User;

@Repository
@Transactional
public class DirectorDAO implements IDirectorDAO {

	@Autowired
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Director> getDirectorList() {
		String hql = "FROM Director as d ORDER BY d.directorId";
		return manager.createQuery(hql).getResultList();
	}
	
	@Override
	public Director getDirectorById(int directorId) {
		Director director = manager.find(Director.class, directorId);
		return director;
	}

	@Override
	public Director addDirector(Director director) {
		
		User createdBy = manager.find(User.class, director.getCreatedBy().getUserId());
		User updatedBy = manager.find(User.class, director.getUpdatedBy().getUserId());
		director.setCreatedBy(createdBy);
		director.setUpdatedBy(updatedBy);
		
		manager.persist(director);
		director = lastInsertedDirector();
		return director;
	}

	@Override
	public Director updateDirector(int directorId, Director director) {
		
		Director existingDirector = getDirectorById(directorId);
		User createdBy = manager.find(User.class, director.getCreatedBy().getUserId());
		User updatedBy = manager.find(User.class, director.getUpdatedBy().getUserId());
		existingDirector.setDirectorName(director.getDirectorName());
		existingDirector.setDob(director.getDob());
		existingDirector.setFatherName(director.getFatherName());
		existingDirector.setPrimaryMobile(director.getPrimaryMobile());
		existingDirector.setAlternateMobile(director.getAlternateMobile());
		existingDirector.setAccountNumber(director.getAccountNumber());
		existingDirector.setBankName(director.getBankName());
		existingDirector.setBranchName(director.getBranchName());
		existingDirector.setIfscCode(director.getIfscCode());
		existingDirector.setCreatedOn(director.getCreatedOn());
		existingDirector.setUpdatedOn(director.getUpdatedOn());
		existingDirector.setActive(director.isActive());
		existingDirector.setPhotoId(director.getPhotoId());
		existingDirector.setCreatedBy(createdBy);
		existingDirector.setUpdatedBy(updatedBy);
		manager.flush();
		Director updatedDirector = getDirectorById(directorId);
		return updatedDirector;
	}

	@Override
	public boolean deleteDirector(int directorId) {

		Director director = manager.find(Director.class, directorId);
		manager.remove(director);
		manager.flush();
		boolean status = manager.contains(director);
		if(status)
			return false;
		else
			return true;
	}
	
	private Director lastInsertedDirector() {
		String sql = "FROM com.rdsms.entity.Director as d order by d.directorId DESC";
		Query query = manager.createQuery(sql);
		query.setMaxResults(1);
		Director director = (Director)query.getSingleResult();
		return director;
	}

}
