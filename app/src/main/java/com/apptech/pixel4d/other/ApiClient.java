package com.apptech.pixel4d.other;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://apptechinteractive.com/parallex/index.php/app/";
    public static final String IMAGE_BASE_URL = "http://apptechinteractive.com/parallex/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (retrofit == null) {
            OkHttpClient OClient = new OkHttpClient.Builder()
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(OClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))

                    .build();
        }
        return retrofit;
    }
}
