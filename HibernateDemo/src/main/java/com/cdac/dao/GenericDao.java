package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cdac.entity.User;

public class GenericDao { //CommonDao, SabkaDao, GhargutiDao, ...

	public void save(Object obj) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			em.getTransaction().begin();
			em.merge(obj); //merge is actually a 2-in-1 method, can be used for insert as well as update
			em.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			emf.close();	
		}
	}
	
	public Object fetchById(Class clazz, int id) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			Object obj = em.find(clazz, id);
			return obj;
		}
		finally {
			emf.close();
		}
	}
	
	public void deleteById(Class clazz, int id) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Object obj = em.find(clazz, id);
			em.remove(obj);
			em.getTransaction().commit();
		}
		finally {
			emf.close();
		}
	}
}
