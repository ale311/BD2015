package logic2.entity;

import java.util.ArrayList;
import java.util.Collection;

import logic2.exception.EccezionePrecondizioni;
import logic2.manager.ManagerArtistUser;
import logic2.manager.ManagerCountryArtist;
import logic2.manager.ManagerUserArtist;
import logic2.relation.ArtistTopFan;
import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;
import de.umass.lastfm.Event;
import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class Artista {

	private static String apiKey = "95f57bc8e14bd2eee7f1df8595291493";

	private String ID;
	private String name;
	private int playcount;
	private int listeners;
	private PaginatedResult<Event> events;
	private Collection<Artist> similarArtists;
	private PaginatedResult<Event> pastEvents;
	private Collection<Tag> topTags;
	private Collection<Track> topTracks;
	private Collection<Album> topAlbums;

	private Collection<ArtistTopFan> topFans;

	public Artista(String artista) throws EccezionePrecondizioni {
		this.ID = Artist.getInfo(artista, apiKey).getId();
		this.name = Artist.getInfo(artista, apiKey).getName();
		this.playcount = Artist.getInfo(artista, apiKey).getPlaycount();
		this.listeners = Artist.getInfo(artista, apiKey).getListeners();
		this.events = Artist.getEvents(artista, apiKey);
		this.similarArtists = Artist.getSimilar(artista, apiKey);
		this.pastEvents = Artist.getPastEvents(artista, apiKey);
		this.topTags = Artist.getTopTags(artista, apiKey);
		this.topTracks = Artist.getTopTracks(artista, apiKey);
		this.topAlbums = Artist.getTopAlbums(artista, apiKey);

		this.topFans = new ArrayList<ArtistTopFan>();
		Collection<User> users = Artist.getTopFans(artista, apiKey);

		for (User user : users) {
			int rank = 0;
			Utente utente = new Utente(user.getName());
			ArtistTopFan fan = new ArtistTopFan(this, utente, rank);
			this.inserisciArtistTopFan(fan);
		}

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlaycount() {
		return playcount;
	}

	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	public int getListeners() {
		return listeners;
	}

	public void setListeners(int listeners) {
		this.listeners = listeners;
	}

	public PaginatedResult<Event> getEvents() {
		return events;
	}

	public void setEvents(PaginatedResult<Event> events) {
		this.events = events;
	}

	public Collection<Artist> getSimilarArtists() {
		return similarArtists;
	}

	public void setSimilarArtists(Collection<Artist> similarArtists) {
		this.similarArtists = similarArtists;
	}

	public PaginatedResult<Event> getPastEvents() {
		return pastEvents;
	}

	public void setPastEvents(PaginatedResult<Event> pastEvents) {
		this.pastEvents = pastEvents;
	}

	public Collection<Tag> getTopTags() {
		return topTags;
	}

	public void setTopTags(Collection<Tag> topTags) {
		this.topTags = topTags;
	}

	public Collection<Track> getTopTracks() {
		return topTracks;
	}

	public void setTopTracks(Collection<Track> topTracks) {
		this.topTracks = topTracks;
	}

	public Collection<Album> getTopAlbums() {
		return topAlbums;
	}

	public void setTopAlbums(Collection<Album> topAlbums) {
		this.topAlbums = topAlbums;
	}

	public Collection<ArtistTopFan> getTopFans() {
		return topFans;
	}

	public void setTopFans(Collection<ArtistTopFan> topFans) {
		this.topFans = topFans;
	}

	public void inserisciPerManagerArtistUser(ManagerArtistUser k) {
		if (k != null) {
			this.topFans.add(k.getLink());
		}
	}

	public void eliminaPerManagerArtistUser(ManagerArtistUser k) {
		if (k != null) {
			this.topFans.remove(k.getLink());
		}
	}

	public void inserisciPerManagerCountryArtist(ManagerCountryArtist k) {
		// TODO Auto-generated method stub

	}

	public void eliminaPerManagerCountryArtist(ManagerCountryArtist k) {
		// TODO Auto-generated method stub

	}

	public void inserisciPerManagerUserArtist(ManagerUserArtist k) {
		// TODO Auto-generated method stub

	}

	public void eliminaPerManagerUserArtist(ManagerUserArtist k) {
		// TODO Auto-generated method stub

	}

	public void inserisciArtistTopFan(ArtistTopFan t) {
		if (t != null && t.getArtista() == this) {
			ManagerArtistUser.inserisci(t);
		}
	}

	public void eliminaArtistTopFan(ArtistTopFan t) {
		if (t != null && t.getArtista() == this) {
			ManagerArtistUser.elimina(t);
		}
	}
}
