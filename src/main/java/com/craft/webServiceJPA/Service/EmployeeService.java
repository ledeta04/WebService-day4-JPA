package com.craft.webServiceJPA.Service;

import java.util.List;

import com.craft.webServiceJPA.Model.Employee;

public interface EmployeeService {
	
	public Employee insert(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee findById(int id);
	public Employee update(Employee employee, int id);
	public String delete(int id);
	
	public List<Employee> getEmployeeBySalary(Double salary);
	public List<Employee> getEmployeeBySalaryandAge(Double salary , int age);
	public List<Employee> getEmployeeByemailandage(String email, int age);
	
	

}
