package com.emerat.emaratproject.retrofit;

import com.emerat.emaratproject.model.Country;
import com.emerat.emaratproject.model.PostResponse;
import com.emerat.emaratproject.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("user")
    Observable<PostResponse> postUser(@Body User user);

    @GET("country")
    Observable<List<Country>> getCountryList();

    Observable<List<>>
}
