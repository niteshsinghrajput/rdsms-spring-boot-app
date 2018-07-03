package com.rdsms.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 
 * @author Nitesh
 *
 */

@Entity
@Table(name="operator")
public class Operator implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OperatorId")
	private int operatorId;
	
	@Column(name="OperatorName")
	private String operatorName;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="IsActive")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "createdBy")
	User createdBy;
	
	@ManyToOne
	@JoinColumn(name="updatedBy")
	User updatedBy;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="CreatedOn")
	private Date createdOn;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="UpdatedOn")
	private Date updatedOn;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "operatorTypeId")
	private Set<OperatorType> operatorType;

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	
	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	public Set<OperatorType> getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Set<OperatorType> operatorType) {
		this.operatorType = operatorType;
	}

	@Override
	public String toString() {
		return "Operator [operatorId=" + operatorId + ", operatorName=" + operatorName + ", description=" + description
				+ ", isActive=" + isActive + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", operatorType=" + operatorType + "]";
	}
	
}
