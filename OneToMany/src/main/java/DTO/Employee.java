package DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	int id;
	String name;
	int age;
	long mobile;
	String Designation;
	Double Salary;

}
