package com.rdsms.service;

/**
 * @author Nitesh
 */


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdsms.dao.IDirectorDAO;
import com.rdsms.entity.Director;

@Service
public class DirectorService implements IDirectorService {

	@Autowired
	private IDirectorDAO dao;
	
	@Override
	public List<Director> getDirectorList() {
		return dao.getDirectorList();
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
