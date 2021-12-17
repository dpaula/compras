package com.dpaula.compras.error;

/**
 * @author Fernando de Lima on 13/12/21
 */
public class PedidoNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -836670065912314363L;

    public PedidoNotFoundException() {
    }

    public PedidoNotFoundException(final String message) {
        super(message);
    }
}
