package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

// com esta anotação esta classe podera ser injetada com outro lugar
@Service
public class ProductService {
	 
	/* injecao de dependencia para esta classe acessar
	 * os metodos de banco de dados
	 * repository eh um objeto que acessa o banco
	 */
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		// buscar no banco todos produtos
		List<Product> list = repository.findAllByOrderByNameAsc();
		// converter de Product para ProductDTO usando lambda
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

}
