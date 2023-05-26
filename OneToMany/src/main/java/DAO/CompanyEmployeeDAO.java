package DAO;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.Company;
import DTO.Employee;

public class CompanyEmployeeDAO {

	static EntityManagerFactory factory;
	static EntityManager manager;
	static EntityTransaction transaction;

	static void openConnection() {
		factory = Persistence.createEntityManagerFactory("map2");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	static void closeConnection() {
		if (factory != null) {
			factory.close();
		}

		if (manager != null) {
			manager.close();
		}

		if (transaction != null) {
			transaction.rollback();
		}
	}

	public static void main(String[] args) {
		
		try {
			
			openConnection();
			transaction.begin();
			
			Employee emp1 = new Employee();
			emp1.setId(1);
			emp1.setAge(25);
			emp1.setDesignation("Developer");
			emp1.setMobile(7301333267L);
			emp1.setName("Hrithik");
			emp1.setSalary(25000d);
			manager.persist(emp1);
			Employee emp2 = new Employee();
			emp2.setId(2);
			emp2.setAge(50);
			emp2.setDesignation("Manager");
			emp2.setMobile(7894563210L);
			emp2.setName("Sita Devi");
			emp2.setSalary(50000d);
			manager.persist(emp2);
			Employee emp3 = new Employee();
			emp3.setId(3);
			emp3.setAge(35);
			emp3.setDesignation("Team Lead");
			emp3.setMobile(1234560987L);
			emp3.setName("Vinit");
			emp3.setSalary(30000d);
			manager.persist(emp3);
			 List<Employee> empList = Arrays.asList(emp1,emp2,emp3);
			 
			 
			 Company company1 = new Company();
			 company1.setId(1);
			 company1.setName("TCS");
			 company1.setDoe("25-05-1995");
			 company1.setEmp(empList);
			 manager.persist(company1);
			 
			
			transaction.commit();
			
		} finally {
			
			closeConnection();
			
		}

	}

}
