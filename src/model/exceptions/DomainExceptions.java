package model.exceptions;

public class DomainExceptions  extends Exception {
	private static final long serialVersionUID = 1L; // é padrao quando pedir version deixar assim
	
	public DomainExceptions (String msg) {
		super(msg);
	}

}
