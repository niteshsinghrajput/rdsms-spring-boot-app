package com.rdsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdsms.entity.Operator;
import com.rdsms.entity.OperatorType;
import com.rdsms.service.IOperatorService;
import com.rdsms.service.IOperatorTypeService;

/**
 * 
 * @author Nitesh
 *
 */

@Controller
@RequestMapping("operatorservice")
public class OperatorController {
	
	@Autowired
	private IOperatorService service;
	
	@Autowired
	private IOperatorTypeService operatorTypeService;
	
	@GetMapping("/operators")
	public ResponseEntity<List<Operator>> getOperators() {
		List<Operator> operators = service.getOperators();
		return new ResponseEntity<List<Operator>>(operators, HttpStatus.OK);
	}
	
	@GetMapping("/operators/{operatorId}")
	public ResponseEntity<Operator> getOperatorById(@PathVariable("operatorId") int operatorId) {
		Operator operator = service.getOperatorById(operatorId);
		return new ResponseEntity<Operator>(operator, HttpStatus.OK);
	}
	
	@PostMapping("/operators")
	public ResponseEntity<Operator> createOperator(@RequestBody Operator operator){
		Operator op = service.createOperator(operator);
		return new ResponseEntity<Operator>(op,HttpStatus.OK);
	}
	
	@PutMapping("/operators/{operatorId}")
	public ResponseEntity<Operator> updateOperator(@PathVariable("operatorId") int operatorId, @RequestBody Operator operator) {
		Operator updatedOperator = service.updateOperator(operatorId, operator);
		return new ResponseEntity<Operator>(updatedOperator,HttpStatus.OK);
	}
	
	@DeleteMapping("/operators/{operatorId}")
	public ResponseEntity<String> deleteOperator(@PathVariable("operatorId") int operatorId) {
		String message;
		boolean isDeleted = service.deleteOperator(operatorId);
		if(isDeleted) {
			message = "Operator (id= "+ operatorId +" ) has been deleted successfully";
		}else {
			message = "Error while deleting Operator (id= "+ operatorId +" ) from database";
		}
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("/operatortypes")
	public ResponseEntity<List<OperatorType>> getOperatorTypes(){
		List<OperatorType> operatorTypes = operatorTypeService.getOperatorTypes();
		return new ResponseEntity<List<OperatorType>>(operatorTypes, HttpStatus.OK);
	}
	
	@GetMapping("/operatortypes/{operatorTypeId}")
	public ResponseEntity<OperatorType> getOperatorByOperatorTypeId(@PathVariable("operatorTypeId") int operatorTypeId) {
		OperatorType operatorType = operatorTypeService.getOperatorTypeByOperatorTypeId(operatorTypeId);
		return new ResponseEntity<OperatorType>(operatorType, HttpStatus.OK);
	}
	
	@PostMapping("/operatortypes")
	public ResponseEntity<OperatorType> createOperator(@RequestBody OperatorType operatorType){
		OperatorType op = operatorTypeService.createOperatorType(operatorType);
		return new ResponseEntity<OperatorType>(op,HttpStatus.OK);
	}
	
	@PutMapping("/operatortypes/{operatorTypeId}")
	public ResponseEntity<OperatorType> updateOperator(@PathVariable("operatorTypeId") int operatorTypeId, @RequestBody OperatorType operator) {
		OperatorType updatedOperator = operatorTypeService.updateOperatorType(operatorTypeId, operator);
		return new ResponseEntity<OperatorType>(updatedOperator,HttpStatus.OK);
	}
	
	@DeleteMapping("/operatortypes/{operatorTypeId}")
	public ResponseEntity<String> deleteOperatorType(@PathVariable("operatorTypeId") int operatorTypeId) {
		String message;
		boolean isDeleted = operatorTypeService.deleteOperatorType(operatorTypeId);
		System.out.println("Delete OperatorType Status :: "+isDeleted);
		if(isDeleted) {
			message = "OperatorType (id= "+ operatorTypeId +" ) has been deleted successfully";
		}else {
			message = "Error while deleting OperatorType (id= "+ operatorTypeId +" ) from database";
		}
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("/operatortype/{operatorId}")
	public ResponseEntity<List<OperatorType>> getOperatorTypesByOperatorId(@PathVariable("operatorId") int operatorId){
		List<OperatorType> types = operatorTypeService.getOperatorTypeByOperatorId(operatorId);
		return new ResponseEntity<List<OperatorType>>(types,HttpStatus.OK);
	}
}
