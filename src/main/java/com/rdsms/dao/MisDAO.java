package com.rdsms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.rdsms.entity.MIS;

@Repository
@Transactional
public class MisDAO implements IMisDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//private final int PAGE_SIZE = 10;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MIS> getMISData() {
		
		String hql = "FROM com.rdsms.entity.MIS as m ORDER BY m.id";
		return (List<MIS>) entityManager.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MIS> getMISDataByLocation(String location) {
		String hql = "FROM com.rdsms.entity.MIS as m WHERE location = :location ORDER BY m.id";
		Query query  = entityManager.createQuery(hql);
		query.setParameter("location", location);
		return (List<MIS>) query.getResultList();
	}

	@Override
	public boolean saveMISData(List<MIS> misList) {
		
		if(misList.size() > 0) {
			for(MIS mis : misList) {
				
				if(isExist(mis)) {
					continue;
				}else {
					entityManager.persist(mis);
				}
			}
			
			return true;
		}
		return false;
	}
	
	
	
	private boolean isExist(MIS mis) {
		
		if(mis != null) {
			
			String hql = "FROM com.rdsms.entity.MIS as m WHERE date = :date AND operator = :operator AND location = :location"
					+ " AND chatId = :chatId AND bni = :bni AND type = :type AND totalCalls = :totalCalls AND failedCalls = :failedCalls";
			Query query  = entityManager.createQuery(hql);
			query.setParameter("date", mis.getDate());
			query.setParameter("operator", mis.getOperator());
			query.setParameter("location", mis.getLocation());
			query.setParameter("chatId", mis.getChatId());
			query.setParameter("bni", mis.getBni());
			query.setParameter("type", mis.getType());
			query.setParameter("totalCalls", mis.getTotalCalls());
			query.setParameter("failedCalls", mis.getFailedCalls());
			
			int count  = query.getResultList().size();
			System.out.println("IsExist Count :: "+count);
			if(count >= 1) {
				return true;
			}
		}
		
		return false;
	}

	
/*	public List<MIS> getMisByPageSize(int page) {
		Sort sort = new Sort(new Sort.Order(Direction.ASC, "id"));
		Pageable pageable = new PageRequest(page-1, PAGE_SIZE, sort);
		return repository.findAll(pageable).getContent();
	}*/
	
	

}
