package com.rdsms.entity;

/**
 * @author Nitesh
 */
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name="id")
public class ID {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="IdNumber")
	private String idNumber;
	
	@Column(name="Mobile")
	private String mobile;
	
	@Column(name="IsActive")
	private boolean isActive;
	
	@Column(name="IsAvailable")
	private boolean isAvailable;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="createdOn")
	private Date createdOn;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="updatedOn")
	private Date updatedOn;
	
	@ManyToOne
	@JoinColumn(name = "CreatedBy")
	User createdBy;
	
	@ManyToOne
	@JoinColumn(name="UpdatedBy")
	User updatedBy;
	
	@ManyToOne
	@JoinColumn(name="BranchId")
	Branch rdbranch;
	
	@ManyToOne
	@JoinColumn(name="OperatorId")
	Operator operator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
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

	public Branch getRdbranch() {
		return rdbranch;
	}

	public void setRdbranch(Branch rdbranch) {
		this.rdbranch = rdbranch;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "ID [id=" + id + ", idNumber=" + idNumber + ", mobile=" + mobile + ", isActive=" + isActive
				+ ", isAvailable=" + isAvailable + "]";
	}

}
