package com.singh.vinay.hadlercalleverysecond.login;

public interface LoginPresenter {
    void login(String username, String password, String fcmToken);
    void onDestroy();
}
