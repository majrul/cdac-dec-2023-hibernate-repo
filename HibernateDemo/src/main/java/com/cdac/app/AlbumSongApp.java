package com.cdac.app;

import java.time.LocalDate;
import java.util.List;

import com.cdac.dao.AlbumSongDao;
import com.cdac.entity.Album;
import com.cdac.entity.Song;

public class AlbumSongApp {

	public static void main(String[] args) {
		AlbumSongDao dao = new AlbumSongDao();
		
		//scenario 1: adding an album first
		/*Album album = new Album();
		album.setName("Hits of 2021");
		album.setReleaseDate(LocalDate.of(2021, 12, 25));
		album.setCopyright("Sony Music");
		dao.add(album);*/
		
		//scenario 2: adding song for an album
		/*Album album = dao.fetchAlbumById(2);
		Song song = new Song();
		song.setTitle("Dil Galti Kar Baitha Hai");
		song.setArtist("Jubin Nautiyal");
		song.setDuration(3.30);
		song.setAlbum(album);
		dao.add(song);*/
		
		//scenario 3: fetching data
		/*List<Song> songs = dao.fetchSongsByArtist("Arijit Singh");
		for(Song song : songs) {
			System.out.println("-----------");
			System.out.println(song.getId());
			System.out.println(song.getTitle());
			System.out.println(song.getDuration());
		}*/
		
	}
}
