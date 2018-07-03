package com.rdsms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdsms.dao.IOperatorDAO;
import com.rdsms.entity.Operator;

/**
 * 
 * @author Nitesh
 *
 */

@Service
public class OperatorService implements IOperatorService{
	
	@Autowired
	private IOperatorDAO dao;

	@Override
	public List<Operator> getOperators() {
		return dao.getOperators();
	}

	@Override
	public Operator getOperatorById(int oepratorId) {
		return dao.getOperatorById(oepratorId);
	}

	@Override
	public Operator createOperator(Operator operator) {
		return dao.createOperator(operator);
	}

	@Override
	public Operator updateOperator(int operatorId, Operator operator) {
		return dao.updateOperator(operatorId, operator);
	}

	@Override
	public boolean deleteOperator(int operatorId) {
		return dao.deleteOperator(operatorId);
	}

}
