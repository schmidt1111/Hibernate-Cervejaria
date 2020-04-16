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
@Table (name = "cliente")
public class Cliente implements EntidadeBase{
	@Id                                     
	@GeneratedValue(strategy = GenerationType.IDENTITY)      //autoincremento
	@Column(name = "codigo")
	private int codigo; //PK NOT NULL
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn( name = "codigo_cidade")
	private Cidade codigocidade;  //"fk" NOT NULL
	
	@Column( name = "nome", nullable = false, length = 80)
	private String nome;  //NOT NULL
	
	@Column( name = "tipo_pessoa", nullable = false, length = 15)
	private String tipopessoa; //NOT NULL
	
	@Column( name = "cpf_cnpj", nullable = false, length = 30)
	private String cpfcnpj; //NOT NULL
	
	@Column( name = "telefone", length = 20)
	private String telefone;
	
	@Column( name = "email", nullable = false, length = 50)
	private String email;  //NOT NULL
	
	@Column( name = "logradouro", length = 50)
	private String logradouro;
	
	@Column( name = "numero", length = 15)
	private String numero;
	
	@Column( name = "complemento", length = 20)
	private String complemento;
	
	@Column( name = "cep", length = 15)
	private String cep;
	
	public Cliente() {}

	public Cliente(Cidade codigocidade, String nome, String tipopessoa, String cpfcnpj, String telefone, String email,
			String logradouro, String numero, String complemento, String cep) {
		this.codigocidade = codigocidade;
		this.nome = nome;
		this.tipopessoa = tipopessoa;
		this.cpfcnpj = cpfcnpj;
		this.telefone = telefone;
		this.email = email;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cidade getCidade() {
		return codigocidade;
	}

	public void setCidade(Cidade codigocidade) {
		this.codigocidade = codigocidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipopessoa() {
		return tipopessoa;
	}

	public void setTipopessoa(String tipopessoa) {
		this.tipopessoa = tipopessoa;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", codigo_cidade=" + codigocidade + ", nome=" + nome + ", tipopessoa=" + tipopessoa
				+ ", cpfcnpj=" + cpfcnpj + ", telefone=" + telefone + ", email=" + email + ", logradouro=" + logradouro
				+ ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + "]";
	}
	
	
}

