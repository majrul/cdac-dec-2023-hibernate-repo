package com.cdac.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class AddCustomerUsingDao {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setName("Ed");
		customer.setEmail("ed@gmail.com");
		customer.setCity("New Jersey");
		//customer.setDateOfBirth(null); Set the DOB

		CustomerDao dao = new CustomerDao();
		dao.add(customer);
	}
}
