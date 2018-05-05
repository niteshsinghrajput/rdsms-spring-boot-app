package com.rdsms.service;

import java.util.List;

import com.rdsms.entity.DsrBsnl;
import com.rdsms.entity.DsrVodafone;

public interface IDSRService {
	
	public List<DsrBsnl> getDsr();
	public boolean saveDsrBsnl(List<DsrBsnl> dsr);
	public List<DsrBsnl> getDsrBsnlByLocation(String location);
	public List<DsrVodafone> getDsrVodafone();
	public boolean saveDsrVodafone(List<DsrVodafone> dsr);
	public List<DsrVodafone> getDsrVodafoneByLocation(String location);

}
