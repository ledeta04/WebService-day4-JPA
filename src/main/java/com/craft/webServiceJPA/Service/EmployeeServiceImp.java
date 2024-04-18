package com.craft.webServiceJPA.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.webServiceJPA.JpaRepository.JpaRepo;
import com.craft.webServiceJPA.Model.AddInfo;
import com.craft.webServiceJPA.Model.Employee;



@Service
public class EmployeeServiceImp implements EmployeeService {
	
	
	@Autowired
	JpaRepo jpaRepo;

	@Override
	public Employee insert(Employee employee) {

		jpaRepo.save(employee);
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {

		jpaRepo.findAll();
		
		return jpaRepo.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		                                                                                                                                                                                                                                 
		Optional<Employee> optional = jpaRepo.findById(id);
		
		if(optional.isPresent()) {
			
			return optional.get();
		}
		
		return optional.orElseThrow();
	}

	@Override
	public Employee update(Employee employee, int id) {

		Optional<Employee> optional = jpaRepo.findById(id);
		
		if(optional.isPresent()) {
			
			//There is no update method for JPA so we have to perform this after we find data in database
			
			Employee employee2 = optional.get();
			
			employee2.setFullName(employee.getFullName());
			employee2.setSalary(employee.getSalary());
			employee2.setAge(employee.getAge());
			
			//nested data we have to create an Object separately using constructor or (setter using builder)
			AddInfo addInfo = new AddInfo(employee.getAddInfo().getEmail(), employee.getAddInfo().getSSN(), employee.getAddInfo().getPhoneNumber());
			
			//Or using builder create an Object no using new key word if we want to update only a few data
//			AddInfo addInfo2 = AddInfo.builder().email(employee.getAddInfo().getEmail())
//					
//					.SSN(employee.getAddInfo().getSSN())
//					.build();
			
			
			employee2.setAddInfo(addInfo);
			
			jpaRepo.save(employee2);
			
			return employee2;
		}
		
		return null;
	}

	@Override
	public String delete(int id) {
		
		Optional<Employee> optional = jpaRepo.findById(id);
		
		if(optional.isPresent()) {
			
			Employee employee = optional.get();
			
			jpaRepo.deleteById(id);
			
			return "data is removed";
		}

		
		
		return "data is not found";
	}

	@Override
	public List<Employee> getEmployeeBySalary(Double salary) {
		
		

		return jpaRepo.findBySalary(salary);
		

	}

	@Override
	public List<Employee> getEmployeeBySalaryandAge(Double salary, int age) {

		
		
		return jpaRepo.findBySalaryAndAge(salary, age);
	}

	@Override
	public List<Employee> getEmployeeByemailandage(String email, int age) {
	
		
		
		return jpaRepo.findbyemailandage(email, age);
	}

	
	

}
