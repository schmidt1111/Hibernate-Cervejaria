package com.qintess.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table (name = "venda")
public class Venda implements EntidadeBase {
	@Id                                     
	@GeneratedValue(strategy = GenerationType.IDENTITY)      //autoincremento
	@Column(name = "codigo")
	private int codigo;          //PK NOT NULL
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn (name = "codigo_cliente")
	private Cliente cliente;    //"fk"  NOT NULL
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn (name = "codigo_usuario")
	private Usuario usuario;    //"fk"  NOT NULL
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "data_criacao", nullable = false)
	private Date datacriacao;   //NOT NULL
	
	@Column (name = "valor_frete", precision = 10, scale = 2)
	private double valorfrete;
	
	@Column (name = "valor_desconto", precision = 10, scale = 2)
	private double valordesconto;
	
	@Column (name = "valor_total", nullable = false, precision = 10, scale = 2)
	private double valortotal;   //NOT NULL
	
	@Column (name = "status", nullable = false, length = 30)
	private String status; //NOT NULL
	
	@Column (name = "observacao", length = 200)
	private String observacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "data_hora_entrega")
	private Date datahoraentrega;
	
	public Venda() {}

	public Venda(Cliente cliente, Usuario usuario, Date datacriacao, double valorfrete, double valordesconto,
			double valortotal, String status, String observacao, Date datahoraentrega) {
		this.cliente = cliente;
		this.usuario = usuario;
		this.datacriacao = datacriacao;
		this.valorfrete = valorfrete;
		this.valordesconto = valordesconto;
		this.valortotal = valortotal;
		this.status = status;
		this.observacao = observacao;
		this.datahoraentrega = datahoraentrega;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(Date datacriacao) {
		this.datacriacao = datacriacao;
	}

	public double getValorfrete() {
		return valorfrete;
	}

	public void setValorfrete(double valorfrete) {
		this.valorfrete = valorfrete;
	}

	public double getValordesconto() {
		return valordesconto;
	}

	public void setValordesconto(double valordesconto) {
		this.valordesconto = valordesconto;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDatahoraentrega() {
		return datahoraentrega;
	}

	public void setDatahoraentrega(Date datahoraentrega) {
		this.datahoraentrega = datahoraentrega;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", codigo_cliente=" + cliente + ", codigo_usuario=" + usuario + ", data_criacao="
				+ datacriacao + ", valor_frete=" + valorfrete + ", valor_desconto=" + valordesconto + ", valor_total="
				+ valortotal + ", status=" + status + ", observacao=" + observacao + ", data_hora_entrega="
				+ datahoraentrega + "]";
	}
	
	
	
	
	
	
}
