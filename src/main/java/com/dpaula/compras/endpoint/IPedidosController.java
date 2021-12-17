package com.dpaula.compras.endpoint;

import com.dpaula.compras.payload.PedidoPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/pedidos")
@CrossOrigin(origins = "*")
@Tag(name = "Pedidos", description = "Serviços para gerenciar pedidos")
public interface IPedidosController {

    @Operation(summary = "Efetuar Compra", description = "Post para realizar uma compra")
    @PostMapping("comprar")
    Mono<PedidoPayload> post(@NotNull @Valid @RequestBody final PedidoPayload pedido);

    @Operation(summary = "Listar Pedidos", description = "Listar todos os Pedidos")
    @GetMapping()
    Flux<PedidoPayload> listAll();
}
