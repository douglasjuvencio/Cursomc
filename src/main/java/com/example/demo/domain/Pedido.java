package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 

	private Integer id;
	private Date instante;

	@JsonIgnore   
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;
	
	@JsonIgnore
   	@ManyToOne
    @JoinColumn(name="cliente_id")
	private Cliente cliente;
	
   	
   	@ManyToOne
    @JoinColumn(name="enderecoentrega_id")
    private Endereco enderecoentrega;
   	
   	@OneToMany(mappedBy = "id.pedido")   	
   	private Set<ItemPedido> itens = new HashSet<>();
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	

	public Pedido() {
		
	}

	public Pedido(Integer id, Date instante, Cliente cliente,  Endereco enderecoentrega) {

		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoentrega = enderecoentrega;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Endereco getEnderecoentrega() {
		return enderecoentrega;
	}

	public void setEnderecoentrega(Endereco enderecoentrega) {
		this.enderecoentrega = enderecoentrega;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
    	

}
