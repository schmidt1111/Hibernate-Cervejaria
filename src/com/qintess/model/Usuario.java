package com.qintess.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
@Table (name = "usuario")
public class Usuario implements EntidadeBase {
	@Id                                     
	@GeneratedValue(strategy = GenerationType.IDENTITY)      //autoincremento
	@Column(name = "codigo")
	private int codigo;                 //PK NOT NULL
	
	@Column (name = "nome", nullable = false, length = 50)
	private String nome;                //NOT NULL
	
	@Column (name = "email", nullable = false, length = 50)
	private String email;               //NOT NULL
	
	@Column (name = "senha", nullable = false, length = 120)
	private String senha;               //NOT NULL
	
	@Column (name = "ativo", nullable = false)
	private short ativo;   //NOT NULL
	
	@Temporal(TemporalType.DATE)
	@Column (name = "datanascimento")
	private Date datanascimento;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_grupo",
	joinColumns = @JoinColumn(name = "usuario_id"),
	inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	List<Grupo> grupos = new ArrayList<Grupo>();


	
	public Usuario () {}
	
	public Usuario(String nome, String email, String senha, short ativo, Date datanascimento) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
		this.datanascimento = datanascimento;
	}
	public void addGrupo(Grupo grupo) {
		if(grupos == null) {
			grupos = new ArrayList<>(); 	}
		this.grupos.add(grupo);
	}

	public void removeGrupo(Grupo grupo) {
		this.grupos.remove(grupo);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public short getAtivo() {
		return ativo;
	}

	public void setAtivo(short ativo) {
		this.ativo = ativo;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", ativo="
				+ ativo + ", data_nascimento=" + datanascimento + "]";
	}
}
