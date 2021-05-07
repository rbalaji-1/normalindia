package com.base.normalindia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.normalindia.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report,Integer>{

}
