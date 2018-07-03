package com.rdsms.service;

import java.util.List;
import com.rdsms.entity.OperatorType;

/**
 * 
 * @author Nitesh
 *
 */

public interface IOperatorTypeService {
	
	List<OperatorType> getOperatorTypes();
	OperatorType getOperatorTypeByOperatorTypeId(int operatorTypeId);
	List<OperatorType> getOperatorTypeByOperatorId(int operatorId);
	OperatorType createOperatorType(OperatorType operatorType);
	OperatorType updateOperatorType(int operatorId, OperatorType operatorType);
	boolean deleteOperatorType(int operatorTypeId);

}
