package br.com.diegues.microservice.fornecedor.service;

import java.util.List;

import br.com.diegues.microservice.fornecedor.model.Produto;
import br.com.diegues.microservice.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(String estado) {
		return produtoRepository.findByEstado(estado);
	}

	
}
