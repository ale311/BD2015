package logic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

public class Traccia {
	//parametri indipendenti da altre classi
	private static String apiKey="95f57bc8e14bd2eee7f1df8595291493";
	public String artistName;
	public String trackName;
	public Collection<Tag> topTags;
	public Collection<Track> similar;
	public Collection<User> topFans;
	public int listeners;
	private int playcount;
	private int position;

	//parametri di responsabilità multipla
	private HashSet<TipoLinkLove> insieme_link_love;
	//costruttore
	public Traccia(String artistName, String trackName){
		this.artistName = artistName;
		this.trackName = trackName;
		topTags = Track.getTopTags(artistName, trackName, apiKey);
		similar = Track.getSimilar(artistName, trackName, apiKey);
		topFans = Track.getTopFans(artistName, trackName, apiKey);
		listeners = Track.getInfo(artistName, trackName, apiKey).getListeners();
		playcount = Track.getInfo(artistName, trackName, apiKey).getPlaycount();
		position = Track.getInfo(artistName, trackName, apiKey).getPosition();

		insieme_link_love = new HashSet<TipoLinkLove>();
	}

	public void inserisciLinkContiene(TipoLinkLove t) {
		if (t != null && t.getTraccia()==this)
			ManagerLove.inserisci(t);
	}
	public void eliminaLinkContiene(TipoLinkLove t) {
		if (t != null && t.getTraccia()==this)
			ManagerLove.elimina(t);
	}

	public Set<TipoLinkLove> getLinkLove() {
		return (HashSet<TipoLinkLove>)insieme_link_love.clone();
	}
	public void inserisciPerManagerLove(ManagerLove a){
		if (a != null) insieme_link_love.add(a.getLink());
	}
	public void eliminaPerManagerLove(ManagerLove a) {
		if (a != null) insieme_link_love.remove(a.getLink());
	}

}
