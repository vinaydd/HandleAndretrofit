package com.singh.vinay.hadlercalleverysecond.login;

public interface LoginView {
    void showProgress();

    void hideProgress();

    void showError(String message);

    void loggedIn();
}
