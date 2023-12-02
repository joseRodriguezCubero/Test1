package org.joseRodriguez;

import java.io.Serial;

public class ToMuchForTheSellerException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public ToMuchForTheSellerException() {
    }

    public ToMuchForTheSellerException(String ms_error) {
        super(ms_error);
    }

}

