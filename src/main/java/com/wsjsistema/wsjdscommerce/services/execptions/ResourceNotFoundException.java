package com.wsjsistema.wsjdscommerce.services.execptions;

public class ResourceNotFoundException extends  RuntimeException {

    public  ResourceNotFoundException(String msg){
        super(msg);
    }
}