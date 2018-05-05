package com.rdsms.dao;
/**
 * @author Nitesh
 */

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rdsms.entity.Director;

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
	public Director addDirector(Director director) {
		return null;
	}

	@Override
	public Director updateDirector(int directorId, Director director) {
		return null;
	}

	@Override
	public boolean deleteDirector(int directorId) {
		return false;
	}

}
