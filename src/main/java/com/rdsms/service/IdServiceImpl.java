package com.rdsms.service;

/**
 * @author Nitesh
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdsms.dao.IdDAO;
import com.rdsms.entity.ID;

@Service
public class IdServiceImpl implements IdService{
	
	@Autowired
	private IdDAO dao;

	@Override
	public List<ID> getIds() {
		return dao.getIDs();
	}

	@Override
	public ID getId(int id) {
		return dao.getID(id);
	}

	@Override
	public ID createId(ID id) {
		return dao.createId(id);
	}

	@Override
	public ID updateId(int id, ID idData) {
		return dao.updateId(id, idData);
	}

	@Override
	public boolean deleteId(int id) {
		return dao.deleteId(id);
	}

}
