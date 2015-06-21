package logic2.relation;

import logic2.exception.EccezionePrecondizioni;
import logic2.entity.Traccia;
import logic2.entity.Utente;

public class TrackTopFan {

	private final Traccia traccia;
	private final Utente utente;
	private int rank;

	public TrackTopFan(Traccia traccia, Utente utente, int rank) throws EccezionePrecondizioni {
		// CONTROLLO PRECONDIZIONI
		if (traccia == null || utente == null) {
			throw new EccezionePrecondizioni(
					"Gli oggetti devono essere inizializzati");
		} else {
			this.traccia = traccia;
			this.utente = utente;
			this.rank = rank;
		}
	}

	public Traccia getTraccia() {
		return traccia;
	}

	public Utente getUtente() {
		return utente;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
