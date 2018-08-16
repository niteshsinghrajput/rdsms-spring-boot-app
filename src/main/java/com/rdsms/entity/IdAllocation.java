package com.rdsms.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name="id_allocation")
public class IdAllocation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IssueId")
	private int issueId;
	
	@OneToOne
	@JoinColumn(name="Id")
	private ID idd;
	
	@ManyToOne
	@JoinColumn(name = "CandidateId")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name = "issuedBy")
	private User createdBy;
	
	@ManyToOne
	@JoinColumn(name="updatedBy")
	private User updatedBy;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="issuedOn")
	private Date createdOn;
	
	@JsonDeserialize(using = com.rdsms.utils.CustomDateConvertor.class)
	@Column(name="lastUpdatedOn")
	private Date updatedOn;
	
	@Column(name="isActive")
	private boolean isActive;
	
	
	public IdAllocation() {
	
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public ID getIdd() {
		return idd;
	}

	public void setIdd(ID idd) {
		this.idd = idd;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "IdAllocation [issueId=" + issueId + ", idd=" + idd + ", candidate=" + candidate + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ ", isActive=" + isActive + "]";
	}
	
}
