package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Address;
import com.cdac.entity.User;

//this is wrong, we should create separate dao for each entity
public class UserAddressDao {

	public void add(User user) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			em.getTransaction().begin();
			em.persist(user); //persist will generate insert query
			em.getTransaction().commit();
		}
		finally {
			emf.close();	
		}
	}

	public void add(Address address) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			em.getTransaction().begin();
			em.persist(address); //persist will generate insert query
			em.getTransaction().commit();
		}
		finally {
			emf.close();	
		}
	}

	public void update(User user) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		}
		finally {
			emf.close();	
		}
	}

	public User fetchUserById(int id) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			User user = em.find(User.class, id);
			return user;
		}
		finally {
			emf.close();
		}
	}

	public Address fetchAddressById(int id) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			Address address = em.find(Address.class, id);
			return address;
		}
		finally {
			emf.close();
		}
	}
	
	public User fetchUserByEmail(String email) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			Query q = em.createQuery("select u from User u where u.email = ?1"); //HQL/JPQL
			q.setParameter(1, email);
			User user = (User) q.getSingleResult();
			return user;
		
		}
		finally {
			emf.close();
		}
	}
	
	public List<User> fetchUsersByDomain(String domainName) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			Query q = em.createQuery("select u from User u where u.email like ?1"); //HQL/JPQL
			q.setParameter(1, "%" + domainName + "%");
			List<User> users = q.getResultList();
			return users;
		
		}
		finally {
			emf.close();
		}
	}
	
	public List<User> fetchUsersByCity(String city) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em = emf.createEntityManager();
	
			Query q = em.createQuery("select u from User u join u.address a where a.city = ?1");
			q.setParameter(1, city);
			List<User> users = q.getResultList();
			return users;
		
		}
		finally {
			emf.close();
		}
	}

	public List<Object[]> fetchUsersByCityV2(String city) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo");
			EntityManager em = emf.createEntityManager();
	
			Query q = em.createQuery("select u.name,u.mobileNumber from User u join u.address a where a.city = ?1");
			q.setParameter(1, city);
			List<Object[]> users = q.getResultList();
			return users;
		
		}
		finally {
			emf.close();
		}
	}

}














