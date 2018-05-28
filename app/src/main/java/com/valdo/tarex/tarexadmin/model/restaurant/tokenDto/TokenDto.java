package com.valdo.tarex.tarexadmin.model.restaurant.tokenDto;

import com.google.gson.annotations.SerializedName;

public class TokenDto {

    @SerializedName("value")
    String value;

    public TokenDto(String value) {
        this.value = value;
    }

    public TokenDto() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
