package com.singh.vinay.hadlercalleverysecond.response;

import com.singh.vinay.hadlercalleverysecond.model.UserData;

/**
 * Created by root on 2/2/17.
 */
public class LoginResponse extends CommonResponse{
    public UserData[] getData() {
        return data;
    }

    public void setData(UserData[] data) {
        this.data = data;
    }

    private UserData []data;



}
