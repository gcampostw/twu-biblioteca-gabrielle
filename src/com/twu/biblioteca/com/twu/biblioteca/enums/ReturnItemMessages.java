package com.twu.biblioteca.com.twu.biblioteca.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gcampos on 09/03/17.
 */
public enum ReturnItemMessages {
    ITEM_NOT_VALID("That is not a valid item to return"),
    ITEM_RETURNED("Thank you for returning the item");
    private final String message;

    ReturnItemMessages(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}



