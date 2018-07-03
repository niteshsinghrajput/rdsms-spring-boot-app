package com.rdsms.service;

import java.util.List;

import com.rdsms.entity.Operator;

/**
 * 
 * @author Nitesh
 *
 */

public interface IOperatorService {
	
	List<Operator> getOperators();
	Operator getOperatorById(int operatorId);
	Operator createOperator(Operator operator);
	Operator updateOperator(int operatorId, Operator operator);
	boolean deleteOperator(int operatorId);
}
