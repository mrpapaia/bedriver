package br.com.bedriver.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.bedriver.model.Estado;
import br.com.bedriver.model.FrotaVeiculo;
import br.com.bedriver.rn.EstadoRN;
import br.com.bedriver.rn.FrotaRN;

public class Utils {
	
    public static Map<String, Number> getFrotasEstados() {
    	
        Map<String, Number> dados = new HashMap<>();
        
        FrotaRN frotaRN = new FrotaRN();
        List<FrotaVeiculo> listaFrotas = frotaRN.listar();
        HashMap<String, Integer> qtdVeiculos = new HashMap<>();
        
        for(FrotaVeiculo f : listaFrotas) {
        	String uf = f.getCidade().getEstado().getUf();
        	Integer qtdVeiculo = qtdVeiculos.get(uf);
        	if(qtdVeiculo == null){
        		qtdVeiculo = 0;
        	}
        	qtdVeiculos.put(uf, qtdVeiculo + f.getQtdVeiculos());
        }
        
        for(String estado : qtdVeiculos.keySet()) {
        	dados.put(estado, qtdVeiculos.get(estado));
        }

        return dados;
    }
	
	public static Estado getEstados(String sigla) {
		
		EstadoRN estadoRN = new EstadoRN();
		List<Estado> estados = estadoRN.listar();
	
        for (Estado estado : estados){
            if (sigla.equals(estado.getUf())){
                return estado;
            }
        }
        
        return null;
	}
	
	public static boolean isStrongPassword(String password) {
		return password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
	}
	
	public static void sendEmail(String emailReceiver, String titleEmail,
			String linkPasswordReset) {

		final String username = "bedriverapp@gmail.com";
		final String password = "Projeto=Web+Seg";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailReceiver));
			message.setSubject(titleEmail);
			message.setContent("<a href=\"" +  linkPasswordReset + "\">Resetar Senha</a>", "text/html");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}