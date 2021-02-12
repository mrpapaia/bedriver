package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_simulado database table.
 * 
 */
@Entity
@Table(name="usuario_simulado")
@NamedQuery(name="UsuarioSimulado.findAll", query="SELECT u FROM UsuarioSimulado u")
public class UsuarioSimulado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioSimuladoPK id;

	private Integer nota;

	//bi-directional many-to-one association to Simulado
	@ManyToOne
	@JoinColumn(name="id_simulados")
	private Simulado simulado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public UsuarioSimulado() {
	}

	public UsuarioSimuladoPK getId() {
		return this.id;
	}

	public void setId(UsuarioSimuladoPK id) {
		this.id = id;
	}

	public Integer getNota() {
		return this.nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Simulado getSimulado() {
		return this.simulado;
	}

	public void setSimulado(Simulado simulado) {
		this.simulado = simulado;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
		result = prime * result + ((simulado == null) ? 0 : simulado.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		UsuarioSimulado other = (UsuarioSimulado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		if (simulado == null) {
			if (other.simulado != null)
				return false;
		} else if (!simulado.equals(other.simulado))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}