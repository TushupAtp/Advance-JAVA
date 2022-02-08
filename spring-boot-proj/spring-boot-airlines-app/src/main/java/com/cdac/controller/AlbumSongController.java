package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Status;
import com.cdac.entity.Album;
import com.cdac.entity.Song;
import com.cdac.service.AlbumSongService;

@RestController
@CrossOrigin
public class AlbumSongController {

	@Autowired
	private AlbumSongService albumSongService;
	
	@PostMapping("/add-album")
	public Status add(@RequestBody Album album) {
		albumSongService.add(album);
		return null;
	}

	@PostMapping("/add-song")
	public Status add(@RequestBody Song song) {
		albumSongService.add(song);
		return null;
	}

	@GetMapping("/fetch-albums")
	public List<Album> fetchAlbums() {
		return albumSongService.fetchAllAlbums();
	}

	@GetMapping("/fetch-songs")
	public List<Song> fetchSongs() {
		return albumSongService.fetchAllSongs();
	}

}
