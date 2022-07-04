package com.example.kuranikerimm;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("audio_files")
    Call<List<Veriler>> getJson();
    @GET("audio_files")
    Call<Veriler> getJson1();
    @GET("qaris")
    Call<List<Okuyanlar>> getJson2();

}
