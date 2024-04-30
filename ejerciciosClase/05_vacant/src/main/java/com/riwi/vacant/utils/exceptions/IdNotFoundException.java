package com.riwi.vacant.utils.exceptions;
/*
* RunTimeException es la clase general de errores de JAVA
* se utiliza para su constructor y genera errores
* */
public class IdNotFoundException extends RuntimeException{
    private static final String ERROR_MESSAGE =" there are no records in the entity %s with the supplied id";

    public IdNotFoundException(String nameEntity){
        super(String.format(ERROR_MESSAGE,nameEntity));
    }
}
