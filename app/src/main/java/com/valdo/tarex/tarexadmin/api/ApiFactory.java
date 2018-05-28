package com.valdo.tarex.tarexadmin.api;

import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.valdo.tarex.tarexadmin.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    private static OkHttpClient sClient;

    private static volatile LoginService loginService;
    private static volatile RequestService requestService;

    private ApiFactory () {
    }

    @NonNull
    public static LoginService getLoginService() {
        LoginService service = loginService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = loginService;
                if (service == null) {
                    service = loginService = buildRetrofit().create(LoginService.class);
                }
            }
        }
        return service;
    }

    @NonNull
    public static RequestService getRequestService() {
        RequestService service = requestService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = requestService;
                if (service == null) {
                    service = requestService = buildRetrofit().create(RequestService.class);
                }
            }
        }
        return service;
    }

    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static OkHttpClient buildClient(){
        return new OkHttpClient.Builder()
                //.addInterceptor(ApiKeyInterceptor.create)
                .addInterceptor(LoggingInterceptor.create())
                .addInterceptor(new StethoInterceptor())
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    private static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    public static void recreate() {
        sClient = null;
        sClient = getClient();
        loginService = buildRetrofit().create(LoginService.class);
    }
}
