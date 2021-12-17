package com.dpaula.compras.entity;

import com.dpaula.compras.enuns.EnTipoDepartamento;
import com.dpaula.compras.payload.ItemPayload;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "itens")
public class Item {

//    @Id
    private String id;
    private String descricao;
    private BigDecimal valor;
    private EnTipoDepartamento departamento;

    public static Item parse(final ItemPayload item) {
        return Item.builder()
            .id(item.getId())
            .descricao(item.getDescricao())
            .valor(item.getValor())
            .departamento(item.getDepartamento())
            .build();
    }
}
