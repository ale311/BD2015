package logic;

import de.umass.lastfm.Period;
import de.umass.lastfm.Track;

public class ProcessLastFM {
	private static String username="ale_311";
	private static String currentArtist ="Alter Bridge";
	private static String codice="95f57bc8e14bd2eee7f1df8595291493";
	private static Period periodo = Period.OVERALL;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Utente currentUser = new Utente(username);
		Artista ca = new Artista(currentArtist);
		Traccia t = new Traccia("Alter Bridge", "Blackbird");
		System.out.println(t.toString());
	}
}
