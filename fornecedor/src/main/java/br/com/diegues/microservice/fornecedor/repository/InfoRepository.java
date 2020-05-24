package br.com.diegues.microservice.fornecedor.repository;

import br.com.diegues.microservice.fornecedor.model.InfoSupplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<InfoSupplier, Long> {

    InfoSupplier findByState(String state);

}
