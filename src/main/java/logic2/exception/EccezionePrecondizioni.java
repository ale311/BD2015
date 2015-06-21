package logic2.exception;

public class EccezionePrecondizioni extends Exception {
	public EccezionePrecondizioni(String m) {
		super(m);
	}
	public EccezionePrecondizioni() {
		super("Si e’ verificata una violazione delle precondizioni");
	}
}