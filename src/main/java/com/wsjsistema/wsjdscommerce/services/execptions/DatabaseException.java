package com.wsjsistema.wsjdscommerce.services.execptions;

public class DatabaseException extends  RuntimeException {

    public DatabaseException(String msg){
        super(msg);
    }
}