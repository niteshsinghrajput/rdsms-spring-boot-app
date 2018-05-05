package com.rdsms.dao;

import java.util.List;

import com.rdsms.entity.DsrVodafone;

public interface IDsrVodafoneDAO {
	
	List<DsrVodafone> getVodafoneDsr();
	List<DsrVodafone> getVodafoneDsrByLocation(String location);
	boolean saveDsrVodafone(List<DsrVodafone> dsr);

}
