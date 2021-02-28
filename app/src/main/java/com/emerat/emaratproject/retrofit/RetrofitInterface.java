package com.emerat.emaratproject.retrofit;

import com.emerat.emaratproject.model.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("user")
    Observable<Boolean> postUser(@Body User user);
}
