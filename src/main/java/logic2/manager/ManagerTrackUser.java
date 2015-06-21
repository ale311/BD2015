package logic2.manager;

import logic2.relation.TrackTopFan;

public final class ManagerTrackUser {

	private TrackTopFan link;
	
	private ManagerTrackUser(TrackTopFan x) { 
		this.link = x; 
	}

	public TrackTopFan getLink() { 
		return this.link; 
	}
	

	public static void inserisci(TrackTopFan y) {
		if (y != null) {
			ManagerTrackUser k = new ManagerTrackUser(y);
			y.getTraccia().inserisciPerManagerTrackUser(k);
			y.getUtente().inserisciPerManagerTrackUser(k);
		}
	}

	public static void elimina(TrackTopFan y) {
		if (y != null) {
			ManagerTrackUser k = new ManagerTrackUser(y);
			y.getTraccia().eliminaPerManagerTrackUser(k);
			y.getUtente().eliminaPerManagerTrackUser(k);
		}
	}

}
