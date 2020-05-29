package br.com.diegues.microservice.loja.controller;

import br.com.diegues.microservice.loja.controller.dto.OrderDto;
import br.com.diegues.microservice.loja.model.Compra;
import br.com.diegues.microservice.loja.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return orderService.doOrder(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Compra getById(@PathVariable("id") Long id) {
        return orderService.getById(id);
    }

}
