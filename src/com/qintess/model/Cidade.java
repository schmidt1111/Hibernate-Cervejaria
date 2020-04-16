package com.qintess.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "cidade")
public class Cidade implements EntidadeBase {
	
	@Id                                     
	@GeneratedValue(strategy = GenerationType.IDENTITY)      //autoincremento
	@Column(name = "codigo")
	private int codigo;  //PK NOT NULL
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn (name = "codigo_estado")
	private Estado codigoestado;  //"fk" NOT NULL
	
	@Column (name = "nome", nullable = false, length = 50)
	private String nome;  //NOT NULL

	public Cidade() {}

	public Cidade(Estado codigoestado, String nome) {
		this.codigoestado = codigoestado;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Estado getEstado() {
		return codigoestado;
	}

	public void setEstado(Estado codigoestado) {
		this.codigoestado = codigoestado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cidade [codigo=" + codigo + ", codigo_estado=" + codigoestado + ", nome=" + nome + "]";
	}
	
	
}
