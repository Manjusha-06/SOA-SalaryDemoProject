package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Salary;
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

	List<Salary> findByName(String sname);
	List<Salary> findByType(String type);
}
