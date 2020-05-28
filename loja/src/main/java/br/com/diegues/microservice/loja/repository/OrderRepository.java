package br.com.diegues.microservice.loja.repository;

import br.com.diegues.microservice.loja.model.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Compra, Long> {
}
