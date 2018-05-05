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

import com.rdsms.entity.DsrVodafone;

@Repository
@Transactional
public class DsrVodafoneDAO implements IDsrVodafoneDAO {
	
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<DsrVodafone> getVodafoneDsr() {
		
		String hql = "FROM com.rdsms.entity.DsrVodafone as d ORDER BY d.id";
		return em.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DsrVodafone> getVodafoneDsrByLocation(String location) {
		String hql = "FROM com.rdsms.entity.DsrVodafone as d WHERE location = :location ORDER BY d.id";
		Query query = em.createQuery(hql);
		query.setParameter("location", location);
		return query.getResultList();
	}

	@Override
	public boolean saveDsrVodafone(List<DsrVodafone> dsr) {
		
		if(dsr.size()>0) {
			for(DsrVodafone d : dsr) {
				if(isExist(d)) {
					continue;
				}else {
					em.persist(d);
				}
			}
			return true;
		}
		return false;
	}
	
	private boolean isExist(DsrVodafone dv) {
		
		String hql = "FROM com.rdsms.entity.DsrVodafone as d WHERE location = :location AND agentLocation = :agentLocation "
				+ "AND circle = :circle AND reportDateTime = :reportDateTime AND detailHours = :detailHours ORDER BY d.id";
		Query query = em.createQuery(hql);
		query.setParameter("location", dv.getLocation());
		query.setParameter("agentLocation", dv.getAgentLocation());
		query.setParameter("circle", dv.getCircle());
		query.setParameter("reportDateTime", dv.getReportDateTime());
		query.setParameter("detailHours", dv.getDetailHours());
		
		
		
		return false;
	}

}
