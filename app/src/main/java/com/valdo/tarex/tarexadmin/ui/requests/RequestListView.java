package com.valdo.tarex.tarexadmin.ui.requests;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.valdo.tarex.tarexadmin.model.requests.Reservations;

import java.util.List;

public interface RequestListView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void handleError(Throwable error);

    void showItems(@NonNull List<Reservations> items);

    void showItems2(@NonNull List<Reservations> items);

}
