package com.payzaty;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Payzaty {

    private String merchantNo;
    private String secretKey;
    private String language;
    private boolean sandbox;

    private final static Object LOCK = new Object();
    private static Payzaty instance;

    private CheckoutHandler handler;

    public static Payzaty init(final String merchantNo, final String secretKey, final String language, final boolean sandbox) {
        if (merchantNo == null) {
            throw new NullPointerException("MerchantNo Cant Be Null");
        }
        if (secretKey == null) {
            throw new NullPointerException("MerchantNo Cant Be Null");
        }

        synchronized (LOCK) {
            if (instance == null) {
                instance = new Payzaty(merchantNo, secretKey, language, sandbox);
            } else {
                instance.merchantNo = merchantNo;
                instance.secretKey = secretKey;
                instance.language = language;
                instance.sandbox = sandbox;
            }
            return instance;
        }
    }


    private Payzaty(final String merchantNo, final String secretKey, final String language, final boolean sandbox) {
        this.merchantNo = merchantNo;
        this.secretKey = secretKey;
        this.language = language;
        this.sandbox = sandbox;
    }


    public void checkout(CheckoutRequest request, CheckoutHandler handler) {
        this.handler = handler;
        SdkRetrofit.getInstance(sandbox)
                .getSdkService()
                .checkout(
                        merchantNo,
                        secretKey,
                        language,
                        request.getName(),
                        request.getEmail(),
                        request.getPhoneCode(),
                        request.getPhoneNumber(),
                        request.getAmount() + "",
                        request.getCurrencyID(),
                        request.getResponseUrl(),
                        request.getUdf1(),
                        request.getUdf2(),
                        request.getUdf3()

                )
                .enqueue(new Callback<CheckoutResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<CheckoutResponse> call, @NotNull Response<CheckoutResponse> response) {
                        if (response.isSuccessful()) {

                            if (response.body() != null) {
                                handler.onSuccess(response.body());
                            } else {
                                try {
                                    handler.onFailure(new PayzatyException("CheckoutUrl == null, Please Call Support " + response.errorBody().string()));
                                } catch (Exception e) {
                                    handler.onFailure(new PayzatyException("CheckoutUrl == null, Please Call Support " + e.getLocalizedMessage(), e.getCause()));

                                }
                            }
                        } else {

                            String errorBody = "Some Error";
                            try {
                                errorBody = response.errorBody() == null ? " Some Error  " : response.errorBody().string();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            handler.onFailure(new PayzatyException(errorBody));
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<CheckoutResponse> call, @NotNull Throwable t) {
                        handler.onFailure(new PayzatyException(t.getLocalizedMessage(), t));
                    }
                });
    }


    public void getStatus(String checkoutId, PaymentStatusHandler handler) {
        if (handler == null) {
            return;
        }
        if (checkoutId == null || checkoutId.isEmpty()) {
            handler.onFailure(new PayzatyException("Checkout Id Can't be Null"));
            return;
        }

        SdkRetrofit.getInstance(sandbox)
                .getSdkService()
                .status(
                        merchantNo,
                        secretKey,
                        language,
                        checkoutId
                )

                .enqueue(new Callback<StatusResponse>() {
                    @Override
                    public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                        if (response.isSuccessful()) {
                            handler.onStatus(response.body());
                        } else {
                            try {
                                handler.onFailure(new PayzatyException(response.errorBody().string()));
                            } catch (IOException e) {
                                handler.onFailure(new PayzatyException(e.getLocalizedMessage(), e.getCause()));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<StatusResponse> call, Throwable t) {
                        handler.onFailure(new PayzatyException(t.getLocalizedMessage(), t.getCause()));

                    }
                });

    }
}
