package com.manager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.model.Employee;
import com.manager.model.Manager;

@Repository
public interface ManagerRepo extends JpaRepository<Manager, Integer>{

	List<Employee> findBymanId(int manId);
}
