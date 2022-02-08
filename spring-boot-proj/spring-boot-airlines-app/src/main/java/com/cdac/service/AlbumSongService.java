package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.entity.Album;
import com.cdac.entity.Song;
import com.cdac.repository.GenericRepository;

@Service
@Transactional
public class AlbumSongService {

	@Autowired
	private GenericRepository genericRepository;
	
	public void add(Album album) {
		genericRepository.save(album);
	}

	public void add(Song song) {
		genericRepository.save(song);
	}
	
	public List<Album> fetchAllAlbums() {
		return genericRepository.findAll(Album.class);
	}

	public List<Song> fetchAllSongs() {
		return genericRepository.findAll(Song.class);
	}
}
