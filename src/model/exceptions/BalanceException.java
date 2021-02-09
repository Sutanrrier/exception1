package model.exceptions;

public class BalanceException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public BalanceException(String msg) {
		super(msg);
	}
}
