package com.base.normalindia.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.base.normalindia.entity.Organisation;

public interface OrganisationRepository  extends JpaRepository<Organisation,Integer>,JpaSpecificationExecutor<Organisation> {
//	
//	
//	@Query("SELECT o FROM Organisation o WHERE o.state = :state")
//	 List<Organisation> findByStateContaining(@Param("state") String state);
	
	
	
	

}
