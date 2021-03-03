package com.emerat.emaratproject.retrofit;

import com.emerat.emaratproject.model.City;
import com.emerat.emaratproject.model.Country;
import com.emerat.emaratproject.model.PostResponse;
import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.model.data.ResponseProduct;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RetrofitInterface {
    @POST("user")
    Observable<PostResponse> postUser(@Body User user);

    @PUT("user")
    Call<PostResponse> editUser(@Header("Authorization") String token,@Body User user);

    @GET("country")
    Observable<List<Country>> getCountryList();

    @GET("citys/{countryCode}")
    Observable<List<City>> getCityList(@Path("countryCode") String countryCode);

    @GET("auth/user")
    Call<PostResponse> loginUser(@Header("Authorization") String token);

    @GET("product/search/getByquerys")
    Observable<ResponseProduct> getDataItem(@QueryMap Map<String,String> queryMap);

    @GET("product/all")
    Observable<ResponseProduct> getAllProduct();
}
