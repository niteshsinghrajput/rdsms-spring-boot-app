package com.rdsms.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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

@Entity
@Table(name="branch")
public class Branch implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BranchId")
	private int branchId;
	
	@Column(name="BranchName")
	private String branchName;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="City")
	private String city;
	
	@Column(name="District")
	private String district;
	
	@Column(name="IsActive")
	private boolean isActive;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="CreatedOn")
	private Date createdOn;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="UpdatedOn")
	private Date updatedOn;
	
	@ManyToOne
	@JoinColumn(name = "DirectorId")
	Director director;
	
	@ManyToOne
	@JoinColumn(name = "CreatedBy")
	User createdBy;
	
	@ManyToOne
	@JoinColumn(name="UpdatedBy")
	User updatedBy;
	
	@JsonIgnore
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
	private Set<Branch> branches;
	
	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
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

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", address=" + address + ", city=" + city
				+ ", district=" + district + ", isActive=" + isActive + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + ", director=" + director + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}
	
}
