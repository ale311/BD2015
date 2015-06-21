package logic2.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import logic2.exception.EccezionePrecondizioni;
import logic2.manager.ManagerArtistUser;
import logic2.manager.ManagerNeighbour;
import logic2.manager.ManagerTrackUser;
import logic2.manager.ManagerUserArtist;
import logic2.manager.ManagerUserTrack;
import logic2.relation.Neighbour;
import logic2.relation.UserTopArtist;
import logic2.relation.UserTopTrack;
import de.umass.lastfm.Artist;
import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class Utente {

	private static String apiKey = "95f57bc8e14bd2eee7f1df8595291493";

	// parametri indipendenti dalle altre classi
	private String id;
	private String name;
	private String realName;
	private Nazione country;
	private int age;
	private String gender;
	private int playcount;
	private Date registeredDate;
	private String language;

	private PaginatedResult<User> friends;
	private PaginatedResult<Track> recentTracks;

	private Collection<Neighbour> neighbours;
	private Collection<UserTopArtist> topArtists;
	private Collection<UserTopTrack> topTracks;

	public Utente(String username) throws EccezionePrecondizioni {
		// paramentri estratti da lastfm inerenti solamente l'utente
		this.id = User.getInfo(username, apiKey).getId();
		this.name = User.getInfo(username, apiKey).getName();
		this.realName = User.getInfo(username, apiKey).getRealname();

		String country = User.getInfo(username, apiKey).getCountry();
		this.country = new Nazione(country);

		this.age = User.getInfo(username, apiKey).getAge();
		this.gender = User.getInfo(username, apiKey).getGender();
		this.playcount = User.getInfo(username, apiKey).getPlaycount();
		this.language = User.getInfo(username, apiKey).getLanguage();
		this.registeredDate = User.getInfo(username, apiKey)
				.getRegisteredDate();

		this.friends = User.getFriends(username, false, 5, 99, apiKey);
		this.recentTracks = User.getRecentTracks(username, 1, 200, apiKey);

		this.neighbours = new ArrayList<Neighbour>();
		Collection<User> users = User.getNeighbours(username, apiKey);

		for (User user : users) {
			int rank = 0;
			Utente utente = new Utente(user.getName());
			Neighbour neighbour = new Neighbour(this, utente, rank);
			this.inserisciNeighbour(neighbour);
		}

		this.topArtists = new ArrayList<UserTopArtist>();
		Collection<Artist> artists = User.getTopArtists(username, apiKey);

		for (Artist artist : artists) {
			int rank = 0;
			Artista artista = new Artista(artist.getName());
			UserTopArtist newArtist = new UserTopArtist(this, artista, rank);
			this.inserisciUserTopArtist(newArtist);
		}

		this.topTracks = new ArrayList<UserTopTrack>();
		Collection<Track> tracks = User.getTopTracks(username, apiKey);

		for (Track track : tracks) {
			int rank = 0;
			Traccia traccia = new Traccia(track.getArtist(), track.getName());
			UserTopTrack newTrack = new UserTopTrack(this, traccia, rank);
			this.inserisciUserTopTrack(newTrack);
		}
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Nazione getCountry() {
		return country;
	}

	public void setCountry(Nazione country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPlaycount() {
		return playcount;
	}

	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public PaginatedResult<User> getFriends() {
		return friends;
	}

	public void setFriends(PaginatedResult<User> friends) {
		this.friends = friends;
	}

	public PaginatedResult<Track> getRecentTracks() {
		return recentTracks;
	}

	public void setRecentTracks(PaginatedResult<Track> recentTracks) {
		this.recentTracks = recentTracks;
	}

	public Collection<Neighbour> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(Collection<Neighbour> neighbours) {
		this.neighbours = neighbours;
	}

	public Collection<UserTopArtist> getTopArtists() {
		return topArtists;
	}

	public void setTopArtists(Collection<UserTopArtist> topArtists) {
		this.topArtists = topArtists;
	}

	public Collection<UserTopTrack> getTopTracks() {
		return topTracks;
	}

	public void setTopTracks(Collection<UserTopTrack> topTracks) {
		this.topTracks = topTracks;
	}

	public void inserisciPerManagerArtistUser(ManagerArtistUser k) {

	}

	public void eliminaPerManagerArtistUser(ManagerArtistUser k) {
		// TODO Auto-generated method stub

	}

	public void inserisciPerManagerLove(ManagerNeighbour k) {
		if (k != null) {
			this.neighbours.add(k.getLink());
		}
	}

	public void eliminaPerManagerLove(ManagerNeighbour k) {
		if (k != null) {
			this.neighbours.remove(k.getLink());
		}
	}

	public void inserisciPerManagerLove(ManagerTrackUser k) {
		// TODO Auto-generated method stub

	}

	public void eliminaPerManagerLove(ManagerTrackUser k) {
		// TODO Auto-generated method stub

	}

	public void inserisciPerManagerTrackUser(ManagerTrackUser k) {
		// TODO Auto-generated method stub

	}

	public void eliminaPerManagerTrackUser(ManagerTrackUser k) {
		// TODO Auto-generated method stub

	}

	public void inserisciPerManagerUserArtist(ManagerUserArtist k) {
		if (k != null) {
			this.topArtists.add(k.getLink());
		}
	}

	public void eliminaPerManagerUserArtist(ManagerUserArtist k) {
		if (k != null) {
			this.topArtists.remove(k.getLink());
		}
	}

	public void inserisciPerManagerLove(ManagerUserTrack k) {
		if (k != null) {
			this.topTracks.add(k.getLink());
		}
	}

	public void eliminaPerManagerLove(ManagerUserTrack k) {
		if (k != null) {
			this.topTracks.remove(k.getLink());
		}
	}

	public void inserisciNeighbour(Neighbour t) {
		if (t != null && (t.getUtente1() == this || t.getUtente2() == this)) {
			ManagerNeighbour.inserisci(t);
		}
	}

	public void eliminaNeighbour(Neighbour t) {
		if (t != null && (t.getUtente1() == this || t.getUtente2() == this)) {
			ManagerNeighbour.elimina(t);
		}
	}

	public void inserisciUserTopArtist(UserTopArtist t) {
		if (t != null && t.getUtente() == this) {
			ManagerUserArtist.inserisci(t);
		}
	}

	public void eliminaUserTopArtist(UserTopArtist t) {
		if (t != null && t.getUtente() == this) {
			ManagerUserArtist.elimina(t);
		}
	}

	public void inserisciUserTopTrack(UserTopTrack t) {
		if (t != null && t.getUtente() == this) {
			ManagerUserTrack.inserisci(t);
		}
	}

	public void eliminaUserTopTrack(UserTopTrack t) {
		if (t != null && t.getUtente() == this) {
			ManagerUserTrack.elimina(t);
		}
	}
}
