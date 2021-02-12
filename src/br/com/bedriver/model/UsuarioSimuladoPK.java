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
	private Integer idUsuario;

	@Column(name="id_simulados", insertable=false, updatable=false)
	private Integer idSimulados;

	public UsuarioSimuladoPK() {
	}
	public Integer getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdSimulados() {
		return this.idSimulados;
	}
	public void setIdSimulados(Integer idSimulados) {
		this.idSimulados = idSimulados;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioSimuladoPK)) {
			return false;
		}
		UsuarioSimuladoPK castOther = (UsuarioSimuladoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idSimulados == castOther.idSimulados);
	}

	public int hashCode() {
		final Integer prime = 31;
		Integer hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.idSimulados;
		
		return hash;
	}
}