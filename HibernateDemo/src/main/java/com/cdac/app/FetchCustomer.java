package com.cdac.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;

public class FetchCustomer {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
		EntityManager em = emf.createEntityManager();

		//find method generates select query with where pk = ?
		Customer customer = em.find(Customer.class, 4);
		System.out.println(customer.getName());
		System.out.println(customer.getEmail());
		System.out.println(customer.getDateOfBirth());
		System.out.println(customer.getCity());
		
		em.close();
		emf.close();
	}
}
