package fr.cesi.poealtran.demospring.handler;

import com.fasterxml.jackson.annotation.JsonIgnore;


public interface ExceptionMixIn {

	@JsonIgnore
	StackTraceElement getStackTrace();
	@JsonIgnore
	Throwable getCause();
	@JsonIgnore
	Throwable[] getSuppressed();
	
}
