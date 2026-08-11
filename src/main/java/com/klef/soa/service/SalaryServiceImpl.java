package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Salary;
import com.klef.soa.repository.SalaryRepository;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository repo;

    @Override
    public Salary addSalary(Salary salary) {

        return repo.save(salary);
    }

    @Override
    public Salary updateSalary(Salary salary) {

        Optional<Salary> optional = repo.findById(salary.getId());

        if (optional.isPresent()) {

            Salary existingSalary = optional.get();

            existingSalary.setName(salary.getName());
            existingSalary.setType(salary.getType());
            existingSalary.setStatus(salary.getStatus());
            existingSalary.setLocation(salary.getLocation());

            return repo.save(existingSalary);
        }

        return null;
    }

    @Override
    public String deleteById(Long id) {

        Optional<Salary> optional = repo.findById(id);

        if (optional.isPresent()) {

            repo.deleteById(id);

            return "Salary deleted successfully";
        }

        return "Salary ID not found";
    }

    @Override
    public List<Salary> displayAll() {

        return repo.findAll();
    }

    @Override
    public Salary displayById(Long id) {

        Optional<Salary> optional = repo.findById(id);

        if (optional.isPresent()) {

            return optional.get();
        }

        return null;
    }

	@Override
	public List<Salary> findByName(String sname) {
		return repo.findByName(sname);
	}

	@Override
	public List<Salary> findByType(String type) {
		 return repo.findByType(type);
	}
}