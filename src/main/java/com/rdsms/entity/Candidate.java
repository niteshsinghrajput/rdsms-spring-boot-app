package com.rdsms.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Nitesh
 *
 */

@Entity
@Table(name="candidate")
public class Candidate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CandidateId")
	private int candidateId;
	@Column(name="Name")
	private String name;
	@Column(name="FatherName")
	private String fatherName;
	@Column(name="MotherName")
	private String motherName;
	@Column(name="DOB")
	private Date dob;
	@Column(name="Address")
	private String address;
	@Column(name="Landmark")
	private String landmark;
	@Column(name="City")
	private String city;
	@Column(name="District")
	private String district;
	@Column(name="State")
	private String state;
	@Column(name="PostalCode")
	private String postalCode;
	@Column(name="Religion")
	private String religion;
	@Column(name="Category")
	private String category;
	@Column(name="Nationality")
	private String nationality;
	@Column(name="KnownLanguages")
	private String knownLanguages;
	@Column(name="PrimaryMobile")
	private String primaryMobile;
	@Column(name="AlternateMobile")
	private String alternateMobile;
	@Column(name="PhotoId")
	private String photoId;
	@Column(name="Bank")
	private String bank;
	@Column(name="Branch")
	private String branch;
	@Column(name="IfscCode")
	private String ifscCode;
	@Column(name="AccountNumber")
	private String accountNumber;
	@Column(name="IsActive")
	private boolean isActive;
	@Column(name="createdOn")
	private Date createdOn;
	@Column(name="updatedOn")
	private Date updatedOn;
	
	@ManyToOne
	@JoinColumn(name = "CreatedBy")
	User createdBy;
	
	@ManyToOne
	@JoinColumn(name="UpdatedBy")
	User updatedBy;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="BranchId")
	Branch rdbranch;

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getKnownLanguages() {
		return knownLanguages;
	}

	public void setKnownLanguages(String knownLanguages) {
		this.knownLanguages = knownLanguages;
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

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Branch getRdbranch() {
		return rdbranch;
	}

	public void setRdbranch(Branch rdbranch) {
		this.rdbranch = rdbranch;
	}

	/*@Override
	public boolean equals(Object obj) {
		if(obj == this) 
			return true;
		if(!(obj instanceof Candidate)) {
			return false;
		}
		
		Candidate candidate = (Candidate) obj;
		return candidate.candidateId == candidateId && candidate.name.equals(name) && candidate.accountNumber.equals(accountNumber)
				&& candidate.postalCode.equals(postalCode) && candidate.dob.equals(dob);
	}
	
	@Override
	public int hashCode() {
		int hash = 121;
		hash = 21 * hash * candidateId;
		hash = 21 * hash * name.hashCode();
		hash = 21 * hash * dob.hashCode();
		return hash;
	}*/

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", name=" + name + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", dob=" + dob + ", address=" + address + ", landmark=" + landmark
				+ ", city=" + city + ", district=" + district + ", state=" + state + ", postalCode=" + postalCode
				+ ", religion=" + religion + ", category=" + category + ", nationality=" + nationality
				+ ", knownLanguages=" + knownLanguages + ", primaryMobile=" + primaryMobile + ", alternateMobile="
				+ alternateMobile + ", photoId=" + photoId + ", bank=" + bank + ", branch=" + branch + ", ifscCode="
				+ ifscCode + ", accountNumber=" + accountNumber + ", isActive=" + isActive + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", rdbranch="
				+ rdbranch + "]";
	}

}
