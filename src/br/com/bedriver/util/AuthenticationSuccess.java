package br.com.bedriver.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import br.com.bedriver.web.UsuarioBean;

public class AuthenticationSuccess implements AuthenticationSuccessHandler{
	private static final Logger logger = LogManager.getLogger(AuthenticationSuccess.class);
	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(authentication.isAuthenticated()) {
		     logger.info("Logado com sucesso, "+request.getRemoteUser()+", IP: "+request.getRemoteAddr()+", Navegador: "+request.getHeader("user-agent"));

			response.sendRedirect("/bedriver/");
		 }else {
			System.out.println("asdadsadadasd"); 
		 }
		
		
	}
	
	
}
