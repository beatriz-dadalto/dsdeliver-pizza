package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

// com esta anotação esta classe podera ser injetada com outro lugar
@Service
public class OrderService {
	 
	/** injecao de dependencia para esta classe acessar
	 * os metodos de banco de dados
	 * @repository eh um objeto que acessa o banco
	 */
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		// buscar no banco todos produtos
		List<Order> list = repository.findOrderWithProducts();
		// converter de Product para ProductDTO usando lambda
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

}
