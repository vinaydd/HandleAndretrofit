package com.singh.vinay.hadlercalleverysecond.server;

import java.io.IOException;

public class ErrorHandler {
    public static String getErrorMessage(Throwable t) {
        if (t instanceof IOException) {
            return "No internet. Please check your network status and try again.";
        } else {
            return t.getLocalizedMessage();
        }
    }
}
