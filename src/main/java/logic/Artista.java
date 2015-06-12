package logic;

import java.util.Collection;

import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;
import de.umass.lastfm.Event;
import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class Artista {
	private static String apiKey = "95f57bc8e14bd2eee7f1df8595291493";
//	public String artista;
	public Artist infoArtista;
	public PaginatedResult<Event> events;
	public Collection<Artist> similarArtists;
	public PaginatedResult<Event> pastEvents;
	public Collection<Tag> topTags;
	public Collection<Track> topTracks;
	public Collection<User> topFans;
	public Collection<Album> topAlbums;
	public int playcount;
	public String ID;
	public int listeners;
	public Artista(String artista){
		infoArtista = Artist.getInfo(artista, apiKey);
		events = Artist.getEvents(artista, apiKey);
		similarArtists = Artist.getSimilar(artista, apiKey);
		pastEvents = Artist.getPastEvents(artista, apiKey);
		topTags = Artist.getTopTags(artista, apiKey);
		topTracks = Artist.getTopTracks(artista, apiKey);
		topFans = Artist.getTopFans(artista, apiKey);
		topAlbums = Artist.getTopAlbums(artista, apiKey);
		playcount = Artist.getInfo(artista, apiKey).getPlaycount();
		ID = Artist.getInfo(artista, apiKey).getId();
		listeners = Artist.getInfo(artista, apiKey).getListeners();
	}
	@Override
	public String toString() {
		return "Artista []";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result
				+ ((infoArtista == null) ? 0 : infoArtista.hashCode());
		result = prime * result + listeners;
		result = prime * result
				+ ((pastEvents == null) ? 0 : pastEvents.hashCode());
		result = prime * result + playcount;
		result = prime * result
				+ ((similarArtists == null) ? 0 : similarArtists.hashCode());
		result = prime * result
				+ ((topAlbums == null) ? 0 : topAlbums.hashCode());
		result = prime * result + ((topFans == null) ? 0 : topFans.hashCode());
		result = prime * result + ((topTags == null) ? 0 : topTags.hashCode());
		result = prime * result
				+ ((topTracks == null) ? 0 : topTracks.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (infoArtista == null) {
			if (other.infoArtista != null)
				return false;
		} else if (!infoArtista.equals(other.infoArtista))
			return false;
		if (listeners != other.listeners)
			return false;
		if (pastEvents == null) {
			if (other.pastEvents != null)
				return false;
		} else if (!pastEvents.equals(other.pastEvents))
			return false;
		if (playcount != other.playcount)
			return false;
		if (similarArtists == null) {
			if (other.similarArtists != null)
				return false;
		} else if (!similarArtists.equals(other.similarArtists))
			return false;
		if (topAlbums == null) {
			if (other.topAlbums != null)
				return false;
		} else if (!topAlbums.equals(other.topAlbums))
			return false;
		if (topFans == null) {
			if (other.topFans != null)
				return false;
		} else if (!topFans.equals(other.topFans))
			return false;
		if (topTags == null) {
			if (other.topTags != null)
				return false;
		} else if (!topTags.equals(other.topTags))
			return false;
		if (topTracks == null) {
			if (other.topTracks != null)
				return false;
		} else if (!topTracks.equals(other.topTracks))
			return false;
		return true;
	}
	
	public Artist getInfoArtista() {
		return infoArtista;
	}
	public PaginatedResult<Event> getEvents() {
		return events;
	}
	public Collection<Artist> getSimilarArtists() {
		return similarArtists;
	}
	public PaginatedResult<Event> getPastEvents() {
		return pastEvents;
	}
	public Collection<Tag> getTopTags() {
		return topTags;
	}
	public Collection<Track> getTopTracks() {
		return topTracks;
	}
	public Collection<User> getTopFans() {
		return topFans;
	}
	public Collection<Album> getTopAlbums() {
		return topAlbums;
	}
	public int getPlaycount() {
		return playcount;
	}
	public String getID() {
		return ID;
	}
	public int getListeners() {
		return listeners;
	}
}
