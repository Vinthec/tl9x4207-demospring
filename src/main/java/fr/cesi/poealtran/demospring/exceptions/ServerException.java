package fr.cesi.poealtran.demospring.exceptions;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties({"localizedMessage", "message", "cause", "suppressed", "stackTrace"})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME , include = JsonTypeInfo.As.PROPERTY)
public class ServerException extends Exception {

	private static final long serialVersionUID = 1L;
	private String identifiant = UUID.randomUUID().toString();
	
	public ServerException(Throwable e) {
		super(e);
	}
	public String getIdentifiant() {
		return identifiant;
	}
	
}
