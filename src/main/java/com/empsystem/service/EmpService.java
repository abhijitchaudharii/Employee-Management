package com.empsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.empsystem.entity.Employee;
import com.empsystem.repository.EmpRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpService {

	@Autowired
	private EmpRepository repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
	}
	
	public List<Employee> getAllEmp() {
		return repo.findAll();
	}
	
	public Employee getEmpById(int id) {
		Optional <Employee> e =repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void deleteEMp(int id) {
		repo.deleteById(id);
	}
	
	public void removeSessionMessage() {
	    HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();

	    session.removeAttribute("msg");
	}
}
