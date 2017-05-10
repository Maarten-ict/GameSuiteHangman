package db;

public class DbException extends IllegalArgumentException{
	private static final long serialVersionUID = -6796749518778847734L;

	public DbException(){
		super();
	}
	
	public DbException(String message){
		super(message);
	}
}
