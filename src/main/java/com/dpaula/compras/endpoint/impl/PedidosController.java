package com.dpaula.compras.endpoint.impl;

import com.dpaula.compras.endpoint.IPedidosController;
import com.dpaula.compras.entity.Pedido;
import com.dpaula.compras.error.PedidoNotFoundException;
import com.dpaula.compras.payload.PedidoPayload;
import com.dpaula.compras.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PedidosController implements IPedidosController {

    private final PedidoService service;

    @Override
    public Mono<PedidoPayload> post(final PedidoPayload pedido) {
        final Mono<Pedido> compra = service.comprar(Pedido.parse(pedido));
        return compra.switchIfEmpty(Mono.error(new PedidoNotFoundException("Pedido não encontrado!")))
            .map(PedidoPayload::parse);
    }

    @Override
    public Flux<PedidoPayload> listAll() {
        final Flux<Pedido> pedidos = service.listAll();
        return pedidos
            .map(PedidoPayload::parse);
    }
}
