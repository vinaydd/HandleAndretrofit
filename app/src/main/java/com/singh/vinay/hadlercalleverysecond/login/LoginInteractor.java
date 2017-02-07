package com.singh.vinay.hadlercalleverysecond.login;

public interface LoginInteractor {
    void login(String username, String password, String fcmToken, OnLoginFinishedListener listener);
}
