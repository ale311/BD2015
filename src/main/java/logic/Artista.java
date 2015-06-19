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
}
