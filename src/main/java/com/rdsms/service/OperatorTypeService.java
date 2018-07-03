package com.rdsms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdsms.dao.IOperatorTypeDAO;
import com.rdsms.entity.OperatorType;

/**
 * 
 * @author Nitesh
 *
 */

@Service
public class OperatorTypeService implements IOperatorTypeService {

	@Autowired
	private IOperatorTypeDAO dao;

	@Override
	public List<OperatorType> getOperatorTypes() {
		return dao.getOperatorTypes();
	}

	@Override
	public OperatorType getOperatorTypeByOperatorTypeId(int operatorTypeId) {
		return dao.getOperatorTypeByOperatorTypeId(operatorTypeId);
	}

	@Override
	public OperatorType createOperatorType(OperatorType operatorType) {
		return dao.createOperatorType(operatorType);
	}

	@Override
	public OperatorType updateOperatorType(int operatorTypeId, OperatorType operatorType) {
		return dao.updateOperatorType(operatorTypeId, operatorType);
	}

	@Override
	public boolean deleteOperatorType(int operatorTypeId) {
		return dao.deleteOperatorType(operatorTypeId);
	}

	@Override
	public List<OperatorType> getOperatorTypeByOperatorId(int operatorId) {
		return dao.getOperatorTypeByOperatorId(operatorId);
	}
	
	
	
	
}
