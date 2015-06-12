package logic;

import java.util.Collection;

import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class Traccia {
	private static String apiKey="95f57bc8e14bd2eee7f1df8595291493";
	public String artistName;
	public String trackName;
	public Collection<Tag> topTags;
	public Collection<Track> similar;
	public Collection<User> topFans;
	public int listeners;
	private int playcount;
	private int position;
	
	public Traccia(String artistName, String trackName){
		this.artistName = artistName;
		this.trackName = trackName;
		topTags = Track.getTopTags(artistName, trackName, apiKey);
		similar = Track.getSimilar(artistName, trackName, apiKey);
		topFans = Track.getTopFans(artistName, trackName, apiKey);
		listeners = Track.getInfo(artistName, trackName, apiKey).getListeners();
		playcount = Track.getInfo(artistName, trackName, apiKey).getPlaycount();
		position = Track.getInfo(artistName, trackName, apiKey).getPosition();
	}

	public Collection<Tag> getTopTags() {
		return topTags;
	}
	
	
	
	
	public String toString(){
		for(Track t : similar){
			System.out.println(t.getName());
		}
		return "fine";
	}
}
