package com.valdo.tarex.tarexadmin.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.valdo.tarex.tarexadmin.api.ApiFactory;
import com.valdo.tarex.tarexadmin.model.form.LoginForm;
import com.valdo.tarex.tarexadmin.utils.RxUtils;
import com.valdo.tarex.tarexadmin.utils.prefs.AppPreferencesHelper;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    @SuppressLint("CheckResult")
    public void login (String login, String pass) {
        LoginForm loginForm = new LoginForm(login,pass);
        ApiFactory.getLoginService()
                .user(loginForm)
                .compose(RxUtils.async())
                .subscribe(restaurantResponse -> {
                    String token = restaurantResponse.getTokenDto().getValue();
                    Long id = restaurantResponse.getRestaurant().getId();
                    Log.d("TOKEN!!!", id.toString());
                    getViewState().setId(id);
                    getViewState().setAccessToken(token);

                });
    }

    public void createSharedPreferences (Context context, String token) {
        String nameSharedPreferences = "shPref";
        AppPreferencesHelper appPreferencesHelper =
                new AppPreferencesHelper(context,nameSharedPreferences);
        if (token != null)
            appPreferencesHelper.setAccessToken(token);
        getViewState().getSpToken(appPreferencesHelper.getAccessToken());

    }

    public String getAccesToken (Context context,String namePrefs) {
        AppPreferencesHelper appPreferencesHelper = new AppPreferencesHelper(context,namePrefs);
        return appPreferencesHelper.getAccessToken();
    }

}
