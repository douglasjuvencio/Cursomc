package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
    
	@Autowired
	private CategoriaRepository  categoriaRepository;
	
	@Autowired
	private ProdutoRepository  produtoRepository;

	@Autowired
	private EstadoRepository  estadoRepository;

	@Autowired
	private CidadeRepository  cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria c1 = new Categoria(null,"Informatia");
		Categoria c2 = new Categoria(null,"Escritorio");
		Categoria c3 = new Categoria(null,"Portaria");
		
		Produto p1 = new Produto (null,"Computador",2001.78);
		Produto p2 = new Produto (null,"IMpressora",599.67);
		Produto p3 = new Produto (null,"Mouse",21.34);
        
		Estado est1 = new Estado(null, "SC");
		Estado est2 = new Estado(null, "RS");
		
		Cidade ci1 = new Cidade(null,"Criciuma", est1);
		Cidade ci2 = new Cidade(null,"Porto Alegre",est2);
		
	    est1.getCidades().addAll(Arrays.asList(ci1));	
	    est2.getCidades().addAll(Arrays.asList(ci2, ci1));	
	    
		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	    c2.getProdutos().addAll(Arrays.asList(p2));
	    
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().addAll(Arrays.asList(c2));

		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(ci1, ci2));

	}
}
