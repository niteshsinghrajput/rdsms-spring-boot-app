package com.rdsms.entity;
/**
 * @author Nitesh
 */



/**
 * @author Nitesh
 */

import java.io.Serializable;
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
@Table(name="director")
public class Director implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DirectorId")
	private int directorId;
	
	@Column(name="DirectorName")
	private String directorName;
	
	@Column(name="PhotoId")
	private String photoId;
	
	@Column(name="FatherName")
	private String fatherName;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="DateOfBirth")
	private Date dob;
	
	@Column(name="PrimaryMobile")
	private String primaryMobile;
	
	@Column(name="AlternateMobile")
	private String alternateMobile;
	
	@Column(name="BankName")
	private String bankName;
	
	@Column(name="BranchName")
	private String branchName;
	
	@Column(name="IfscCode")
	private String ifscCode;
	
	@Column(name="AccountNumber")
	private String accountNumber;
	
	@Column(name="IsActive")
	private boolean isActive;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="CreatedOn")
	private Date createdOn;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="UpdatedOn")
	private Date updatedOn;
	
	@ManyToOne
	@JoinColumn(name = "CreatedBy")
	User createdBy;
	
	@ManyToOne
	@JoinColumn(name="UpdatedBy")
	User updatedBy;

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPrimaryMobile() {
		return primaryMobile;
	}

	public void setPrimaryMobile(String primaryMobile) {
		this.primaryMobile = primaryMobile;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", photoId=" + photoId
				+ ", fatherName=" + fatherName + ", dob=" + dob + ", primaryMobile=" + primaryMobile
				+ ", alternateMobile=" + alternateMobile + ", bankName=" + bankName + ", branchName=" + branchName
				+ ", ifscCode=" + ifscCode + ", accountNumber=" + accountNumber + ", isActive=" + isActive
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + "]";
	}
	
	
}
