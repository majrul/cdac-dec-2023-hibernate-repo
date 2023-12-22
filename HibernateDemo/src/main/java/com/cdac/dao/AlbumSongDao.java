package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Album;
import com.cdac.entity.Song;
import com.cdac.entity.User;

//this is wrong, we should create separate dao for each entity
public class AlbumSongDao {

	public void add(Album album) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			em.getTransaction().begin();
			em.persist(album); //persist will generate insert query
			em.getTransaction().commit();
		}
		finally {
			emf.close();	
		}
	}
	
	public Album fetchAlbumById(int id) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			Album album = em.find(Album.class, id);
			return album;
		}
		finally {
			emf.close();
		}
	}

	public Song fetchSongById(int id) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			Song song = em.find(Song.class, id);
			return song;
		}
		finally {
			emf.close();
		}
	}


	public void add(Song song) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			em.getTransaction().begin();
			em.persist(song); //persist will generate insert query
			em.getTransaction().commit();
		}
		finally {
			emf.close();	
		}
	}
	
	public List<Song> fetchSongsByArtist(String artist) {
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory("hibernate-demo"); //META-INF/persistence.xml
			EntityManager em = emf.createEntityManager();
	
			Query q = em.createQuery("select s from Song s where s.artist = ?1");
			q.setParameter(1, artist);
			List<Song> songs = q.getResultList();
			return songs;
		
		}
		finally {
			emf.close();
		}
	}
}














