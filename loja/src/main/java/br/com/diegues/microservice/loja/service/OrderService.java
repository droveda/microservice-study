package br.com.diegues.microservice.loja.service;

import br.com.diegues.microservice.loja.controller.dto.InfoSupplierDto;
import br.com.diegues.microservice.loja.controller.dto.OrderDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    public void doOrder(OrderDto order) {
        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoSupplierDto> exchange = client.exchange("http://fornecedor/info/" + order.getAddress().getState(),
                HttpMethod.GET, null, InfoSupplierDto.class);
        System.out.println(exchange.getBody().getAddress());
    }

}
