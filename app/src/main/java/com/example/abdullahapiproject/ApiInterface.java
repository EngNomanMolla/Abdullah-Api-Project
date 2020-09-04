package com.example.abdullahapiproject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("feeds/flowers.json")
    Call<ModelClass> getData();
}
