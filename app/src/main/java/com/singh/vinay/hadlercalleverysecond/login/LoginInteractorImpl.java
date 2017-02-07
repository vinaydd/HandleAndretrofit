package com.singh.vinay.hadlercalleverysecond.login;


import com.singh.vinay.hadlercalleverysecond.model.UserData;
import com.singh.vinay.hadlercalleverysecond.response.LoginResponse;
import com.singh.vinay.hadlercalleverysecond.server.RestClient;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(String username, String password, String Action, final OnLoginFinishedListener listener) {
        Call<LoginResponse> call = RestClient.getInstance().getApiService().login(username, password,Action);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginRs = response.body();
                    if (loginRs!=null) {
                        UserData [] userData = loginRs.getData();
                        ArrayList<UserData> fg = new ArrayList<UserData>(Arrays.asList(userData));

                        for(UserData p:fg ){
                            listener.OnGetData(p);
                        }

                        listener.onSuccess();
                    } else {
                        listener.onError(loginRs.getMessage());
                    }
                } else {
                    listener.onError(response.message());
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                listener.onError(t.getLocalizedMessage());
            }
        });
    }

}
