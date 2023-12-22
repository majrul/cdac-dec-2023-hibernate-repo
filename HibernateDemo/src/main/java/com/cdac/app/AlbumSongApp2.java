package com.cdac.app;

import java.util.List;

import com.cdac.dao.AlbumSongDao;
import com.cdac.entity.Album;
import com.cdac.entity.Song;

public class AlbumSongApp2 {

	public static void main(String[] args) {
		AlbumSongDao dao = new AlbumSongDao();
	
		//checking when we fetch one end of the relationship,
		//does hibernate loads the other end as well or not
		
		/*Song song = dao.fetchSongById(2);
		System.out.println(song.getTitle());
		System.out.println(song.getArtist());
		Album album = song.getAlbum();
		System.out.println(album.getName());
		System.out.println(album.getReleaseDate());
		System.out.println(album.getCopyright());*/
		
		Album album = dao.fetchAlbumById(1);
		System.out.println(album.getName());
		System.out.println(album.getReleaseDate());
		System.out.println(album.getCopyright());
		List<Song> songs = album.getSongs();
		for(Song song : songs) {
			System.out.println("--------------");
			System.out.println(song.getTitle());
			System.out.println(song.getArtist());
		}
	}
}
