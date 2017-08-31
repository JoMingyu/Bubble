package com.bubble.swcamp.android.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by geni on 2017. 8. 31..
 */

public interface APIinterface {
    @FormUrlEncoded
    @POST("/signup")
    Call<Void> doSignUp();

    @FormUrlEncoded
    @POST("/signin")
    Call<Void> doSignIn();

    @FormUrlEncoded
    @POST("/market")
    Call<Void>  doMarketUpload();

    @FormUrlEncoded
    @GET("/market")
    Call<JsonObject>  getMarket();

    @FormUrlEncoded
    @POST("/market/download")
    Call<Void> doMarketDownload();

    @FormUrlEncoded
    @GET("/preset/own")
    Call<JsonObject> getOwnPreset();

    @FormUrlEncoded
    @POST("/preset/uploaded")
    Call<JsonObject> getUploadedPreset();

    @FormUrlEncoded
    @GET("/preset/detail")
    Call<JsonObject> getPresetDetail();

    @FormUrlEncoded
    @GET("/mypage")
    Call<Void> getMyPage();
}
