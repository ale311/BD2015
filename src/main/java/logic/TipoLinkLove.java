package logic;

public class TipoLinkLove {

	private final Utente loUtente;

	private final Traccia laTraccia;

	public TipoLinkLove(Utente x, Traccia y) throws EccezionePrecondizioni {

		if (x == null || y == null) // CONTROLLO PRECONDIZIONI
			throw new EccezionePrecondizioni
			("Gli oggetti devono essere inizializzati");
		loUtente = x; laTraccia = y;
	}

	public boolean equals(Object o) {

		if (o != null && getClass().equals(o.getClass())) {
			TipoLinkLove b = (TipoLinkLove)o;

			return b.laTraccia == laTraccia && b.loUtente == loUtente;
		}

		else return false;

	}

	public int hashCode() {

		return loUtente.hashCode() + laTraccia.hashCode();

	}

	public Utente getUtente() { return loUtente; }

	public Traccia getTraccia() { return laTraccia; }

}