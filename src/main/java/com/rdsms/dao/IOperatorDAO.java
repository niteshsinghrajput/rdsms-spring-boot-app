package com.rdsms.dao;

import java.util.List;

import com.rdsms.entity.Operator;

/**
 * 
 * @author Nitesh
 *
 */
public interface IOperatorDAO {
	
	List<Operator> getOperators();
	Operator getOperatorById(int oepratorId);
	Operator createOperator(Operator operator);
	Operator updateOperator(int operatorId, Operator operator);
	boolean deleteOperator(int operatorId);

}
