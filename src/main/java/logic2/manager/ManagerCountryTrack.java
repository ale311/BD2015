package logic2.manager;

import logic2.relation.CountryTopTrack;

public final class ManagerCountryTrack {

	private CountryTopTrack link;
	
	private ManagerCountryTrack(CountryTopTrack x) { 
		this.link = x; 
	}

	public CountryTopTrack getLink() { 
		return this.link; 
	}


	public static void inserisci(CountryTopTrack y) {
		if (y != null) {
			ManagerCountryTrack k = new ManagerCountryTrack(y);
			y.getNazione().inserisciPerManagerCountryTrack(k);
			y.getTraccia().inserisciPerManagerCountryTrack(k);
		}
	}

	public static void elimina(CountryTopTrack y) {
		if (y != null) {
			ManagerCountryTrack k = new ManagerCountryTrack(y);
			y.getNazione().eliminaPerManagerCountryTrack(k);
			y.getTraccia().eliminaPerManagerCountryTrack(k);
		}
	}

}
