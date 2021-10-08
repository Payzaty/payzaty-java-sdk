package com.payzaty;


import com.payzaty.CheckoutResponse;
import com.payzaty.StatusResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface SdkService {


    @FormUrlEncoded
    @POST("/payment/checkout")
    @Headers(value = {"X-Source:2",
            "X-Build:1",
            "X-Version:1",
    })
    Call<CheckoutResponse> checkout(
            @Header("X-MerchantNo") String merchantNo,
            @Header("X-SecretKey") String secretKey,
            @Header("X-Language") String language,
            @Field("Name") String name,
            @Field("Email") String Email,
            @Field("PhoneCode") String PhoneCode,
            @Field("PhoneNumber") String PhoneNumber,
            @Field("Amount") String Amount,
            @Field("CurrencyID") String CurrencyID,
            @Field("ResponseUrl") String ResponseUrl,
            @Field("UDF1") String UDF1,
            @Field("UDF2") String UDF2,
            @Field("UDF3") String UDF3
    );


    @GET("/payment/status/{id}")
    @Headers(value = {"X-Source:2",
            "X-Build:1",
            "X-Version:1"
    })
    Call<StatusResponse> status(
            @Header("X-MerchantNo") String merchantNo,
            @Header("X-SecretKey") String secretKey,
            @Header("X-Language") String language,
            @Path("id") String id
    );


}
