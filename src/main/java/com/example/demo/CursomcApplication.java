package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Pagamento;
import com.example.demo.domain.PagamentoComBoleto;
import com.example.demo.domain.PagamentoComCartao;
import com.example.demo.domain.Pedido;
import com.example.demo.domain.Produto;
import com.example.demo.domain.enums.EstadoPagamento;
import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.repositories.ItemPedidoRepository;
import com.example.demo.repositories.PagamentoRepository;
import com.example.demo.repositories.PedidoRepository;
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
	
	@Autowired
	private ClienteRepository  clienteRepository;

	@Autowired
	private EnderecoRepository  enderecoRepository;

	@Autowired
	private PedidoRepository  pedidoRepository;
	
	@Autowired
	private PagamentoRepository  pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository  itempedidoRepository;

	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		Categoria cat3 = new Categoria(null,"Portaria");
		
		Produto p1 = new Produto (null,"Computador",2001.78);
		Produto p2 = new Produto (null,"IMpressora",599.67);
		Produto p3 = new Produto (null,"Mouse",21.34);
        
		Estado est1 = new Estado(null, "SC");
		Estado est2 = new Estado(null, "RS");
		
		Cidade ci1 = new Cidade(null,"Criciuma", est1);
		Cidade ci2 = new Cidade(null,"Porto Alegre",est2);
		
		est1.getCidades().addAll(Arrays.asList(ci1));	
	    est2.getCidades().addAll(Arrays.asList(ci2, ci1));	
	    
	    //Categorias
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	    cat2.getProdutos().addAll(Arrays.asList(p2));
	    
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));

		Cliente cli1 = new Cliente(null,"Douglas1","douglasjuv@hotmail","1", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null,"Douglas2","douglasjuv@hotmail","2", TipoCliente.PESSOAJURIDICA);

		cli1.getTelefones().addAll(Arrays.asList("1234","12345"));
		cli1.getTelefones().addAll(Arrays.asList("1234","12345"));
		
		Endereco end1 = new Endereco(null, "Rua1", "1", "Complemento1", "Bairro1", "88813250", cli1, ci1);
		Endereco end2 = new Endereco(null, "Rua2", "2", "Complemento2", "Bairro2", "88813250", cli1, ci2);

		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		cli2.getEnderecos().addAll(Arrays.asList(end2));
       
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1,  end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1,  end2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepository.saveAll(Arrays.asList(ci1, ci2));
        
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	//	itempedidoRepository.saveAll(Arrays.asList(ip1, ip2),ip3);
		
		}
}
