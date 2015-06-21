package logic2.entity;

import java.util.ArrayList;
import java.util.Collection;

import logic2.exception.EccezionePrecondizioni;
import logic2.manager.ManagerCountryTrack;
import logic2.manager.ManagerTrackUser;
import logic2.manager.ManagerUserTrack;
import logic2.relation.TrackTopFan;
import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class Traccia {

	private static String apiKey = "95f57bc8e14bd2eee7f1df8595291493";

	// parametri indipendenti da altre classi
	private String trackName;
	private String artistName;
	private int listeners;
	private int playcount;
	private int position;
	private Collection<Tag> topTags;
	private Collection<Track> similar;

	private Collection<TrackTopFan> topFans;

	// costruttore
	public Traccia(String artistName, String trackName) throws EccezionePrecondizioni {
		this.artistName = artistName;
		this.trackName = trackName;
		this.listeners = Track.getInfo(artistName, trackName, apiKey)
				.getListeners();
		this.playcount = Track.getInfo(artistName, trackName, apiKey)
				.getPlaycount();
		this.position = Track.getInfo(artistName, trackName, apiKey)
				.getPosition();
		this.topTags = Track.getTopTags(artistName, trackName, apiKey);
		this.similar = Track.getSimilar(artistName, trackName, apiKey);

		this.topFans = new ArrayList<TrackTopFan>();
		Collection<User> users = Track
				.getTopFans(artistName, trackName, apiKey);

		for (User user : users) {
			int rank = 0;
			Utente utente = new Utente(user.getName());
			TrackTopFan fan = new TrackTopFan(this, utente, rank);
			this.inserisciTrackTopFan(fan);
		}

	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Collection<Tag> getTopTags() {
		return topTags;
	}

	public void setTopTags(Collection<Tag> topTags) {
		this.topTags = topTags;
	}

	public Collection<Track> getSimilar() {
		return similar;
	}

	public void setSimilar(Collection<Track> similar) {
		this.similar = similar;
	}

	public Collection<TrackTopFan> getTopFans() {
		return topFans;
	}

	public void setTopFans(Collection<TrackTopFan> topFans) {
		this.topFans = topFans;
	}

	public void inserisciPerManagerCountryTrack(ManagerCountryTrack k) {
		// TODO Auto-generated method stub

	}

	public void eliminaPerManagerCountryTrack(ManagerCountryTrack k) {
		// TODO Auto-generated method stub

	}

	public void inserisciPerManagerTrackUser(ManagerTrackUser k) {
		if (k != null) {
			this.topFans.add(k.getLink());
		}
	}

	public void eliminaPerManagerTrackUser(ManagerTrackUser k) {
		if (k != null) {
			this.topFans.remove(k.getLink());
		}
	}

	public void inserisciPerManagerLove(ManagerUserTrack k) {
		// TODO Auto-generated method stub

	}

	public void eliminaPerManagerLove(ManagerUserTrack k) {
		// TODO Auto-generated method stub

	}

	public void inserisciTrackTopFan(TrackTopFan t) {
		if (t != null && t.getTraccia() == this) {
			ManagerTrackUser.inserisci(t);
		}
	}

	public void eliminaTrackTopFan(TrackTopFan t) {
		if (t != null && t.getTraccia() == this) {
			ManagerTrackUser.elimina(t);
		}
	}
}
