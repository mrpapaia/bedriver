package br.com.bedriver.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.bedriver.model.Usuario;
import br.com.bedriver.rn.UsuarioRN;
import br.com.bedriver.util.Utils;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	private List<Usuario> lista;
	private String destinoSalvar;

	public String novo() {
		this.destinoSalvar = "usuariosucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		;
		return "/public/usuario";
	}

	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		return "/admin/usuarioEditar";
	}

	public String salvar() {

		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();

		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage();
			facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
			facesMessage.setSummary("Aviso:");
			facesMessage.setDetail("A senha não foi confirmada corretamente.");
			context.addMessage("PasswordNotEquals", facesMessage);
			return null;
		}
		
		if (!Utils.isStrongPassword(senha) || !Utils.isStrongPassword(confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage();
			facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
			facesMessage.setSummary("Aviso:");
			facesMessage.setDetail("Informe uma senha mais forte, contendo: " 
					+ "8 ou mais caracteres, "
					+ "letras maiúsculas e minúsculas, " 
					+ "números, " 
					+ "caracteres especiais.");
			context.addMessage("PasswordNotStrong", facesMessage);
			return null;
		}

		// Utilizando BCrypt na senha
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		this.usuario.setSenha(bcpe.encode(senha));

		// Permisssão padrão de usuário
		this.usuario.setPermissao("ROLE_USUARIO");

		// Setando o usuário como ativo
		this.usuario.setAtivo(true);

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);

		return "/index";
	}

	public String salvarEditar() {
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();

		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha nï¿½o foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);

		return "/admin/principal";
	}

	public String excluir(String email) {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(usuarioRN.buscarPorLogin(email));
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo())
			this.usuario.setAtivo(false);
		else
			this.usuario.setAtivo(true);

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}

	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public void atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;

		if (this.usuario.getPermissao().equals("ROLE_ADMINISTRADOR") && permissao.equals("ROLE_ADMINISTRADOR")) {
			this.usuario.setPermissao("ROLE_USUARIO");
		} else if (this.usuario.getPermissao().equals("ROLE_USUARIO") && permissao.equals("ROLE_ADMINISTRADOR")) {
			this.usuario.setPermissao("ROLE_ADMINISTRADOR");
		}

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
	}

	public String getNameUser(HttpServletRequest request) {
		String email = request.getRemoteUser();
		if (email == null) {
			return "";
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		String nome = usuarioRN.buscarPorLogin(email).getNome();
		String nomeSplited[] = nome.split(" ");

		return nomeSplited[0] + " " + nomeSplited[1];
	}
}
