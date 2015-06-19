package logic;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.umass.lastfm.Artist;
import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Period;
import de.umass.lastfm.Playlist;
import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class Utente {
	
	//parametri indipendenti dalle altre classi
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
//	public PaginatedResult<Track> lovedTracks;
	public PaginatedResult<Track> recentTracks;
	
	
	//parametri dipendenti dalle altre classi
	private HashSet<TipoLinkLove> insieme_link_love;
	
//	private String username = "ale_311";
	public Utente(String username){
		//paramentri estratti da lastfm inerenti solamente l'utente
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
		
		//parametri, strutture dati con responsabilità multipla
		insieme_link_love = new HashSet<TipoLinkLove>();
//		friends = User.getFriends(username, false, 5, 99, apiKey);
//		neighbours = User.getNeighbours(username, 50, apiKey);
//		topTags = User.getTopTags(username, apiKey);
//		topArtists = User.getTopArtists(username, apiKey);
//		topTracks = User.getTopTracks(username, apiKey);
//		lovedTracks = User.getLovedTracks(username, apiKey);
//		recentTracks = User.getRecentTracks(username, 1, 200, apiKey);
	}
	
	//GESTIONE LOVEDTRACKS
	public void inserisciLinkLove(TipoLinkLove t) {
		if (t != null && t.getUtente()==this)
			ManagerLove.inserisci(t);
	}
	
	public void eliminaLinkLove(TipoLinkLove t) {
		if (t != null && t.getUtente()==this)
			ManagerLove.elimina(t);
	}
	
	public Set<TipoLinkLove> getLinkLovedTracks() {
		return (HashSet<TipoLinkLove>) insieme_link_love.clone();
	}
		
	public void inserisciPerManagerLove(ManagerLove a) {
		if (a != null) insieme_link_love.add(a.getLink());
	}
	
	public void eliminaPerManagerLove(ManagerLove a) {
		if (a != null) insieme_link_love.remove(a.getLink());
	}
	//FINE GESTIONE LOVEDTRACKS
}


