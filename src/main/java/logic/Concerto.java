package logic;

import java.util.Collection;
import java.util.Date;

import de.umass.lastfm.Artist;
import de.umass.lastfm.Event;
import de.umass.lastfm.User;

public class Concerto {
	public String eventID = "328799";
	public String apiKey="95f57bc8e14bd2eee7f1df8595291493";
	public String titoloConcerto;
	public Collection<String> artistiConcerto;
	public Collection<User> attendantConcerto;
	public Date dataConcerto;
	
	public Concerto(){
		this.artistiConcerto = Event.getInfo(eventID, apiKey).getArtists();
		this.titoloConcerto = Event.getInfo(eventID, apiKey).getTitle();
		this.dataConcerto = Event.getInfo(eventID, apiKey).getStartDate();
		this.attendantConcerto = Event.getAttendees(eventID, apiKey);
		
	}
}
