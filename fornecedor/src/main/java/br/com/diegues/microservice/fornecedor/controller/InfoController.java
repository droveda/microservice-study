package br.com.diegues.microservice.fornecedor.controller;

import br.com.diegues.microservice.fornecedor.model.InfoSupplier;
import br.com.diegues.microservice.fornecedor.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private InfoService infoService;

    @RequestMapping("/{state}")
    public InfoSupplier getInfoByState(@PathVariable("state") String state) {
        LOGGER.info("recebido pedido de informacoes do fornecedor de {}", state);
        InfoSupplier info = infoService.getInfoByState(state);
        return info;
    }

}
