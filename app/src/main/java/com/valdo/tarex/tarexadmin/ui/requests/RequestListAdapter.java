package com.valdo.tarex.tarexadmin.ui.requests;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.valdo.tarex.tarexadmin.model.requests.Reservations;
import com.valdo.tarex.tarexadmin.ui.base.BaseActivity;
import com.valdo.tarex.tarexadmin.ui.base.BaseAdapter;

import java.util.List;

public class RequestListAdapter extends BaseAdapter<Reservations,RequestItemHolder> {

    public RequestListAdapter(@NonNull List<Reservations> items) {
        super(items);
    }


    @Override
    public RequestItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RequestItemHolder.create(parent.getContext());
    }

    @Override
    public void onBindViewHolder(RequestItemHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Reservations item = getItem(position);
        holder.bind(item);
    }
}
