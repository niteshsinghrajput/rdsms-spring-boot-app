package com.rdsms.entity;

/**
 * @author Nitesh
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="operator_types")
public class OperatorType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OperatorTypeId")
	private int operatorTypeId;
	
	@Column(name="OperatorType")
	private String operatorType;
	
	@Column(name="IsActive")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="OperatorId")
	private Operator operator;

	public int getOperatorTypeId() {
		return operatorTypeId;
	}

	public void setOperatorTypeId(int operatorTypeId) {
		this.operatorTypeId = operatorTypeId;
	}

	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "OperatorType [operatorTypeId=" + operatorTypeId + ", operatorType=" + operatorType + ", isActive="
				+ isActive + ", operator=" + operator + "]";
	}
	

}
