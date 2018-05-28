package com.valdo.tarex.tarexadmin.ui.requests;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.valdo.tarex.tarexadmin.api.ApiFactory;
import com.valdo.tarex.tarexadmin.model.requests.RequestResponse;
import com.valdo.tarex.tarexadmin.repository.RepositoryProvider;
import com.valdo.tarex.tarexadmin.utils.RxUtils;

@InjectViewState
public class RequestListPresenter extends MvpPresenter<RequestListView> {

    public void  getRequest (Long id) {
        ApiFactory.getRequestService()
                .allRequests(id)
                .map(RequestResponse::getReservations)
                .compose(RxUtils.async())
                .subscribe(
                    getViewState()::showItems,
                        getViewState()::handleError);
    }

    public void  getRequestActive (Long id) {
        ApiFactory.getRequestService()
                .activeRequests(id)
                .map(RequestResponse::getReservations)
                .compose(RxUtils.async())
                .subscribe(
                        getViewState()::showItems2,
                        getViewState()::handleError);
    }



}
