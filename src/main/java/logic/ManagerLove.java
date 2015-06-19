package logic;

public final class ManagerLove {
	private ManagerLove(TipoLinkLove x) { link = x; }
	private TipoLinkLove link;
	public TipoLinkLove getLink() { return link; }
	
	public static void inserisci(TipoLinkLove y) {
		if (y != null) {
			ManagerLove k = new ManagerLove(y);
			y.getUtente().inserisciPerManagerLove(k);
			y.getTraccia().inserisciPerManagerLove(k);
		}
	}

	public static void elimina(TipoLinkLove y) {
		if (y != null) {
			ManagerLove k = new ManagerLove(y);
			y.getUtente().eliminaPerManagerLove(k);
			y.getTraccia().eliminaPerManagerLove(k);
		}
	}
}