package com.singh.vinay.hadlercalleverysecond.login;

import android.text.TextUtils;

import com.singh.vinay.hadlercalleverysecond.App;
import com.singh.vinay.hadlercalleverysecond.R;
import com.singh.vinay.hadlercalleverysecond.model.UserData;


public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {

    //view
    private LoginView loginView;

    //interactor
    private LoginInteractor loginInteractor;

    /**
     * Constructor
     *
     * @param loginView
     */
    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    /**
     * login
     */
    @Override
    public void login(String username, String password, String fcmToken) {
        if (loginView != null) {
            String error = null;
            if (TextUtils.isEmpty(username)) {
                error = App.getAppContext().getString(R.string.error_enter_username);
            } else if (TextUtils.isEmpty(password)) {
                error = App.getAppContext().getString(R.string.error_enter_password);
            }

            if (error != null) {//show error
                loginView.showError(error);
            } else {//perform login
                loginView.showProgress();
                loginInteractor.login(username, password, fcmToken, this);
            }
        }
    }

    /**
     * On login error
     */
    @Override
    public void onError(String message) {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.showError(message);
        }
    }

    /**
     * On login success
     */
    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.loggedIn();
        }
    }

    @Override
    public void OnGetData(UserData tClass) {

    }

    /**
     * On view destroyed
     */
    @Override
    public void onDestroy() {
        loginView = null;
    }

}
