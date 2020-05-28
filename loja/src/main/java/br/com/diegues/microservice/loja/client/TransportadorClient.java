package br.com.diegues.microservice.loja.client;

import br.com.diegues.microservice.loja.dto.InfoEntregaDto;
import br.com.diegues.microservice.loja.dto.VoucherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("transportador")
public interface TransportadorClient {

    @RequestMapping(path = "/entrega", method = RequestMethod.POST)
    VoucherDto reservaEntrega(InfoEntregaDto entregaDto);
}
