package io.novelis.demo.exception;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String nomObjet){
        super(nomObjet + " not found");
    }
}
