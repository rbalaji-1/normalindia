package com.base.normalindia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.base.normalindia.entity.Hospital;


public interface hospitalRepository extends JpaRepository<Hospital,Integer>,JpaSpecificationExecutor<Hospital>{
	
	
	
	@Query("SELECT u FROM Hospital u WHERE u.hospital_phone = ?1 ")
	Hospital findHospitalbyphone(String phonnumber);
	
	

	@Query("SELECT u FROM Hospital u WHERE u.pincode = ?1 ")
	List<Hospital> findHospitalbypin(String pincode);

}
