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
@Table (name = "cerveja")
public class Cerveja implements EntidadeBase {
	
	@Id                                     
	@GeneratedValue(strategy = GenerationType.IDENTITY)      //autoincremento
	@Column(name = "codigo")
	private int codigo;              //PK  NOT NULL
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name ="codigo_estilo")
	private Estilo codigoestilo;           //"fk"  NOT NULL
	
	@Column(name = "sku", nullable = false, length = 50)
	private String sku;              //NOT NULL
	
	@Column(name = "nome", nullable = false, length = 80)
	private String nome;             //NOT NULL
	
	@Column(name = "descricao", nullable = false, columnDefinition="TEXT")
	private String descricao;        //NOT NULL
	
	@Column(name = "valor", nullable = false, precision = 10, scale = 2)
	private double valor;            //NOT NULL
	
	@Column(name = "comissao", nullable = false, columnDefinition = "DECIMAL(10,2)")
	private double comissao;         //NOT NULL
	
	@Column(name = "sabor", nullable = false, length = 50)
	private String sabor;            //NOT NULL
	
	@Column(name = "origem", nullable = false, length = 50)
	private String origem;            //NOT NULL
	
	@Column(name = "teor_alcoolico", nullable = false, precision = 10, scale = 2)
	private double teoralcoolico;     //NOT NULL  
	
	@Column(name = "quantidade_estoque")
	private int quantidadeestoque;
	
	@Column(name = "foto", length = 100)
	private String foto;
	
	@Column(name = "content_type", length = 100)
	private String contenttype;
	
	public Cerveja() {}

	public Cerveja(Estilo codigoestilo, String sku, String nome, String descricao, double valor, double comissao,
			String sabor, String origem, double teoralcoolico, int quantidadeestoque, String foto, String contenttype) {
		this.codigoestilo = codigoestilo;
		this.sku = sku;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.comissao = comissao;
		this.sabor = sabor;
		this.origem = origem;
		this.teoralcoolico = teoralcoolico;
		this.quantidadeestoque = quantidadeestoque;
		this.foto = foto;
		this.contenttype = contenttype;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Estilo getEstilo() {
		return codigoestilo;
	}

	public void setEstilo(Estilo codigoestilo) {
		this.codigoestilo = codigoestilo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public double getTeoralcoolico() {
		return teoralcoolico;
	}

	public void setTeoralcoolico(double teoralcoolico) {
		this.teoralcoolico = teoralcoolico;
	}

	public int getQuantidadeestoque() {
		return quantidadeestoque;
	}

	public void setQuantidadeestoque(int quantidadeestoque) {
		this.quantidadeestoque = quantidadeestoque;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContenttype() {
		return contenttype;
	}

	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}

	@Override
	public String toString() {
		return "Cerveja [codigo=" + codigo + ", codigo_estilo=" + codigoestilo + ", sku=" + sku + ", nome=" + nome + ", descricao="
				+ descricao + ", valor=" + valor + ", comissao=" + comissao + ", sabor=" + sabor + ", origem=" + origem
				+ ", teor_alcoolico=" + teoralcoolico + ", quantidade_estoque=" + quantidadeestoque + ", foto=" + foto
				+ ", content_type=" + contenttype + "]";
	}
}

