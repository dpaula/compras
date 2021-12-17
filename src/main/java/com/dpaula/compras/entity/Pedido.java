package com.dpaula.compras.entity;

import com.dpaula.compras.enuns.EnTipoPagamento;
import com.dpaula.compras.payload.PedidoPayload;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pedidos")
public class Pedido {

    @Id
    private String id;
    private String nomeCliente;
    private String email;
    private LocalDateTime dataPagamento;
    private EnTipoPagamento tipo;

    private Item item;

    public static Pedido parse(final PedidoPayload pedido) {
        return Pedido.builder()
            .id(pedido.getId())
            .nomeCliente(pedido.getNomeCliente())
            .email(pedido.getEmail())
            .dataPagamento(pedido.getDataPedido())
            .tipo(pedido.getTipo())
            .item(Item.parse(pedido.getItem()))
            .build();
    }
}
