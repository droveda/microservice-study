package br.com.diegues.microservice.loja.client;

import br.com.diegues.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.diegues.microservice.loja.controller.dto.InfoSupplierDto;
import br.com.diegues.microservice.loja.controller.dto.OrderItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{state}")
    InfoSupplierDto getInfoByState(@PathVariable String state);

    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    InfoPedidoDto realizaPedido(List<OrderItemDto> items);
}
