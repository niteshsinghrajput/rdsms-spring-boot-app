package com.rdsms.dao;
import java.util.List;

import com.rdsms.entity.MIS;

public interface IMisDAO {
	
	List<MIS> getMISData();
	boolean saveMISData(List<MIS> misList);
	List<MIS> getMISDataByLocation(String location);
	//List<MIS> getMisByPageSize(int page);
}
