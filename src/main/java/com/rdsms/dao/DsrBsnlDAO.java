package com.rdsms.dao;
/**
 * @author Nitesh
 */


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rdsms.entity.DsrBsnl;

@Repository
@Transactional
public class DsrBsnlDAO implements IDsrBsnlDAO {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<DsrBsnl> getDsr() {
		String hql = "FROM com.rdsms.entity.DsrBsnl db ORDER BY db.id";
		return (List<DsrBsnl>)em.createQuery(hql).getResultList();
	}

	@Override
	public boolean saveDsrBsnl(List<DsrBsnl> dsr) {
		
		if(dsr.size() > 0) {
			for(DsrBsnl d : dsr) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<DsrBsnl> getDsrBsnlByLocation(String location) {
		String hql = "FROM com.rdsms.entity.DsrBsnl as db WHERE location = :location ORDER BY db.id";
		Query query  = em.createQuery(hql);
		query.setParameter("location", location);
		return (List<DsrBsnl>) query.getResultList();
	}
	
	private boolean isExist(DsrBsnl ds) {
		
		if(ds != null) {
			
			String hql = "FROM com.rdsms.entity.DsrBsnl as db WHERE location = :location AND chatId = :chatId "
					+ "AND agentNo = :agentNo AND vendor = :vendor AND totalCalls = :totalCalls AND failedCalls = :failedCalls "
					+ "AND currentDate = :currentDate AND lastLoginLogoutTime = :lastLoginLogoutTime AND loginLogoutTimeMins = :loginLogoutTimeMins "
					+ "AND time = :time AND unAnsweredCalls = :unAnsweredCalls AND switchedOff = :switchedOff AND networkIssue = :networkIssue "
					+ "AND mou = :mou AND userBusy = :userBusy ORDER BY db.id";
			
			Query query  = em.createQuery(hql);
			query.setParameter("location", ds.getLocation());
			query.setParameter("chatId", ds.getChatId());
			query.setParameter("agentNo", ds.getAgentNo());
			query.setParameter("vendor", ds.getVendor());
			query.setParameter("totalCalls", ds.getTotalCalls());
			query.setParameter("failedCalls", ds.getFailedCalls());
			query.setParameter("currentDate", ds.getCurrentDate());
			query.setParameter("lastLoginLogoutTime", ds.getLastLoginLogoutTime());
			query.setParameter("loginLogoutTimeMins", ds.getLoginLogoutTimeMins());
			query.setParameter("time", ds.getTime());
			query.setParameter("unAnsweredCalls", ds.getUnAnsweredCalls());
			query.setParameter("switchedOff", ds.getSwitchedOff());
			query.setParameter("networkIssue", ds.getNetworkIssue());
			query.setParameter("mou", ds.getMou());
			query.setParameter("userBusy", ds.getUserBusy());
			
			int count  = query.getResultList().size();
			if(count >= 1) {
				return true;
			}
		}
		
		return false;
	}
	

}
