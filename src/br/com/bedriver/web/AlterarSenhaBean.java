package br.com.bedriver.web;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.bedriver.model.Usuario;
import br.com.bedriver.rn.UsuarioRN;
import br.com.bedriver.util.DAOException;
import br.com.bedriver.util.Utils;
import net.bytebuddy.utility.RandomString;

@ManagedBean(name = "alterarSenhaBean")
@ViewScoped
public class AlterarSenhaBean implements Serializable {

	private static final long serialVersionUID = -8218240456882550331L;
	
	private Usuario usuario;
	private String novaSenha;
	private String confirmarNovaSenha;
	private String email;
	private boolean emailSend = false;
	private static final Logger logger = LogManager.getLogger(AlterarSenhaBean.class);

	public void recuperarSenha() {

		UsuarioRN usuarioRN = new UsuarioRN();

		if (usuarioRN.buscarPorLogin(this.email) == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage();
			facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
			facesMessage.setSummary("Aviso:");
			facesMessage.setDetail("E-mail não encontrado em nosso site.");
			logger.error("E-mail não encontrado em nosso site.");
			context.addMessage("MessageEmailNotFound", facesMessage);
			return;
		}

		this.setEmailSend(true);
		String token = RandomString.make(45);

		String resetPasswordLink = "http://localhost:8080/bedriver/public/resetar_senha.jsf?token=" + token;

		try {
			usuarioRN.updateResetPasswordToken(token, this.email);
			logger.info("Gerando token para: "+email);
		} catch (DAOException e) {
			e.printStackTrace();
			logger.error(e);
		}

		ExecutorService emailExecutor = Executors.newCachedThreadPool();
		emailExecutor.execute(new Runnable() {
			@Override
			public void run() {
				Utils.sendEmail(email, "Recupera��o de Senha", resetPasswordLink);
				logger.info("Email de recuperar senha enviado para :" + email);
			}
		});

	}

	public String salvarNovaSenha() {

		FacesContext context = FacesContext.getCurrentInstance();

		if (!this.getNovaSenha().equals(this.getConfirmarNovaSenha())) {
			FacesMessage facesMessage = new FacesMessage();
			facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
			facesMessage.setSummary("Aviso:");
			facesMessage.setDetail("A senha não foi confirmada corretamente.");
			logger.error("A senha não foi confirmada corretamente.");
			context.addMessage("NewPassNotEquals", facesMessage);
			return null;
		}

		if (!Utils.isStrongPassword(this.getNovaSenha()) || !Utils.isStrongPassword(this.getConfirmarNovaSenha())) {
			FacesMessage facesMessage = new FacesMessage();
			facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
			facesMessage.setSummary("Aviso:");
			facesMessage.setDetail("Informe uma senha mais forte, contendo: "
					+ "8 ou mais caracteres, "
					+ "letras mai�sculas e min�sculas, " 
					+ "n�meros, " 
					+ "caracteres especiais.");
			logger.error("A senha fraca.");
			context.addMessage("NewPasswordNotStrong", facesMessage);
			return null;
		}

		// Utilizando BCrypt na senha
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		this.usuario.setSenha(bcpe.encode(this.novaSenha));
		
		this.usuario.setResetPasswordToken(null);

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		logger.info("Senha alterada com sucesso pelo usuario: "+email);
		
		return "/index";
	}

	public boolean isEmailSend() {
		return emailSend;
	}

	public void setEmailSend(boolean emailSend) {
		this.emailSend = emailSend;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void validaToken(String token) {

		UsuarioRN usuarioRN = new UsuarioRN();
		Usuario usuario = usuarioRN.get(token);

		if (usuario == null) {
			logger.error("token invalido");
			return;
		}
		logger.info("token valido");
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmarNovaSenha() {
		return confirmarNovaSenha;
	}

	public void setConfirmarNovaSenha(String confirmarNovaSenha) {
		this.confirmarNovaSenha = confirmarNovaSenha;
	}
}