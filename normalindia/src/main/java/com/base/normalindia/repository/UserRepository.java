package com.base.normalindia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.normalindia.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	Optional<User> findByphonenumber(String phonenumber);

}
