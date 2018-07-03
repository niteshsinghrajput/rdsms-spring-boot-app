package com.rdsms.dao;

import java.util.List;
import com.rdsms.entity.OperatorType;

/**
 * 
 * @author Nitesh
 *
 */

public interface IOperatorTypeDAO {
	
	List<OperatorType> getOperatorTypes();
	OperatorType getOperatorTypeByOperatorTypeId(int operatorTypeId);
	List<OperatorType> getOperatorTypeByOperatorId(int operatorId);
	OperatorType createOperatorType(OperatorType operatorType);
	OperatorType updateOperatorType(int operatorTypeId, OperatorType operatorType);
	boolean deleteOperatorType(int operatorTypeId);

}
