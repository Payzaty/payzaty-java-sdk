package com.payzaty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CheckoutResponse {


    @SerializedName("success")
    @Expose
    public boolean success;


    @SerializedName("checkoutId")
    @Expose
    public String checkoutId;


    @SerializedName("checkoutUrl")
    @Expose
    public String checkoutUrl;


    @SerializedName("error")
    @Expose
    public String error;

    @SerializedName("errorText")
    @Expose
    public String errorText;


    public CheckoutResponse() {
    }


    @Override
    public String toString() {
        return "CheckoutResponse{" +
                "success=" + success +
                ", checkoutId='" + checkoutId + '\'' +
                ", checkoutUrl='" + checkoutUrl + '\'' +
                ", error='" + error + '\'' +
                ", errorText='" + errorText + '\'' +
                '}';
    }
}
