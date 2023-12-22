package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Customer;

//classes which contain DB specific code are commonly referred
//to as Dao (Data Access Object)
public class CustomerDao {

	public void add(Customer customer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(customer); //persist will generate insert query
		em.getTransaction().commit();
		
		em.close();
		emf.close();	
	}

	public void update(Customer customer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.merge(customer); //merge will generate update query
		em.getTransaction().commit();
		
		em.close();
		emf.close();	
	}

	public void delete(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, id);
		em.remove(customer);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	
	public Customer fetch(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
		EntityManager em = emf.createEntityManager();

		Customer customer = em.find(Customer.class, id);

		em.close();
		emf.close();
		
		return customer;
	}
	
	public List<Customer> fetchAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select c from Customer c"); //HQL/JPQL
		List<Customer> list = q.getResultList();
		
		em.close();
		emf.close();
		
		return list;
		
	}
	
	public List<Customer> fetchByCity(String city) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select c from Customer c where c.city = ?1"); //HQL/JPQL
		q.setParameter(1, city);
		List<Customer> list = q.getResultList();
		
		em.close();
		emf.close();
		
		return list;
		
	}
}














