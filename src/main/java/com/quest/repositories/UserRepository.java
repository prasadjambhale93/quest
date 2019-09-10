package com.quest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findAllByOrderByCreatedDate();
	public User findByPpsNumber(String ppsNumber);
}
