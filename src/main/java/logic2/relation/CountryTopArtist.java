package logic2.relation;

import logic2.exception.EccezionePrecondizioni;
import logic2.entity.Artista;
import logic2.entity.Nazione;

public class CountryTopArtist {

	private final Nazione nazione;
	private final Artista artista;
	private int rank;

	public CountryTopArtist(Nazione nazione, Artista artista, int rank) throws EccezionePrecondizioni {
		// CONTROLLO PRECONDIZIONI
		if (nazione == null || artista == null) {
			throw new EccezionePrecondizioni(
					"Gli oggetti devono essere inizializzati");
		} else {
			this.nazione = nazione;
			this.artista = artista;
			this.rank = rank;
		}
	}

	public Nazione getNazione() {
		return nazione;
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
