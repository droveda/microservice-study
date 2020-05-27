package br.com.diegues.microservice.loja.controller;

import br.com.diegues.microservice.loja.controller.dto.OrderDto;
import br.com.diegues.microservice.loja.model.Compra;
import br.com.diegues.microservice.loja.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Compra doOrder(@RequestBody OrderDto order) {
        return orderService.doOrder(order);
    }

}
