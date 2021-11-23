package com.example.demo.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.example.demo.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	//@Temporal(TemporalType.DATE)
	private Date datavencimento;
	
	//@Temporal(TemporalType.DATE)
	private Date datapagamento;
	
    public PagamentoComBoleto() {   	
    }

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido,
			   Date datavencimento ,Date datapagamento ) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.datapagamento = datapagamento;
		this.datavencimento = datavencimento;
	}

	public Date getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	public Date getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Date datapagamento) {
		this.datapagamento = datapagamento;
	}


}

