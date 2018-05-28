package com.valdo.tarex.tarexadmin.api;

import com.valdo.tarex.tarexadmin.model.form.LoginForm;
import com.valdo.tarex.tarexadmin.model.requests.RequestResponse;
import com.valdo.tarex.tarexadmin.model.restaurant.RestaurantResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RequestService {

    @GET("reservation/restaurant/{reservationId}")
    Observable<RequestResponse> allRequests (@Path("reservationId") Long id);

    @GET("reservation/restaurant/active/{reservationId}")
    Observable<RequestResponse> activeRequests (@Path("reservationId") Long id);



}
