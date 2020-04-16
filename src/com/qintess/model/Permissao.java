package com.qintess.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "permissao")
public class Permissao implements EntidadeBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column (name = "codigo")
	private int codigo;        //PK NOT NULL
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "permissoes")
	private List<Grupo> grupos = new ArrayList<>();
	
	@Column (name = "nome", nullable = false, length = 50)
	private String nome;
	
	public Permissao() {
	}
	
	public Permissao (String nome) {
		this.nome = nome;
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
	
	@Override
	public String toString() {
		return "Permissao [codigo=" + codigo + ", nome=" + nome + "]";
	}
}
