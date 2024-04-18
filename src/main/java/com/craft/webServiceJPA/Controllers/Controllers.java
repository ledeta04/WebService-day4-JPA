package com.craft.webServiceJPA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.craft.webServiceJPA.Model.Employee;
import com.craft.webServiceJPA.Service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class Controllers {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertData(@RequestBody Employee employee){
		
		return new ResponseEntity<>(employeeService.insert(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAllEmployee(){
		
		return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findbyIdEmp(@PathVariable("id") int id){
		
		try {
			return new ResponseEntity<>(employeeService.findById(id), HttpStatus.FOUND);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(employeeService.findById(id), HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping("/updatebyId/{id}")
	public ResponseEntity<?> updatebyId(@RequestBody Employee employee, @PathVariable("id") int id){
		
		return new ResponseEntity<>(employeeService.update(employee, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public ResponseEntity<?> deletebyId(@PathVariable("id") int id){
		
		try {
			
			return new ResponseEntity<>(employeeService.delete(id), HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(employeeService.delete(id), HttpStatus.NOT_FOUND);
		}
				
	}
	
	@GetMapping("/findBySalary/{salary}")
	public ResponseEntity<?> getEmployeeBySalary(@PathVariable("salary") Double salary){
		
		return new ResponseEntity<>(employeeService.getEmployeeBySalary(salary), HttpStatus.OK);
	}
	
	@GetMapping("/findBySalaryandAge/{salary}/{age}")
	public ResponseEntity<?> getEmployeeBySalaryandAge(@PathVariable("salary") Double salary , @PathVariable("age") int age){
		
		
		return new ResponseEntity<>(employeeService.getEmployeeBySalaryandAge(salary, age), HttpStatus.OK);
	}
	
	@GetMapping("/findByEmailandAge/{age}")
	public ResponseEntity<?> getEmployeeByEmailandAge(@RequestParam(name = "email") String email , @PathVariable("age") int age){
		
		
		return new ResponseEntity<>(employeeService.getEmployeeByemailandage(email, age) , HttpStatus.FOUND);
	}
	
}
