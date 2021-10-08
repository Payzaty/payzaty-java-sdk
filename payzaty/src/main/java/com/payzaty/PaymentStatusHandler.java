package com.payzaty;

public interface PaymentStatusHandler {

    void onStatus(StatusResponse response);
    void onFailure(PayzatyException e);

}
