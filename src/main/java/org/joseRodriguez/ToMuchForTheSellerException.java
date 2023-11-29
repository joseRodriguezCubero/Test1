package org.joseRodriguez;

public class ToMuchForTheSellerException extends Exception {
    private static final long serialVersionUID = 1L;

    public ToMuchForTheSellerException() {
    }

    public ToMuchForTheSellerException(String ms_error) {
        super(ms_error);
    }

}

