package br.com.diegues.microservice.fornecedor.controller;

import br.com.diegues.microservice.fornecedor.dto.ItemDoPedidoDTO;
import br.com.diegues.microservice.fornecedor.model.Pedido;
import br.com.diegues.microservice.fornecedor.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("pedido")
public class PedidoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.POST)
    public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
        LOGGER.info("Pedido recebido");
        return pedidoService.realizaPedido(produtos);
    }

    @RequestMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
}
