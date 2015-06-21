package logic2.manager;

import logic2.relation.Neighbour;

public final class ManagerNeighbour {
	
	private Neighbour link;
	
	private ManagerNeighbour(Neighbour x) { 
		this.link = x; 
	}

	public Neighbour getLink() { 
		return this.link; 
	}
	

	public static void inserisci(Neighbour y) {
		if (y != null) {
			ManagerNeighbour k = new ManagerNeighbour(y);
			y.getUtente1().inserisciPerManagerLove(k);
			y.getUtente2().inserisciPerManagerLove(k);
		}
	}

	public static void elimina(Neighbour y) {
		if (y != null) {
			ManagerNeighbour k = new ManagerNeighbour(y);
			y.getUtente1().eliminaPerManagerLove(k);
			y.getUtente2().eliminaPerManagerLove(k);
		}
	}

}
