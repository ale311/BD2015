package logic2.manager;

import logic2.relation.UserTopArtist;

public final class ManagerUserArtist {

	private UserTopArtist link;
	
	private ManagerUserArtist(UserTopArtist x) { 
		this.link = x; 
	}

	public UserTopArtist getLink() { 
		return this.link; 
	}
	

	public static void inserisci(UserTopArtist y) {
		if (y != null) {
			ManagerUserArtist k = new ManagerUserArtist(y);
			y.getUtente().inserisciPerManagerUserArtist(k);
			y.getArtista().inserisciPerManagerUserArtist(k);
		}
	}

	public static void elimina(UserTopArtist y) {
		if (y != null) {
			ManagerUserArtist k = new ManagerUserArtist(y);
			y.getUtente().eliminaPerManagerUserArtist(k);
			y.getArtista().eliminaPerManagerUserArtist(k);
		}
	}


}
