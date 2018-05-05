package com.rdsms.service;

import java.util.List;

import com.rdsms.entity.Director;

public interface IDirectorService {
	
	List<Director> getDirectorList();
	Director addDirector(Director director);
	Director updateDirector(int directorId, Director director);
	boolean deleteDirector(int directorId);

}
