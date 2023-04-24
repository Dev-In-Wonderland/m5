package com.jdbc_project.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jdbc_project.model.User;

@Repository
public interface UserDaoRepository {
	
	public void create(User user);
	public void update(User user);
	public void delete(Long id);
	public User getById(Long id);
	public List<User> getAllUser(); 

}
