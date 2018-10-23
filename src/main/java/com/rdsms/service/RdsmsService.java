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
import com.rdsms.repository.RoleRepository;
import com.rdsms.repository.UserRepository;

@Service
public class RdsmsService implements IRdsmsService {
	
	@Autowired
	private IRdsmsDAO dao;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public List<Role> getRoles() {
		
		return roleRepo.findAll();
	}
	
	@Override
	public Role createRole(Role role) {
		return roleRepo.save(role);
	}
	
	@Override
	public Role updateRole(Long roleId, Role role) {
		Role existingRole = roleRepo.findByRoleId(roleId);
		existingRole.setRoleName(role.getRoleName());
		existingRole.setDescription(role.getDescription());
		existingRole.setActive(role.isActive());
		return roleRepo.save(role);
	}
	
	@Override
	public boolean deleteRole(Long roleId) {
		Role role = roleRepo.findByRoleId(roleId);
		roleRepo.delete(role);
		if(!roleRepo.existsById(roleId)) {
			return true;
		}
		return false;
	}
	
	@Override
	public Role getRoleByRoleId(Long roleId) {
		return roleRepo.getOne(roleId);
	}

	@Override
	public List<User> getUsers() {
		return repo.findAll();
	}

	@Override
	public User createUser(User user) {
		
		return repo.save(user);
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
	
	@Override
	public boolean validateUserName(User user) {
		
		if(repo.existsByUserName(user.getUserName())) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean validateEmail(User user) {
		
		if(repo.existsByEmail(user.getEmail())) {
			return false;
		}
		return true;
	}
	
	@Override
	public User getUserByEmail(String email) {
		return repo.findByEmail(email).get();
	}
	
	
	}
