package com.bubble.swcamp.android.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.io.File;
import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    Call<Void> doSignInAsSns(@Field("sns") boolean sns,
                             @Field("email") String email,
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
    
    @POST("/preset/image")
    Call<Void> doPresetImage(@Field("preset_id") int presetId,
                             @Field("image") File image);
    
    @GET("/preset/image")
    Call<JsonObject> getPresetImage(@Query("preset_id") int presetId);

    @FormUrlEncoded
    @POST("/market")
    Call<Void> doMarketUpload();

    @GET("/market")
    Call<JsonObject> getMarket();
    
    @FormUrlEncoded
    @POST("/market")
    Call<Void> postMarket(@Field("preset_id") int presetId,
                          @Field("is_free") boolean isFree);

    @FormUrlEncoded
    @DELETE("/market")
    Call<Void> deleteMarket(@Field("preset_id") int presetId);

    @GET("/market/download")
    Call<JsonObject> doMarketDownload(@Query("email") String email,
                                      @Query("preset_id") int presetId);

    @GET("/market/like")
    Call<JsonObject> getMarketLike(@Query("preset_id") int presetId);

    @GET("/preset")
    Call<List<JsonObject>> getOwnPreset(@Query("email") String email);

    @FormUrlEncoded
    @POST("/preset")
    Call<JsonObject> doUploadPreset(@Field("email") String email,
                                    @Field("title") String title,
                                    @Field("hash_tags") JSONArray hash_tags,
                                    @Field("exposure") double exposure,
                                    @Field("contrast") int contrast,
                                    @Field("highlight") int highlight,
                                    @Field("blackpoint") int blackpoint,
                                    @Field("white") int white,
                                    @Field("black") int black,
                                    @Field("temperature") int temporature,
                                    @Field("tone") int tone,
                                    @Field("chroma") int chroma);
    
    @FormUrlEncoded
    @DELETE("/preset")
    Call<Void> deletePreset(@Field("preset_id") int presetId);

    @GET("/preset/detail")
    Call<JsonObject> getPresetDetail(@Query("preset_id") int presetId);

    @GET("/preset/uploaded")
    Call<JsonObject> getUploadedPreset(@Query("email") String email);

    @GET("/profile_image")
    Call<JsonObject> getProfileImage(@Query("email") String email);

    @POST("/profile_image")
    Call<Void> postProfileImage(@Field("image") File image);
}