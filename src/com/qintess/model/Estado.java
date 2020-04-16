package com.qintess.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "estado")
public class Estado implements EntidadeBase {
	
	@Id                                     
	@GeneratedValue(strategy = GenerationType.IDENTITY)      //autoincremento
	@Column(name = "codigo")
	private int codigo;        //PK NOT NULL
	
	@Column (name = "nome", nullable = false, length = 50)
	private String nome;       //NOT NULL
	
	@Column (name = "sigla", nullable = false, length = 2)
	private String sigla;      //NOT NULL
	
	//@OneToMany(cascade = {CascadeType.ALL})
	//private List<Cidade> cidade;

	public Estado() {}

	public Estado(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "Estado [codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	
	
}
