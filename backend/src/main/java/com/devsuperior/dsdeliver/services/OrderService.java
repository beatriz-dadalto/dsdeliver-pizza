package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

// com esta anotação esta classe podera ser injetada com outro lugar
@Service
public class OrderService {
	 
	/** injecao de dependencia para esta classe acessar
	 * os metodos de banco de dados
	 * @repository eh um objeto que acessa o banco
	 */
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		// buscar no banco todos produtos
		List<Order> list = repository.findOrderWithProducts();
		// converter de Product para ProductDTO usando lambda
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		// como pegar o obj dto enviado pelo user e salvo no banco?
		// para salvar no banco eu preciso instanciar um Order a partir de um DTO
		Order order = new Order(
					null,
					dto.getAddress(),
					dto.getLatitude(),
					dto.getLongitude(),
					Instant.now(), // o momento do pedido é criado pelo sistema
					OrderStatus.PENDING
				);
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		// como faço para alterar um registro?
		// primeiro darei um getOne() para instanciar um obj monitorado pelo JPA
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDTO(order);
	}

}
