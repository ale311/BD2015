package logic2.entity;

import java.util.ArrayList;
import java.util.Collection;

import logic2.exception.EccezionePrecondizioni;
import logic2.manager.ManagerCountryArtist;
import logic2.manager.ManagerCountryTrack;
import logic2.relation.CountryTopArtist;
import logic2.relation.CountryTopTrack;
import de.umass.lastfm.Artist;
import de.umass.lastfm.Track;

public class Nazione {

	private String name;
	private Collection<Concerto> events;
	private Collection<CountryTopArtist> topArtists;
	private Collection<CountryTopTrack> topTracks;

	public Nazione(String country) throws EccezionePrecondizioni {
		this.name = country;

		Collection<Concerto> events = new ArrayList<Concerto>(); // recupero
																	// tutti gli
																	// eventi
		Collection<Artist> artists = new ArrayList<Artist>(); // recupero tutti
																// gli artisti
		Collection<Track> tracks = new ArrayList<Track>(); // recupero tutte le
															// tracce

		for (Concerto event : events) {
			if (event.getCountry().equals(this.name)) {
				this.events.add(event);
			}
		}

		for (Artist artist : artists) {
			int rank = 0;
			Artista artista = new Artista(artist.getName());
			CountryTopArtist newArtist = new CountryTopArtist(this, artista,
					rank);
			this.inserisciCountryTopArtist(newArtist);
		}

		for (Track track : tracks) {
			int rank = 0;
			Traccia traccia = new Traccia(track.getArtist(), track.getName());
			CountryTopTrack newTrack = new CountryTopTrack(this, traccia, rank);
			this.inserisciCountryTopTrack(newTrack);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Concerto> getEvents() {
		return events;
	}

	public void setEvents(Collection<Concerto> events) {
		this.events = events;
	}

	public Collection<CountryTopArtist> getTopArtists() {
		return topArtists;
	}

	public void setTopArtists(Collection<CountryTopArtist> topArtists) {
		this.topArtists = topArtists;
	}

	public Collection<CountryTopTrack> getTopTracks() {
		return topTracks;
	}

	public void setTopTracks(Collection<CountryTopTrack> topTracks) {
		this.topTracks = topTracks;
	}

	public void inserisciPerManagerCountryArtist(ManagerCountryArtist k) {
		if (k != null) {
			this.topArtists.add(k.getLink());
		}
	}

	public void eliminaPerManagerCountryArtist(ManagerCountryArtist k) {
		if (k != null) {
			this.topArtists.remove(k.getLink());
		}
	}

	public void inserisciPerManagerCountryTrack(ManagerCountryTrack k) {
		if (k != null) {
			this.topTracks.add(k.getLink());
		}
	}

	public void eliminaPerManagerCountryTrack(ManagerCountryTrack k) {
		if (k != null) {
			this.topTracks.remove(k.getLink());
		}
	}

	public void inserisciCountryTopArtist(CountryTopArtist t) {
		if (t != null && t.getNazione() == this) {
			ManagerCountryArtist.inserisci(t);
		}
	}

	public void eliminaCountryTopArtist(CountryTopArtist t) {
		if (t != null && t.getNazione() == this) {
			ManagerCountryArtist.elimina(t);
		}
	}

	public void inserisciCountryTopTrack(CountryTopTrack t) {
		if (t != null && t.getNazione() == this) {
			ManagerCountryTrack.inserisci(t);
		}
	}

	public void eliminaCountryTopTrack(CountryTopTrack t) {
		if (t != null && t.getNazione() == this) {
			ManagerCountryTrack.elimina(t);
		}
	}

}
