package com.rdsms.service;

import java.util.List;

import com.rdsms.entity.MIS;

public interface IMISService {
	
	List<MIS> getMISData();
	boolean saveMISData(List<MIS> misDataList);
	List<MIS> getMISDataByLocation(String location);

}
