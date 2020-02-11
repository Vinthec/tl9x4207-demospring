package fr.cesi.poealtran.demospring.exceptions;

public class UnexpectedAttributeValueException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UnexpectedAttributeValueException(String string) {
		super(string);
	}

}
