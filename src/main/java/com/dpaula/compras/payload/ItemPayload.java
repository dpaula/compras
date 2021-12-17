package com.dpaula.compras.payload;

import com.dpaula.compras.entity.Item;
import com.dpaula.compras.enuns.EnTipoDepartamento;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_WRITE;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemPayload implements Serializable {

    private static final long serialVersionUID = 8926274467059821529L;
    @Schema(accessMode = READ_WRITE, example = "6a0f69fc-63c3-48e9-9f0a-efde73604d69", description = "Id do Item")
    private String id;

    @Schema(accessMode = READ_WRITE, example = "Carregador USB", description = "Descrição do Item")
    @NotEmpty
    @Size(max = 200)
    private String descricao;

    @Schema(accessMode = READ_WRITE, example = "500.0", description = "Valor do Item")
    @NotNull
    private BigDecimal valor;

    @Schema(accessMode = READ_WRITE, example = "GERAIS", description = "Tipo de Departamento")
    @NotNull
    private EnTipoDepartamento departamento;

    public static ItemPayload parse(final Item item) {
        return ItemPayload.builder()
            .id(item.getId())
            .descricao(item.getDescricao())
            .valor(item.getValor())
            .departamento(item.getDepartamento())
            .build();
    }
}
