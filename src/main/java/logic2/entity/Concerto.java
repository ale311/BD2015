package logic2.entity;

import java.util.Collection;
import java.util.Date;

import de.umass.lastfm.Event;
import de.umass.lastfm.User;

public class Concerto {
	
	private String apiKey="95f57bc8e14bd2eee7f1df8595291493";
	
	private String evenID;
	private String titoloConcerto;
	private Date dataConcerto;
	private String city;
	private Nazione country;
	private Collection<String> artistiConcerto;
	private Collection<User> attendantConcerto;
	
	public Concerto(String eventID){
		this.evenID = eventID;
		this.titoloConcerto = Event.getInfo(eventID, apiKey).getTitle();
		this.dataConcerto = Event.getInfo(eventID, apiKey).getStartDate();
		this.artistiConcerto = Event.getInfo(eventID, apiKey).getArtists();
		this.attendantConcerto = Event.getAttendees(eventID, apiKey);
		this.country = null; //non trovo getCountry
		this.city = null; //ovviamente neanche city altrimenti avrei fatto...
		
	}

	public String getEvenID() {
		return evenID;
	}

	public void setEvenID(String evenID) {
		this.evenID = evenID;
	}

	public String getTitoloConcerto() {
		return titoloConcerto;
	}

	public void setTitoloConcerto(String titoloConcerto) {
		this.titoloConcerto = titoloConcerto;
	}

	public Date getDataConcerto() {
		return dataConcerto;
	}

	public void setDataConcerto(Date dataConcerto) {
		this.dataConcerto = dataConcerto;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Nazione getCountry() {
		return country;
	}

	public void setCountry(Nazione country) {
		this.country = country;
	}

	public Collection<String> getArtistiConcerto() {
		return artistiConcerto;
	}

	public void setArtistiConcerto(Collection<String> artistiConcerto) {
		this.artistiConcerto = artistiConcerto;
	}

	public Collection<User> getAttendantConcerto() {
		return attendantConcerto;
	}

	public void setAttendantConcerto(Collection<User> attendantConcerto) {
		this.attendantConcerto = attendantConcerto;
	}
}
