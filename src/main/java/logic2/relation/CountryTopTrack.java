package logic2.relation;

import logic2.exception.EccezionePrecondizioni;
import logic2.entity.Nazione;
import logic2.entity.Traccia;

public class CountryTopTrack {

	private final Nazione nazione;
	private final Traccia traccia;
	private int rank;

	public CountryTopTrack(Nazione nazione, Traccia traccia, int rank) throws EccezionePrecondizioni {
		// CONTROLLO PRECONDIZIONI
		if (nazione == null || traccia == null) {
			throw new EccezionePrecondizioni(
					"Gli oggetti devono essere inizializzati");
		} else {
			this.nazione = nazione;
			this.traccia = traccia;
			this.rank = rank;
		}
	}

	public Nazione getNazione() {
		return nazione;
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
