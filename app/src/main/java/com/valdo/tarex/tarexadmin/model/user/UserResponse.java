package com.valdo.tarex.tarexadmin.model.user;

import com.google.gson.annotations.SerializedName;
import com.valdo.tarex.tarexadmin.model.restaurant.tokenDto.TokenDto;

public class UserResponse {

    @SerializedName("tokenDto")
    TokenDto tokenDto;

    @SerializedName("user")
    User user;

    public TokenDto getTokenDto() {
        return tokenDto;
    }

    public void setTokenDto(TokenDto tokenDto) {
        this.tokenDto = tokenDto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
