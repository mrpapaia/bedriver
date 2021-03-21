package br.com.bedriver.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthenticationFailure implements AuthenticationFailureHandler {
	private static final Logger logger = LogManager.getLogger(AuthenticationFailure.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		logger.error("Tentativa de login com o email: " + request.getRemoteUser() + " falhou, Motivo: "
				+ exception.getMessage() + " IP: " + request.getRemoteAddr() + ", Navegador: "
				+ request.getHeader("user-agent"));

		response.sendRedirect("/bedriver/index.jsf?login_error=1");
	}

}
