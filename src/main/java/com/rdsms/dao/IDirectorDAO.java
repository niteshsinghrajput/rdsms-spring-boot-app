package com.rdsms.dao;

import java.util.List;

import com.rdsms.entity.Director;

public interface IDirectorDAO {
	
	List<Director> getDirectorList();
	Director getDirectorById(int directorId);
	Director addDirector(Director director);
	Director updateDirector(int directorId, Director director);
	boolean deleteDirector(int directorId);

}
