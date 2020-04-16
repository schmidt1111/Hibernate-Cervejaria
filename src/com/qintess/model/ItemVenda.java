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
@Table (name = "item_venda")
public class ItemVenda implements EntidadeBase {
	@Id                                     
	@GeneratedValue(strategy = GenerationType.IDENTITY)      //autoincremento
	@Column (name = "codigo")
	private int codigo;                  //PK NOT NULL
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn (name = "codigo_cerveja")
	private Cerveja cerveja;             //"fk" NOT NULL
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn (name = "codigo_venda")
	private Venda venda;                 //"fk" NOT NULL
	
	@Column (name = "quantidade",  nullable = false)
	private int quantidade;              //NOT NULL
	
	@Column (name = "valor_unitario",  nullable = false, precision = 10, scale = 2)
	private double valorunitario;        //NOT NULL
	
	public ItemVenda() {}

	public ItemVenda(Cerveja cerveja, Venda venda, int quantidade, double valorunitario) {
		this.cerveja = cerveja;
		this.venda = venda;
		this.quantidade = quantidade;
		this.valorunitario = valorunitario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorunitario() {
		return valorunitario;
	}

	public void setValorunitario(double valorunitario) {
		this.valorunitario = valorunitario;
	}

	@Override
	public String toString() {
		return "ItemVenda [codigo=" + codigo + ", codigo_cerveja=" + cerveja + ", codigo_venda=" + venda + ", quantidade="
				+ quantidade + ", valor_unitario=" + valorunitario + "]";
	}
	
	
	
	
	
}
