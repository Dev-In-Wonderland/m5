package com.jdbc_project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jdbc_project.model.User;
import com.jdbc_project.repository.UserJDBCDao;

@Service
public class UserService {
	
	@Autowired UserJDBCDao jdbcDao;
	
	@Autowired @Qualifier("FakeUser") private ObjectProvider<User> fakeUserProvider; 
	@Autowired @Qualifier("AdminUser") private ObjectProvider<User> adminUserProvider;
	
	public void createFakeUser() { 
		insertUser(fakeUserProvider.getObject());
	}
	
	public User createAdminUser() { 
		insertUser(adminUserProvider.getObject());
		return null;
	}
	
	public User createCustomUser() { 
		
		return null;
	}
	
	public User createUser(String name, String lastname, String email, 
			Integer age, String city, String password) { 
		return null;
	}
	
	// JDBC method
	
	public void insertUser(User u) {
		jdbcDao.create(u);
	}
	
	public User findUserByID(Long id) {
		return jdbcDao.getById(id);
	}
	
	public List<User> findAllUser() {
		return jdbcDao.getAllUser();
	}
	
	public void removeUser(Long id) {
		jdbcDao.delete(id);
	}
	
	public void updateUser(User u) {
		jdbcDao.update(u);
	}

}
