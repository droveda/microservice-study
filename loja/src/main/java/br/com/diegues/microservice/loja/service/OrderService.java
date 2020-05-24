package br.com.diegues.microservice.loja.service;

import br.com.diegues.microservice.loja.controller.dto.InfoProviderDto;
import br.com.diegues.microservice.loja.controller.dto.OrderDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OrderService {

    public void doOrder(OrderDto order) {
        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoProviderDto> exchange = client.exchange("http://localhost:8081/info/" + order.getAddress().getState(),
                HttpMethod.GET, null, InfoProviderDto.class);
        System.out.println(exchange.getBody().getAddress());
    }

}
