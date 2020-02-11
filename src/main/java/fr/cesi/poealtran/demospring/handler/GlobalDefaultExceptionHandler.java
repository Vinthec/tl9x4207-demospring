package fr.cesi.poealtran.demospring.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.cesi.poealtran.demospring.exceptions.ServerException;


@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

	@ExceptionHandler({ HttpMessageNotReadableException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Exception badRequestExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.info("400 Bad Request", e);
		throw e;
	}

	@ExceptionHandler({ AccessDeniedException.class, HttpRequestMethodNotSupportedException.class })
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public Exception accessDeniedExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.info("403 Forbidden access", e);
		return e;
	}

	@ExceptionHandler(value = Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ServerException defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ServerException serverException = new ServerException(e);
		logger.error("ServerException : " + serverException.getIdentifiant(), e);
		return serverException;
	}
}
