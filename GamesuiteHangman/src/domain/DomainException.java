package domain;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 3471963563294966388L;

	public DomainException(){
		super();
	}

	public DomainException(String string) {
		super(string);
	}
	
}
