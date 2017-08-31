package com.bubble.swcamp.android.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by geni on 2017. 8. 31..
 */

public interface APIinterface {
    @FormUrlEncoded
    @POST("/signup")
    Call<Void> doSignUp(@Field("id") String id,
                        @Field("email") String email,
                        @Field("pw") String pw,
                        @Field("nickname") String nickname,
                        @Field("gender") String gender);

    @FormUrlEncoded
    @POST("/signin")
    Call<Void> doSignIn(@Field("id") String id,
                        @Field("pw") String pw);

    @FormUrlEncoded
    @POST("/market")
    Call<Void> doMarketUpload();

    @FormUrlEncoded
    @GET("/market")
    Call<JsonObject> getMarket();

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
    Call<Void> getPresetDetail();

    @FormUrlEncoded
    @GET("/mypage")
    Call<Void> getMyPage();
}
