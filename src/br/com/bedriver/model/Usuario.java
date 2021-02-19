package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private boolean ativo;

	private String email;

	private String nome;

	private String permissao;

	private String senha;

	//bi-directional many-to-one association to UsuarioSimulado
//	@OneToMany(mappedBy="usuario")
	//private List<UsuarioSimulado> usuarioSimulados;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	@Column(name = "reset_password_token")
	private String resetPasswordToken;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPermissao() {
		return this.permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/*public List<UsuarioSimulado> getUsuarioSimulados() {
		return this.usuarioSimulados;
	}

	public void setUsuarioSimulados(List<UsuarioSimulado> usuarioSimulados) {
		this.usuarioSimulados = usuarioSimulados;
	}

	public UsuarioSimulado addUsuarioSimulado(UsuarioSimulado usuarioSimulado) {
		getUsuarioSimulados().add(usuarioSimulado);
		usuarioSimulado.setUsuario(this);

		return usuarioSimulado;
	}

	public UsuarioSimulado removeUsuarioSimulado(UsuarioSimulado usuarioSimulado) {
		getUsuarioSimulados().remove(usuarioSimulado);
		usuarioSimulado.setUsuario(null);

		return usuarioSimulado;
	}*/

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public boolean isAtivo() {
		return ativo;
	}
	
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((resetPasswordToken == null) ? 0 : resetPasswordToken.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (resetPasswordToken == null) {
			if (other.resetPasswordToken != null)
				return false;
		} else if (!resetPasswordToken.equals(other.resetPasswordToken))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", ativo=" + ativo + ", email=" + email + ", nome=" + nome + ", permissao="
				+ permissao + ", senha=" + senha + ", estado=" + estado.getNome() + ", resetPasswordToken=" + resetPasswordToken
				+ "]";
	}
	
}