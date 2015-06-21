package logic2.manager;

import logic.ManagerLove;
import logic.TipoLinkLove;
import logic2.relation.UserTopTrack;

public final class ManagerUserTrack {

	private UserTopTrack link;
	
	private ManagerUserTrack(UserTopTrack x) { 
		this.link = x; 
	}

	public UserTopTrack getLink() { 
		return this.link; 
	}

	public static void inserisci(UserTopTrack y) {
		if (y != null) {
			ManagerUserTrack k = new ManagerUserTrack(y);
			y.getUtente().inserisciPerManagerLove(k);
			y.getTraccia().inserisciPerManagerLove(k);
		}
	}

	public static void elimina(UserTopTrack y) {
		if (y != null) {
			ManagerUserTrack k = new ManagerUserTrack(y);
			y.getUtente().eliminaPerManagerLove(k);
			y.getTraccia().eliminaPerManagerLove(k);
		}
	}

}
