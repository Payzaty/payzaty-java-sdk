package com.payzaty;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


class SdkRetrofit {

    private static final Object LOCK = new Object();


    private Retrofit retrofit;
    private SdkService sdkService;

    private SdkRetrofit() {

    }


    public static SdkRetrofit getInstance(boolean sandbox) {
        synchronized (LOCK) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(10000, TimeUnit.SECONDS)
                    .writeTimeout(10000, TimeUnit.SECONDS)
                    .readTimeout(10000, TimeUnit.SECONDS)
                    .build();

            SdkRetrofit instance = new SdkRetrofit();
            instance.retrofit = new Retrofit.Builder()
                    .baseUrl(sandbox ? "https://sandbox.payzaty.com/" : "https://www.payzaty.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return instance;
        }
    }


    public SdkService getSdkService() {
        synchronized (LOCK) {
            if (sdkService == null) {
                sdkService = retrofit.create(SdkService.class);
            }
            return sdkService;
        }
    }

}
