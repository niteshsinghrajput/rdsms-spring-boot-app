package com.rdsms.dao;

import java.util.List;

import com.rdsms.entity.DsrBsnl;

public interface IDsrBsnlDAO {
	
	List<DsrBsnl> getDsr();
	boolean saveDsrBsnl(List<DsrBsnl> dsr);
	List<DsrBsnl> getDsrBsnlByLocation(String location);

}
