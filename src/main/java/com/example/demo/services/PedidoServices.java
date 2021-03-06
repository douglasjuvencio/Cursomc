package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pedido;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoServices {
	@Autowired
	private PedidoRepository repo ;
	public Pedido Buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
        
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
			+ ", Tipo: " + Pedido.class.getName());
			}
		
		return obj.orElse(null);
	}

}
