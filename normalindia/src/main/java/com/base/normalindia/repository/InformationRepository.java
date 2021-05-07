package com.base.normalindia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.normalindia.entity.Information;
import com.base.normalindia.entity.User;

@Repository
public interface InformationRepository extends JpaRepository<Information,Integer>{

	Optional<Information> findByinformationid(Integer information_id);
	
	
	

}
