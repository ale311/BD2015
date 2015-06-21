package logic2.relation;

import logic2.exception.EccezionePrecondizioni;
import logic2.entity.Artista;
import logic2.entity.Utente;

public class ArtistTopFan {

	private final Artista artista;
	private final Utente utente;
	private int rank;

	public ArtistTopFan(Artista artista, Utente utente, int rank) throws EccezionePrecondizioni {
		// CONTROLLO PRECONDIZIONI
		if (artista == null || utente == null) {
			throw new EccezionePrecondizioni(
					"Gli oggetti devono essere inizializzati");
		} else {
			this.artista = artista;
			this.utente = utente;
			this.rank = rank;
		}
	}

	public Artista getArtista() {
		return artista;
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
