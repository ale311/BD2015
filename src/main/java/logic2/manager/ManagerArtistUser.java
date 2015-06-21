package logic2.manager;

import logic2.relation.ArtistTopFan;

public final class ManagerArtistUser {
	
	private ArtistTopFan link;
	
	private ManagerArtistUser(ArtistTopFan x) { 
		this.link = x; 
	}

	public ArtistTopFan getLink() { 
		return this.link; 
	}
	
	public static void inserisci(ArtistTopFan y) {
		if (y != null) {
			ManagerArtistUser k = new ManagerArtistUser(y);
			y.getArtista().inserisciPerManagerArtistUser(k);
			y.getUtente().inserisciPerManagerArtistUser(k);
		}
	}

	public static void elimina(ArtistTopFan y) {
		if (y != null) {
			ManagerArtistUser k = new ManagerArtistUser(y);
			y.getArtista().eliminaPerManagerArtistUser(k);
			y.getUtente().eliminaPerManagerArtistUser(k);
		}
	}

	
}
