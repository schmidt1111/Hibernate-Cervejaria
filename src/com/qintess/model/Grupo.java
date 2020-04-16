package com.qintess.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "grupo")
public class Grupo implements EntidadeBase {
	@Id                                     
	@GeneratedValue(strategy = GenerationType.IDENTITY)      //autoincremento
	@Column(name = "codigo")
	private int codigo;    //PK NOT NULL
	
	@Column (name = "nome", nullable = false, length = 50)
	private String nome;   //NOT NULL
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Permissao> permissoes = new ArrayList<Permissao>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "grupos")
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	
	public Grupo() {}

	public Grupo(String nome) {
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

	public void addPermissao(Permissao permissao) {
		if(permissoes == null) {
			permissoes = new ArrayList<>(); 		}
		permissoes.add(permissao);
	}
	
	public void removePermissao(Permissao permissao) {
		permissoes.remove(permissao);
	}
	
	@Override
	public String toString() {
		return "Grupo [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
	
}
