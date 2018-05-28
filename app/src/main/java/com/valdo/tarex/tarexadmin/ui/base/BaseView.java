package com.valdo.tarex.tarexadmin.ui.base;

public interface BaseView<T> {

    void setPresenter(T presenter);

    void handleError(Throwable error);
}
