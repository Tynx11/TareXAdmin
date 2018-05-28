package com.valdo.tarex.tarexadmin.model.restaurant;

import com.google.gson.annotations.SerializedName;
import com.valdo.tarex.tarexadmin.model.restaurant.tokenDto.TokenDto;

public class RestaurantResponse  {

    @SerializedName("restaurant")
    private Restaurant restaurant;

    @SerializedName("tokenDto")
    private TokenDto tokenDto;

    public TokenDto getTokenDto() {
        return tokenDto;
    }

    public void setTokenDto(TokenDto tokenDto) {
        this.tokenDto = tokenDto;
    }

    public  Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
