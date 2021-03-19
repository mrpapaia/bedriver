package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuario_simulado database table.
 * 
 */
@Embeddable
public class UsuarioSimuladoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_usuario", insertable=false, updatable=false)
	private int idUsuario;

	@Column(name="id_simulados", insertable=false, updatable=false)
	private int idSimulados;

	public UsuarioSimuladoPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdSimulados() {
		return this.idSimulados;
	}
	public void setIdSimulados(int idSimulados) {
		this.idSimulados = idSimulados;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioSimuladoPK other = (UsuarioSimuladoPK) obj;
		if (idSimulados != other.idSimulados)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSimulados;
		result = prime * result + idUsuario;
		return result;
	}
}