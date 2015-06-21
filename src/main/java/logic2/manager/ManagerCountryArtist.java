package logic2.manager;

import logic2.relation.CountryTopArtist;

public final class ManagerCountryArtist {

	private CountryTopArtist link;
	
	private ManagerCountryArtist(CountryTopArtist x) { 
		this.link = x; 
	}

	public CountryTopArtist getLink() { 
		return this.link; 
	}


	public static void inserisci(CountryTopArtist y) {
		if (y != null) {
			ManagerCountryArtist k = new ManagerCountryArtist(y);
			y.getNazione().inserisciPerManagerCountryArtist(k);
			y.getArtista().inserisciPerManagerCountryArtist(k);
		}
	}

	public static void elimina(CountryTopArtist y) {
		if (y != null) {
			ManagerCountryArtist k = new ManagerCountryArtist(y);
			y.getNazione().eliminaPerManagerCountryArtist(k);
			y.getArtista().eliminaPerManagerCountryArtist(k);
		}
	}

}
