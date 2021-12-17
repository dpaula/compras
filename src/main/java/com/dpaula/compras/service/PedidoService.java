package com.dpaula.compras.service;

import com.dpaula.compras.client.EstoqueClient;
import com.dpaula.compras.entity.Pedido;
import com.dpaula.compras.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoService {

    public static final ZoneId ZONA_ID = ZoneId.of("America/Sao_Paulo");

    private final StreamBridge streamBridge;

    private final PedidoRepository repository;
    private final EstoqueClient estoqueClient;

    public Mono<Pedido> comprar(final Pedido pagamento) {
        log.info("Efetuando nova compra, cliente : {}", pagamento.getNomeCliente());
        pagamento.setDataPagamento(LocalDateTime.now(ZONA_ID));

        log.info("Enviando mensagem : {}", pagamento);

        streamBridge.send("supply-out-0", pagamento);

        estoqueClient.retirarItem(pagamento.getItem().getId());

        log.info("Mensagem enviada!!");

        return repository.save(pagamento);
    }

    public Flux<Pedido> listAll() {
        log.info("Buscando todos os pedidos");

        return repository.findAll();

    }
}
