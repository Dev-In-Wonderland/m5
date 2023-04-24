package com.jpac_project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jpac_project.model.User;
import com.jpac_project.repository.UserDaoRepository;


@Service
public class UserService {
	
	@Autowired private UserDaoRepository repo;

	@Autowired @Qualifier("FakeUser") private ObjectProvider<User> fakeUserProvider; 
	@Autowired @Qualifier("AdminUser") private ObjectProvider<User> adminUserProvider;

	public void createFakeUser() { 
		insertUser(fakeUserProvider.getObject());
	}
	
	public void createAdminUser() { 
		insertUser(adminUserProvider.getObject());
	}
	
	// JDBC method
	
	public void insertUser(User u) {
		repo.save(u);
	}
	
	public User findUserByID(Long id) {
		return repo.findById(id).get();
	}
	
	public List<User> findAllUser() {
		return (List<User>) repo.findAll();
	}
	
	public void removeUser(User u) {
		repo.delete(u);
		//repo.deleteById(u.getId());
	}
	
	public void updateUser(User u) {
		repo.save(u);
	}
	
	public List<User> findAgeOver(Integer age) {
		return repo.findByAgeOverParams(age);
	}
	
	public List<User> findCityIn() {
		return repo.findByCityInR_M_N();
	}
}
