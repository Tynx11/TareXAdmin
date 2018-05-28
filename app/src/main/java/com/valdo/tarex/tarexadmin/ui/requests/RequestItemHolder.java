package com.valdo.tarex.tarexadmin.ui.requests;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.valdo.tarex.tarexadmin.R;
import com.valdo.tarex.tarexadmin.model.requests.Reservations;

class RequestItemHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView phoneNumber;
    private TextView dateReservation;
    private TextView descriprion;
    private TextView countPeople;

    @NonNull
    public static RequestItemHolder create(@NonNull Context context) {
        View view = View.inflate(context, R.layout.item_request, null);
        RequestItemHolder holder = new RequestItemHolder(view);
        return holder;
    }


    public RequestItemHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_name);
        phoneNumber = itemView.findViewById(R.id.tv_phone);
        dateReservation = itemView.findViewById(R.id.tv_date_reservation);
        descriprion = itemView.findViewById(R.id.tv_description);
        countPeople = itemView.findViewById(R.id.tv_count_people);
    }

    public void bind(@NonNull Reservations item) {
        name.setText(item.getUser().getFirstName() + " " + item.getUser().getLastname());
        phoneNumber.setText(item.getUser().getPhoneNumber());
        dateReservation.setText(item.getDay() + " на " + item.getTime());
        descriprion.setText(item.getDescription());
        countPeople.setText(item.getCountPeople() + " человек");

    }


}
