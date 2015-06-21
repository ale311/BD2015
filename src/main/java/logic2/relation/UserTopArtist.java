package logic2.relation;

import logic2.exception.EccezionePrecondizioni;
import logic2.entity.Artista;
import logic2.entity.Utente;

public class UserTopArtist {

	private final Utente utente;
	private final Artista artista;
	private int rank;

	public UserTopArtist(Utente utente, Artista artista, int rank)
			throws EccezionePrecondizioni {
		// CONTROLLO PRECONDIZIONI
		if (utente == null || artista == null) {
			throw new EccezionePrecondizioni(
					"Gli oggetti devono essere inizializzati");
		} else {
			this.utente = utente;
			this.artista = artista;
			this.rank = rank;
		}
	}

	public Utente getUtente() {
		return utente;
	}

	public Artista getArtista() {
		return artista;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
