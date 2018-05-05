package com.rdsms.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 
 * @author Nitesh
 *
 */

@Entity
@Table(name="User")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId")
	private int userId;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Username")
	private String userName;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Mobile")
	private String mobile;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="City")
	private String city;
	
	@Column(name="District")
	private String district;
	
	@Column(name="PostalCode")
	private String postalCode;
	
	@Column(name="IsActive")
	private boolean isActive;
	
	@ManyToMany(cascade = { CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinTable(	name = "user_roles", joinColumns = @JoinColumn(name = "UserId"), 
				inverseJoinColumns = @JoinColumn(name = "RoleId"))
	private Set<Role> roles;
	
	@JsonIgnore
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
	private Set<Candidate> candidates;
	
	@JsonIgnore
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
	private Set<Branch> branches;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Set<Branch> getBranches() {
		return branches;
	}

	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)return true;
		if(!(obj instanceof User)) {
			return false;
		}
		User user = (User)obj;
		return user.name.equals(name) && user.email.equals(email) && user.userId == userId;
	}

	@Override
	public int hashCode() {
		
		int hashCode = 19;
		hashCode = 31 * name.hashCode();
		hashCode = 31 * email.hashCode();
		hashCode = 31 * userId;
		return hashCode;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", userName=" + userName
				+ ", password=" + password + ", mobile=" + mobile + ", address=" + address + ", city=" + city
				+ ", district=" + district + ", postalCode=" + postalCode + ", isActive=" + isActive + ", roles="
				+ roles + ", candidates=" + candidates + ", branches=" + branches + "]";
	}
	
	
}
