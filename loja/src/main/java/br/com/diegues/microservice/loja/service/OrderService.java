package br.com.diegues.microservice.loja.service;

import br.com.diegues.microservice.loja.client.FornecedorClient;
import br.com.diegues.microservice.loja.client.TransportadorClient;
import br.com.diegues.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.diegues.microservice.loja.controller.dto.InfoSupplierDto;
import br.com.diegues.microservice.loja.controller.dto.OrderDto;
import br.com.diegues.microservice.loja.dto.InfoEntregaDto;
import br.com.diegues.microservice.loja.dto.VoucherDto;
import br.com.diegues.microservice.loja.model.Compra;
import br.com.diegues.microservice.loja.model.CompraStatus;
import br.com.diegues.microservice.loja.repository.OrderRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TransportadorClient transportadorClient;

    @HystrixCommand(fallbackMethod = "doOrderFallback", threadPoolKey = "doOrderThreadPool")
    public Compra doOrder(OrderDto order) {
        String state = order.getAddress().getState();

        Compra compra = new Compra();
        compra.setCompraStatus(CompraStatus.RECEBIDO);
        compra.setEnderecoDestino(order.getAddress().toString());
        orderRepository.save(compra);
        order.setCrompraId(compra.getId());

        LOGGER.info("buscando informacoes do fornecedor de {}", state);
        InfoSupplierDto info = fornecedorClient.getInfoByState(state);

        LOGGER.info("realizando um pedido");
        InfoPedidoDto pedido = fornecedorClient.realizaPedido(order.getItems());
        compra.setCompraStatus(CompraStatus.PEDIDO_REALIZADO);

        compra.setPedidoId(pedido.getId());
        compra.setTempoDePreparo(pedido.getTempoDePreparo());
        orderRepository.save(compra);

        InfoEntregaDto entregaDto = new InfoEntregaDto();
        entregaDto.setPedidoId(pedido.getId());
        entregaDto.setDataParaEntrega(LocalDate.now().plusDays(pedido.getTempoDePreparo()));
        entregaDto.setEnderecoOrigem(info.getAddress());
        entregaDto.setEnderecoDestino(order.getAddress().toString());

        LOGGER.info("realizando chamada ao transportador para gerar voucher...");
        VoucherDto voucher = transportadorClient.reservaEntrega(entregaDto);

        compra.setCompraStatus(CompraStatus.RESERVA_ENTREGA_REALIZADA);
        compra.setDataParaEntrega(voucher.getPrevisaoParaEntrega());
        compra.setVoucher(voucher.getNumero());
        orderRepository.save(compra);

        return compra;
    }

    @HystrixCommand(threadPoolKey = "getByIdThreadPool")
    public Compra getById(Long id) {
        return orderRepository.findById(id).orElse(new Compra());
    }

    public Compra doOrderFallback(OrderDto order) {

        if (order.getCrompraId() != null) {
            return orderRepository.findById(order.getCrompraId()).get();
        }

        Compra compraFallback = new Compra();
        compraFallback.setEnderecoDestino(order.getAddress().toString());

        return compraFallback;
    }
}
