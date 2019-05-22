package com.example.retrofit1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private MyAPIService myAPIService;

    private RetrofitManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.airtable.com/v0/appPgLBEOqAYHOMnX/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPIService = retrofit.create(MyAPIService.class);
    }

    public static RetrofitManager getInstance(){
        return Holder.getInstance;
    }

    public MyAPIService getAPI(){
        return myAPIService;
    }

    private static class Holder{
        public static final RetrofitManager getInstance = new RetrofitManager();
    }
}
