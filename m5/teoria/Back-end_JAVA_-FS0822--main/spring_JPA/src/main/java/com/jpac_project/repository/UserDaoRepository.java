package com.jpac_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpac_project.model.User;

@Repository
public interface UserDaoRepository extends CrudRepository<User, Long> {
	
	public List<User> findByCity(String city);
	public List<User> findByEmail(String email);
	public List<User> findByNameAndLastname(String name, String lastname);
	public List<User> findByAgeBetween(Integer min, Integer max);
	
	@Query(value="SELECT u FROM User u WHERE u.city IN ('Roma', 'Milano', 'Napoli')") 
		public List<User> findByCityInR_M_N();

	@Query(value = "SELECT u FROM User u WHERE u.age > :age")
		public List<User> findByAgeOverParams(Integer age);
}
