package com.rdsms.dao;

/**
 * @author Nitesh
 */

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rdsms.entity.ID;


@Repository
@Transactional
public class IdDAOImpl implements IdDAO {
	
	@Autowired
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ID> getIDs() {
		String sql = "FROM com.rdsms.entity.ID as i order by i.id DESC";
		return manager.createQuery(sql).getResultList();
	}

	@Override
	public ID getID(int id) {
		return manager.find(ID.class, id);
	}

	@Override
	public ID createId(ID id) {
		return null;
	}

	@Override
	public ID updateId(int id, ID idData) {
		return null;
	}

	@Override
	public boolean deleteId(int id) {
		return false;
	}
	
	private ID getLastInsertedId(int id) {
		String sql = "FROM com.rdsms.entity.Id as i order by i.id DESC";
		Query query = manager.createQuery(sql).setMaxResults(1);
		return (ID) query.getSingleResult();
	}

}
