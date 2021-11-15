package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServices {
	@Autowired
	private CategoriaRepository repo ;
	public Categoria Buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
        
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
			+ ", Tipo: " + Categoria.class.getName());
			}
		
		return obj.orElse(null);
	}

}
