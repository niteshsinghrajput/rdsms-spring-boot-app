package com.rdsms.service;

/**
 * @author Nitesh
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdsms.dao.IDsrBsnlDAO;
import com.rdsms.dao.IDsrVodafoneDAO;
import com.rdsms.entity.DsrBsnl;
import com.rdsms.entity.DsrVodafone;

@Service
public class DSRService implements IDSRService{
	
	@Autowired
	private IDsrBsnlDAO bsnlDao;
	
	@Autowired
	private IDsrVodafoneDAO vodaDao;
	

	@Override
	public List<DsrBsnl> getDsr() {
		return bsnlDao.getDsr();
	}

	@Override
	public boolean saveDsrBsnl(List<DsrBsnl> dsr) {
		return bsnlDao.saveDsrBsnl(dsr);
	}

	@Override
	public List<DsrBsnl> getDsrBsnlByLocation(String location) {
		return bsnlDao.getDsrBsnlByLocation(location);
	}

	@Override
	public List<DsrVodafone> getDsrVodafone() {
		return vodaDao.getVodafoneDsr();
	}

	@Override
	public boolean saveDsrVodafone(List<DsrVodafone> dsr) {
		return vodaDao.saveDsrVodafone(dsr);
	}

	@Override
	public List<DsrVodafone> getDsrVodafoneByLocation(String location) {
		return vodaDao.getVodafoneDsrByLocation(location);
	}

}
