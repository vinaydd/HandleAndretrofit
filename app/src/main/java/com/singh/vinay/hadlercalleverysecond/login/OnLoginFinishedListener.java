package com.singh.vinay.hadlercalleverysecond.login;

import com.singh.vinay.hadlercalleverysecond.model.UserData;

public interface OnLoginFinishedListener {
    void onError(String message);
    void onSuccess();
    void OnGetData(UserData tClass);
}
