package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Salary;

public interface SalaryService {

	Salary addSalary(Salary salary);

	Salary updateSalary(Salary salary);

	String deleteById(Long id);

	List<Salary> displayAll();

	Salary displayById(Long id);

	List<Salary> findByName(String sname);

	List<Salary> findByType(String type);
}