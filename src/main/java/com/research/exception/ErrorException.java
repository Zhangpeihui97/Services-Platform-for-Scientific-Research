package com.research.exception;

public class ErrorException extends RuntimeException{
    public ErrorException(){
        super("错误");
    }
    public ErrorException(String mes){super(mes);}
    public ErrorException(String mes,Throwable reason){super(mes,reason);}
    public ErrorException(Throwable reason){super(reason);}
}
