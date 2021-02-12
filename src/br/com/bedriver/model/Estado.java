package br.com.bedriver.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estados database table.
 * 
 */
@Entity
@Table(name="estados")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	private String uf;

	//bi-directional many-to-one association to Cidade
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades;

	//bi-directional many-to-one association to CondutoresHab
	@OneToMany(mappedBy="estado")
	private List<CondutoresHab> condutoresHabs;

	//bi-directional one-to-one association to FrotaVeiculo
	@OneToOne
	@JoinColumn(name="id")
	private FrotaVeiculo frotaVeiculo;

	//bi-directional many-to-one association to Regioe
	@ManyToOne
	@JoinColumn(name="id_regiao")
	private Regiao regiao;

	//bi-directional many-to-one association to Infracoe
	@OneToMany(mappedBy="estado")
	private List<Infracoe> infracoes;

	//bi-directional many-to-one association to Simulado
//	@OneToMany(mappedBy="estado")
	//private List<Simulado> simulados;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="estado")
	private List<Usuario> usuarios;

	public Estado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cidade> getCidades() {
		return this.cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade addCidade(Cidade cidade) {
		getCidades().add(cidade);
		cidade.setEstado(this);

		return cidade;
	}

	public Cidade removeCidade(Cidade cidade) {
		getCidades().remove(cidade);
		cidade.setEstado(null);

		return cidade;
	}

	public List<CondutoresHab> getCondutoresHabs() {
		return this.condutoresHabs;
	}

	public void setCondutoresHabs(List<CondutoresHab> condutoresHabs) {
		this.condutoresHabs = condutoresHabs;
	}

	public CondutoresHab addCondutoresHab(CondutoresHab condutoresHab) {
		getCondutoresHabs().add(condutoresHab);
		condutoresHab.setEstado(this);

		return condutoresHab;
	}

	public CondutoresHab removeCondutoresHab(CondutoresHab condutoresHab) {
		getCondutoresHabs().remove(condutoresHab);
		condutoresHab.setEstado(null);

		return condutoresHab;
	}

	public FrotaVeiculo getFrotaVeiculo() {
		return this.frotaVeiculo;
	}

	public void setFrotaVeiculo(FrotaVeiculo frotaVeiculo) {
		this.frotaVeiculo = frotaVeiculo;
	}

	public Regiao getRegiao() {
		return this.regiao;
	}

	public void setRegioe(Regiao regioe) {
		this.regiao = regioe;
	}

	public List<Infracoe> getInfracoes() {
		return this.infracoes;
	}

	public void setInfracoes(List<Infracoe> infracoes) {
		this.infracoes = infracoes;
	}

	public Infracoe addInfracoe(Infracoe infracoe) {
		getInfracoes().add(infracoe);
		infracoe.setEstado(this);

		return infracoe;
	}

	public Infracoe removeInfracoe(Infracoe infracoe) {
		getInfracoes().remove(infracoe);
		infracoe.setEstado(null);

		return infracoe;
	}
/*
	public List<Simulado> getSimulados() {
		return this.simulados;
	}

	public void setSimulados(List<Simulado> simulados) {
		this.simulados = simulados;
	}

	public Simulado addSimulado(Simulado simulado) {
		getSimulados().add(simulado);
		simulado.setEstado(this);

		return simulado;
	}

	public Simulado removeSimulado(Simulado simulado) {
		getSimulados().remove(simulado);
		simulado.setEstado(null);

		return simulado;
	}
*/
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setEstado(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setEstado(null);

		return usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidades == null) ? 0 : cidades.hashCode());
		result = prime * result + ((condutoresHabs == null) ? 0 : condutoresHabs.hashCode());
		result = prime * result + ((frotaVeiculo == null) ? 0 : frotaVeiculo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((infracoes == null) ? 0 : infracoes.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
		//result = prime * result + ((simulados == null) ? 0 : simulados.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		Estado other = (Estado) obj;
		if (cidades == null) {
			if (other.cidades != null)
				return false;
		} else if (!cidades.equals(other.cidades))
			return false;
		if (condutoresHabs == null) {
			if (other.condutoresHabs != null)
				return false;
		} else if (!condutoresHabs.equals(other.condutoresHabs))
			return false;
		if (frotaVeiculo == null) {
			if (other.frotaVeiculo != null)
				return false;
		} else if (!frotaVeiculo.equals(other.frotaVeiculo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (infracoes == null) {
			if (other.infracoes != null)
				return false;
		} else if (!infracoes.equals(other.infracoes))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (regiao == null) {
			if (other.regiao != null)
				return false;
		} else if (!regiao.equals(other.regiao))
			return false;
	/*	if (simulados == null) {
			if (other.simulados != null)
				return false;
		} else if (!simulados.equals(other.simulados))
			return false;*/
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

}