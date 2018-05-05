package com.rdsms.service;

/**
 * @author Nitesh
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdsms.dao.IMisDAO;
import com.rdsms.entity.MIS;
@Service
public class MISService implements IMISService {
	
	
	@Autowired
	private IMisDAO misDao;
	
	@Override
	public List<MIS> getMISData() {
		return misDao.getMISData();
	}

	@Override
	public boolean saveMISData(List<MIS> misDataList) {
		return misDao.saveMISData(misDataList);
	}
	
	@Override
	public List<MIS> getMISDataByLocation(String location){
		return misDao.getMISDataByLocation(location);
	}
	
	/*public List<MIS> getMisByPageSize(int page) {
		return misDao.getMisByPageSize(page);
	}*/

}
