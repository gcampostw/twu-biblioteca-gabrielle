package com.twu.biblioteca.com.twu.biblioteca.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gcampos on 09/03/17.
 */
public enum CheckoutItemMessages {
    NOT_AVAILABLE("That item is not available"),
    ENJOY_ITEM("Thank you! Enjoy the item");
    private final String message;

    CheckoutItemMessages(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}



