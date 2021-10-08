package com.payzaty;

public interface CheckoutHandler {

    void onSuccess(CheckoutResponse response);

    void onFailure(PayzatyException e);

}
