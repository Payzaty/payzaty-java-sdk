package com.payzaty;

public class PayzatyException extends Exception {

    public PayzatyException(String msg, Throwable throwable) {
        super(msg, throwable);
    }


    public PayzatyException(String msg) {
        super(msg);
    }

    public PayzatyException(String msg, Exception e) {
        super(msg, e);
    }


}
