package com.rdsms.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Nitesh
 *
 */

@Entity
@Table(name="Role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RoleId")
	private int roleId;
	
	@Column(name="RoleName")
	private String roleName;
	
	@Column(name="Description")
	private String description;
	
	
	@Column(name="IsActive")
	private boolean isActive;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) 
			return true;
		if(!(obj instanceof Role)) {
			return false;
		}
		
		Role role = (Role)obj;
		return role.roleId == roleId && role.roleName.equals(roleName) && role.isActive == isActive;
	}

	@Override
	public int hashCode() {
		int hash = 131;
		hash = 121 * hash * roleName.hashCode();
		hash = 131 * hash * description.hashCode();
		hash = 145 * hash;
		return hash;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description + ", isActive="
				+ isActive +  "]";
	}
	
}
