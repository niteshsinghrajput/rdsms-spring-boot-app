package com.rdsms.dao;

/**
 * @author Nitesh
 */

import java.util.List;
import com.rdsms.entity.ID;

public interface IdDAO {
	
	List<ID> getIDs();
	List<ID> getIDsByBranch(int branchId);
	List<ID> getAvailableIDsByBranch(int branchId);
	List<ID> getIDsByOperator(int operatorId);
	
	ID getID(int id);
	ID createId(ID id);
	ID updateId(int id, ID idData);
	boolean deleteId(int id);

}
