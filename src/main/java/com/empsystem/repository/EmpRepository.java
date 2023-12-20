package com.empsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empsystem.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
