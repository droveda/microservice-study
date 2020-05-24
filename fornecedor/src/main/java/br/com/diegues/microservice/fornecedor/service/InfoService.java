package br.com.diegues.microservice.fornecedor.service;

import br.com.diegues.microservice.fornecedor.model.InfoSupplier;
import br.com.diegues.microservice.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoSupplier getInfoByState(String state) {
        return infoRepository.findByState(state);
    }

}
