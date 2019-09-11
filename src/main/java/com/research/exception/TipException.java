package com.research.exception;

public class TipException extends RuntimeException {
    public TipException(){
        super("非法访问");
    }
    public TipException(String mes){super(mes);}
    public TipException(String mes,Throwable reason){super(mes,reason);}
    public TipException(Throwable reason){super(reason);}
}
