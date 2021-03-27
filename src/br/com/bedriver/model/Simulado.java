package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the simulados database table.
 * 
 */
@Entity
@Table(name="simulados")
@NamedQuery(name="Simulado.findAll", query="SELECT s FROM Simulado s")
public class Simulado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-many association to Pergunta
	@ManyToMany
	@JoinTable(
		name="simulado_perguntas"
		, joinColumns={
			@JoinColumn(name="id_simulado")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_pergunta")
			}
		)
	private List<Pergunta> perguntas;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	//bi-directional many-to-one association to UsuarioSimulado
	@OneToMany(mappedBy="simulado")
	private List<UsuarioSimulado> usuarioSimulados;

	public Simulado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Pergunta> getPerguntas() {
		return this.perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<UsuarioSimulado> getUsuarioSimulados() {
		return this.usuarioSimulados;
	}

	public void setUsuarioSimulados(List<UsuarioSimulado> usuarioSimulados) {
		this.usuarioSimulados = usuarioSimulados;
	}

	public UsuarioSimulado addUsuarioSimulado(UsuarioSimulado usuarioSimulado) {
		getUsuarioSimulados().add(usuarioSimulado);
		usuarioSimulado.setSimulado(this);

		return usuarioSimulado;
	}

	public UsuarioSimulado removeUsuarioSimulado(UsuarioSimulado usuarioSimulado) {
		getUsuarioSimulados().remove(usuarioSimulado);
		usuarioSimulado.setSimulado(null);

		return usuarioSimulado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + id;
		result = prime * result + ((perguntas == null) ? 0 : perguntas.hashCode());
		result = prime * result + ((usuarioSimulados == null) ? 0 : usuarioSimulados.hashCode());
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
		Simulado other = (Simulado) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id != other.id)
			return false;
		if (perguntas == null) {
			if (other.perguntas != null)
				return false;
		} else if (!perguntas.equals(other.perguntas))
			return false;
		if (usuarioSimulados == null) {
			if (other.usuarioSimulados != null)
				return false;
		} else if (!usuarioSimulados.equals(other.usuarioSimulados))
			return false;
		return true;
	}

}