package com.craft.webServiceJPA.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.craft.webServiceJPA.Model.Employee;

public interface JpaRepo extends JpaRepository<Employee, Integer>{
	
	
	//this is where we create our own dedicated method to write SQL our own way using key word findBy
	//Method name first letter has to be Upper Case
	public List<Employee> findBySalary(Double salary );
	
	//We can combine more than one column using "And" key word
	public List<Employee> findBySalaryAndAge(Double salary , int age);
	
	
	//We can write complex query using @Query
	//Method name does not have to be Upper Case using nativeQuery
	@Query(value = "SELECT * FROM javabackend.employee where email = :email and age =:age ", nativeQuery = true)
	
	public List<Employee> findbyemailandage(String email , int age);

}
