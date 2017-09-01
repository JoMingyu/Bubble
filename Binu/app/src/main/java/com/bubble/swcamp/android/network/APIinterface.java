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
    Call<Void> doSignIn(@Field("sns") boolean sns,
                        @Field("id") String id,
                        @Field("pw") String pw);

    @FormUrlEncoded
    @POST("/find_id/demand")
    Call<Void> doFindIdDemand(@Field("email") String email);

    @FormUrlEncoded
    @POST("/find_id_verify")
    Call<Void> doFindIdVerify(@Field("email") String email,
                              @Field("code") String code);

    @FormUrlEncoded
    @POST("/find_pw/demand")
    Call<Void> doFindPwDemand(@Field("email") String email,
                              @Field("id") String id);

    @FormUrlEncoded
    @POST("/find_pw/verify")
    Call<Void> doFindPwVerify(@Field("email") String email,
                              @Field("code") String code);

    @FormUrlEncoded
    @POST("/change_password")
    Call<Void> doChangePassword(@Field("email") String email,
                                @Field("pw") String pw);

    @FormUrlEncoded
    @POST("/mypage")
    Call<JsonObject> getMyPage(@Field("email") String email);

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
