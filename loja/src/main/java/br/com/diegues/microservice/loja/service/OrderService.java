package br.com.diegues.microservice.loja.service;

import br.com.diegues.microservice.loja.client.FornecedorClient;
import br.com.diegues.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.diegues.microservice.loja.controller.dto.InfoSupplierDto;
import br.com.diegues.microservice.loja.controller.dto.OrderDto;
import br.com.diegues.microservice.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra doOrder(OrderDto order) {
        String state = order.getAddress().getState();

        LOGGER.info("buscando informacoes do fornecedor de {}", state);
        InfoSupplierDto info = fornecedorClient.getInfoByState(state);

        LOGGER.info("realizando um pedido");
        InfoPedidoDto pedido = fornecedorClient.realizaPedido(order.getItems());

        Compra compra = new Compra();
        compra.setPedidoId(pedido.getId());
        compra.setTempoDePreparo(pedido.getTempoDePreparo());
        compra.setEnderecoDestino(order.getAddress().toString());

        return compra;
    }

}
