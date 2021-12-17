package com.dpaula.compras.client;

import com.dpaula.compras.payload.ItemPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Fernando de Lima on 14/12/21
 */
@FeignClient(name = "estoque-api", url = "${estoque.url}")
public interface EstoqueClient {

    @PostMapping(value = "/v1/itens/retirar",
        produces = MediaType.APPLICATION_JSON_VALUE)
    ItemPayload retirarItem(@RequestParam(value = "idItem") String idItem);
}
