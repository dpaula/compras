package com.dpaula.compras.payload;

import com.dpaula.compras.entity.Pedido;
import com.dpaula.compras.enuns.EnTipoPagamento;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;
import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_WRITE;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PedidoPayload implements Serializable {

    private static final long serialVersionUID = 8926274467059821529L;
    @Schema(accessMode = READ_WRITE, example = "6a0f69fc-63c3-48e9-9f0a-efde73604d69", description = "Id do Cliente")
    private String id;

    @Schema(accessMode = READ_WRITE, example = "Fernando de Lima", description = "Nome Completo do Cliente")
    @NotEmpty
    @Size(max = 200)
    private String nomeCliente;

    @Schema(accessMode = READ_WRITE, example = "fernando.dpaula@gmail.com", description = "E-mail do Cliente")
    @NotEmpty
    @Size(max = 100)
    @Email(message = "Deve ser endereço de email válido!")
    private String email;

    @Schema(accessMode = READ_ONLY, example = "2021-06-21T02:00:00", description = "Data e Hora do Pagamento do Cliente")
    private LocalDateTime dataPedido;

    @Schema(accessMode = READ_WRITE, example = "CARTAO", description = "Tipo de Pagamento")
    @NotNull
    private EnTipoPagamento tipo;

    @Schema(accessMode = READ_WRITE, description = "Item do Pedido")
    @NotNull
    private ItemPayload item;


    public static PedidoPayload parse(final Pedido pedido) {
        return PedidoPayload.builder()
            .id(pedido.getId())
            .nomeCliente(pedido.getNomeCliente())
            .email(pedido.getEmail())
            .dataPedido(pedido.getDataPagamento())
            .tipo(pedido.getTipo())
            .item(ItemPayload.parse(pedido.getItem()))
            .build();
    }
}
