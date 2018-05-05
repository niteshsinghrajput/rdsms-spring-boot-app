package com.rdsms.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rdsms.entity.Role;
import com.rdsms.entity.User;

@Transactional
@Repository
public class RdsmsDAO implements IRdsmsDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoles() {
		
		String hql = "FROM com.rdsms.entity.Role as r ORDER BY r.roleId";
		return (List<Role>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Role createRole(Role role) {
		entityManager.persist(role);
		Role lastInsertedRole = getLastInsertedRole();
		return lastInsertedRole;
	}
	
	@Override
	public Role getRoleByRoleId(int roleId) {
		return entityManager.find(Role.class, roleId);
	}
	
	private Role getLastInsertedRole() {
		
		String hql = "FROM Role order by roleId DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Role role = (Role)query.getSingleResult();
		return role;
	}
	
	@Override
	public Role updateRole(int roleId,Role role) {
		
		//Get Role from Database
		Role existingRole = getRoleByRoleId(roleId);
		
		//set new values in existing role
		existingRole.setRoleName(role.getRoleName());
		existingRole.setDescription(role.getDescription());
		existingRole.setActive(role.isActive());
		
		entityManager.flush();
		return getRoleByRoleId(roleId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {

		String hql = "FROM com.rdsms.entity.User as u ORDER BY u.userId";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User createUser(User user) {
		
		Set<Role> roles = new HashSet<Role>();
		for(Role r : user.getRoles()) {
			Role role = entityManager.find(Role.class, r.getRoleId());
			roles.add(role);
		}
		user.setRoles(roles);
		entityManager.persist(user);
		User lastInsertedUser = getLastInsertedUser();
		return lastInsertedUser;
	}
	
	private User getLastInsertedUser(){
		
		String hql = "FROM User order by userId DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		User user = (User)query.getSingleResult();
		return user;
	}
	
	@Override
	public boolean deleteRole(int roleId) {
		
		Role role = getRoleByRoleId(roleId);
		entityManager.remove(role);
		
		List<User> users = getUsers();
		for(User user : users) {
			user.getRoles().remove(role);
		}
		entityManager.flush();
		
		boolean status = entityManager.contains(role);
		if(status)
			return false;
		else
			return true;
	}
	
	@Override
	public User getUserByUserId(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public User updateUser(int userId, User user) {

		Set<Role> roles = user.getRoles();
		Set<Role> updatedRoles = new HashSet<Role>();
		for(Role role:roles) {
			Role r = getRoleByRoleId(role.getRoleId());
			updatedRoles.add(r);
		}
		
		User existingUser = getUserByUserId(userId);
		existingUser.setName(user.getName());
		existingUser.setUserName(user.getUserName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAddress(user.getAddress());
		existingUser.setCity(user.getCity());
		existingUser.setMobile(user.getMobile());
		existingUser.setDistrict(user.getDistrict());
		existingUser.setPassword(user.getPassword());
		existingUser.setPostalCode(user.getPostalCode());
		existingUser.setRoles(updatedRoles);
		entityManager.flush();
		
		return getUserByUserId(userId);
	}

	@Override
	public boolean deleteUser(int userId) {
		
		User user = getUserByUserId(userId);
		Set<Role> roles = user.getRoles();
		for(Role role: roles) {
			role.getUsers().remove(user);
		}
		
		entityManager.remove(user);
		
		boolean status = entityManager.contains(user);
		if(status)
			return false;
		else
			return true;
	}
	
	
	
	
	

}
