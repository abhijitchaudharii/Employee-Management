package com.empsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.empsystem.entity.Employee;
import com.empsystem.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		 List<Employee>emp =service.getAllEmp();
			 m.addAttribute("emp",emp);
			return "index";
	
	}
	
	@GetMapping("/addemp")
	public String addEmp() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee Added Sucessfully...");
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m){
		Employee e = service.getEmpById(id);
		m.addAttribute("emp", e);
		//System.out.println(id);
		return "edit";
	}
	
	@PostMapping("/update/{id}")
	public String updateEmp(@PathVariable int id, @ModelAttribute Employee e, HttpSession session) {
		 service.addEmp(e);
		 session.setAttribute("msg", "Emp Data Update Sucessfully.."); 
		 return "redirect:/"; 
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		service.deleteEMp(id);
		session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/";
	}
	
	
}
