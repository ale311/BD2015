package logic;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.umass.lastfm.Artist;
import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Period;
import de.umass.lastfm.Playlist;
import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class Utente {
	private static String apiKey = "95f57bc8e14bd2eee7f1df8595291493";
	public String id;
	public String name;
	public String realName;
	public String url;
	public String image;
	public String country;
	public int age;
	public String gender;
	//public String subscriber;
	public int playcount;
	public int numPlaylist;
	public Collection<Playlist> playlist;
	public int bootstrap;
	public Date registeredDate;
	public String language;
	public PaginatedResult<User> friends;
	public Collection<User> neighbours;
	public Collection<Tag> topTags;
	public Collection<Artist> topArtists;
	public Collection<Track> topTracks;
	public PaginatedResult<Track> lovedTracks;
	public PaginatedResult<Track> recentTracks;
	
//	private String username = "ale_311";
	public Utente(String username){
		id = User.getInfo(username,apiKey).getId();
		name = User.getInfo(username, apiKey).getName();
		realName = User.getInfo(username, apiKey).getRealname();
		url = User.getInfo(username, apiKey).getUrl();
		country = User.getInfo(username, apiKey).getCountry();
		age = User.getInfo(username, apiKey).getAge();
		gender = User.getInfo(username, apiKey).getGender();
		playcount = User.getInfo(username, apiKey).getPlaycount();
		numPlaylist = User.getInfo(username, apiKey).getNumPlaylists();
		language = User.getInfo(username, apiKey).getLanguage();
		registeredDate = User.getInfo(username,apiKey).getRegisteredDate();
		
		friends = User.getFriends(username, false, 5, 99, apiKey);
		neighbours = User.getNeighbours(username, 50, apiKey);
		topTags = User.getTopTags(username, apiKey);
		topArtists = User.getTopArtists(username, apiKey);
		topTracks = User.getTopTracks(username, apiKey);
		lovedTracks = User.getLovedTracks(username, apiKey);
		recentTracks = User.getRecentTracks(username, 1, 200, apiKey);
	}
	
	public PaginatedResult<User> getFriends() {
		return friends;
	}

	public Collection<User> getNeighbours(){
		return neighbours;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Utente other = (Utente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", name=" + name + ", realName=" + realName
				+ ", url=" + url + ", image=" + image + ", country=" + country
				+ ", age=" + age + ", gender=" + gender + ", playcount="
				+ playcount + ", numPlaylist=" + numPlaylist + ", playlist="
				+ playlist + ", bootstrap=" + bootstrap + ", registeredDate="
				+ registeredDate + ", language=" + language + ", topTags="
				+ topTags + "]";
	}

	public static String getApiKey() {
		return apiKey;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRealName() {
		return realName;
	}

	public String getUrl() {
		return url;
	}

	public String getImage() {
		return image;
	}

	public String getCountry() {
		return country;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public int getPlaycount() {
		return playcount;
	}

	public int getNumPlaylist() {
		return numPlaylist;
	}

	public Collection<Playlist> getPlaylist() {
		return playlist;
	}

	public int getBootstrap() {
		return bootstrap;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public String getLanguage() {
		return language;
	}

	public static Collection<Track> tracksPreferredByUser (String username, Period period, String codice){
		//p = Period.OVERALL;
		Collection<Track> result = User.getTopTracks(username, period, apiKey);
		System.out.println(result.size());
		return result;
	}
	
	public static Collection<Artist> artistPreferredByUser(String username, Period period, String codice){
		Collection<Artist> result = User.getTopArtists(username, period, apiKey);
		System.out.println(result.size());
		return result;
	}
}


