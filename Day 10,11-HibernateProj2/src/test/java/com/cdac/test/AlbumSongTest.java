package com.cdac.test;

import java.time.LocalDate;

import org.junit.Test;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Album;
import com.cdac.entity.Song;

public class AlbumSongTest {

	@Test
	public void addAlbum() {
		Album alb = new Album();
		alb.setName("DDLJ");
		alb.setReleaseDate(LocalDate.of(1995, 10, 10));
		alb.setCopyright("T-Series");
		
		GenericDao dao = new GenericDao();
		dao.add(alb);
		
		//test cases are incomplete without assertions
	}
	
	@Test
	public void addSongToAnAlbum() {
		GenericDao dao = new GenericDao();
		Album alb = (Album) dao.findByPK(Album.class, 16);
		
		Song s = new Song();
		s.setTitle("Ruk Ja");
		s.setDuration(5.30);
		s.setArtist("Udit Narayan");
		s.setAlbum(alb);
		dao.add(s);
	}
}
