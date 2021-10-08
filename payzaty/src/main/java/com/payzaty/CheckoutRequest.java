package com.payzaty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckoutRequest {


    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("Email")
    private String email;

    @Expose
    @SerializedName("PhoneCode")
    private String phoneCode;

    @Expose
    @SerializedName("PhoneNumber")
    private String phoneNumber;

    @Expose
    @SerializedName("Amount")
    private Double amount;

    @Expose
    @SerializedName("CurrencyID")
    private String currencyID;

    @Expose
    @SerializedName("UDF1")
    private String udf1;


    @Expose
    @SerializedName("UDF2")
    private String udf2;

    @Expose
    @SerializedName("UDF3")
    private String udf3;

    @Expose
    @SerializedName("ResponseUrl")
    private String responseUrl;

    public CheckoutRequest(String name, String email, String phoneCode, String phoneNumber, Double amount, String currencyID, String responseUrl) {
        this.name = name;
        this.email = email;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.currencyID = currencyID;
        this.responseUrl = responseUrl;
    }

    public CheckoutRequest(String name, String email, String phoneCode, String phoneNumber, Double amount, String currencyID, String udf1, String responseUrl, String udf2, String udf3) {
        this.name = name;
        this.email = email;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.currencyID = currencyID;
        this.responseUrl = responseUrl;

        this.udf1 = udf1;
        this.udf2 = udf2;
        this.udf3 = udf3;
    }

    public CheckoutRequest(String name, String email, String phoneCode, String phoneNumber, Double amount, String currencyID, String udf1, String responseUrl, String udf2) {
        this.name = name;
        this.email = email;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.currencyID = currencyID;
        this.responseUrl = responseUrl;

        this.udf1 = udf1;
        this.udf2 = udf2;
    }

    public CheckoutRequest(String name, String email, String phoneCode, String phoneNumber, Double amount, String currencyID, String responseUrl, String udf1) {
        this.name = name;
        this.email = email;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.currencyID = currencyID;
        this.responseUrl = responseUrl;

        this.udf1 = udf1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getUdf1() {
        return udf1;
    }

    public void setUdf1(String udf1) {
        this.udf1 = udf1;
    }

    public String getUdf2() {
        return udf2;
    }

    public void setUdf2(String udf2) {
        this.udf2 = udf2;
    }

    public String getUdf3() {
        return udf3;
    }

    public void setUdf3(String udf3) {
        this.udf3 = udf3;
    }

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }
}
