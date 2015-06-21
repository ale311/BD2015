package logic2.relation;

import logic2.exception.EccezionePrecondizioni;import logic2.entity.Utente;

public class Neighbour {

	private final Utente utente1;
	private final Utente utente2;
	private int sim;

	public Neighbour(Utente utente1, Utente utente2, int sim) throws EccezionePrecondizioni {
		// CONTROLLO PRECONDIZIONI
		if (utente1 == null || utente2 == null) {
			throw new EccezionePrecondizioni(
					"Gli oggetti devono essere inizializzati");
		} else {
			this.utente1 = utente1;
			this.utente2 = utente2;
			this.sim = sim;
		}
	}

	public Utente getUtente1() {
		return utente1;
	}

	public Utente getUtente2() {
		return utente2;
	}

	public int getSim() {
		return sim;
	}

	public void setSim(int sim) {
		this.sim = sim;
	}

}
