package com.valdo.tarex.tarexadmin.api;

import com.valdo.tarex.tarexadmin.model.form.LoginForm;
import com.valdo.tarex.tarexadmin.model.restaurant.RestaurantResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("login_restaurant")
    Observable<RestaurantResponse> user (@Body LoginForm loginForm);
}
