package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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

	@Temporal(TemporalType.DATE)
	@Column(name="data_realizado")
	private Date dataRealizado;

	private int nota;

	//bi-directional many-to-one association to Simulado
	@ManyToOne
	@JoinColumn(name="id_simulados",referencedColumnName = "id",insertable=false, updatable=false)
	private Simulado simulado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario",referencedColumnName = "id",insertable=false, updatable=false)
	private Usuario usuario;

	public UsuarioSimulado() {
	}

	public UsuarioSimuladoPK getId() {
		return this.id;
	}

	public void setId(UsuarioSimuladoPK id) {
		this.id = id;
	}

	public Date getDataRealizado() {
		return this.dataRealizado;
	}

	public void setDataRealizado(Date dataRealizado) {
		this.dataRealizado = dataRealizado;
	}

	public int getNota() {
		return this.nota;
	}

	public void setNota(int nota) {
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
		result = prime * result + ((dataRealizado == null) ? 0 : dataRealizado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + nota;
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
		if (dataRealizado == null) {
			if (other.dataRealizado != null)
				return false;
		} else if (!dataRealizado.equals(other.dataRealizado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nota != other.nota)
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