package br.com.diegues.microservice.fornecedor.repository;

import br.com.diegues.microservice.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
