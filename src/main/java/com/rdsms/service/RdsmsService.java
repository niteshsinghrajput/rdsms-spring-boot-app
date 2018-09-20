package com.rdsms.service;

/**
 * @author Nitesh
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdsms.dao.IRdsmsDAO;
import com.rdsms.entity.Role;
import com.rdsms.entity.User;

@Service
public class RdsmsService implements IRdsmsService {
	
	@Autowired
	private IRdsmsDAO dao;

	@Override
	public List<Role> getRoles() {
		
		return dao.getRoles();
	}
	
	@Override
	public Role createRole(Role role) {
		return dao.createRole(role);
	}
	
	@Override
	public Role updateRole(Long roleId, Role role) {
		return dao.updateRole(roleId, role);
	}
	
	@Override
	public boolean deleteRole(Long roleId) {
		return dao.deleteRole(roleId);
	}
	
	@Override
	public Role getRoleByRoleId(Long roleId) {
		return dao.getRoleByRoleId(roleId);
	}
	
	

	@Override
	public List<User> getUsers() {
		return dao.getUsers();
	}

	@Override
	public User createUser(User user) {
		return dao.createUser(user);
	}

	@Override
	public User updateUser(Long userId, User user) {
		return dao.updateUser(userId, user);
	}

	@Override
	public boolean deleteUser(Long userId) {
		return dao.deleteUser(userId);
	}
	
	@Override
	public User getUserByUserId(Long userId) {
		return dao.getUserByUserId(userId);
	}
	
	
}
