package logic2.relation;

import logic2.exception.EccezionePrecondizioni;
import logic2.entity.Traccia;
import logic2.entity.Utente;

public class UserTopTrack {

	private final Utente utente;
	private final Traccia traccia;
	private int rank;

	public UserTopTrack(Utente utente, Traccia traccia, int rank) throws EccezionePrecondizioni {
		// CONTROLLO PRECONDIZIONI
		if (utente == null || traccia == null) {
			throw new EccezionePrecondizioni(
					"Gli oggetti devono essere inizializzati");
		} else {
			this.utente = utente;
			this.traccia = traccia;
			this.rank = rank;
		}
	}

	public Utente getUtente() {
		return utente;
	}

	public Traccia getTraccia() {
		return traccia;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
