package logic2.entity;

import java.util.Collection;

import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.Album;

public class AlbumArtista {
	
	private String apiKey="95f57bc8e14bd2eee7f1df8595291493";

	private String id;
	private String name;
	private int listeners;
	private int playcount;
	private String artist;
	private Collection<Track> tracks;
	private Collection<Tag> topTags;

	public AlbumArtista(String artist, String album) {
		this.id = Album.getInfo(artist, album, apiKey).getId();
		this.name = Album.getInfo(artist, album, apiKey).getName();
		this.listeners =Album.getInfo(artist, album, apiKey).getListeners();
		this.playcount = Album.getInfo(artist, album, apiKey).getPlaycount();
		this.artist = Album.getInfo(artist, album, apiKey).getArtist();
		this.tracks = Album.getInfo(artist, album, apiKey).getTracks();
		this.topTags = Album.getInfo(artist, album, apiKey).getTopTags(artist, album, apiKey);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getListeners() {
		return listeners;
	}

	public void setListeners(int listeners) {
		this.listeners = listeners;
	}

	public int getPlaycount() {
		return playcount;
	}

	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Collection<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Collection<Track> tracks) {
		this.tracks = tracks;
	}

	public Collection<Tag> getTopTags() {
		return topTags;
	}

	public void setTopTags(Collection<Tag> topTags) {
		this.topTags = topTags;
	}
	
}
