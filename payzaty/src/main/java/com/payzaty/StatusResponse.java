package com.payzaty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class StatusResponse {

    @SerializedName("success")
    @Expose
    public boolean success;


    @SerializedName("paid")
    @Expose
    public boolean paid;


    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("udf1")
    @Expose
    public String udf1;

    @SerializedName("udf2")
    @Expose
    public String udf2;

    @SerializedName("udf3")
    @Expose
    public String udf3;


    @SerializedName("error")
    @Expose
    public String error;

    @SerializedName("errorText")
    @Expose
    public String errorText;


    public StatusResponse() {

    }


    @Override
    public String toString() {
        return "CheckoutResponse{" +
                "success=" + success +
                ", paid=" + paid +
                ", status='" + status + '\'' +
                ", udf1='" + udf1 + '\'' +
                ", udf2='" + udf2 + '\'' +
                ", udf3='" + udf3 + '\'' +
                ", error='" + error + '\'' +
                ", errorText='" + errorText + '\'' +
                '}';
    }
}
