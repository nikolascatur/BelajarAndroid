package com.paintphobia.heri.belajarandroid.utils;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

/**
 * Created by heri on 6/19/2016.
 */
public class NetworkError extends Throwable {

    public static final String DEFAULT_ERROR_MSG = "Something went wrong! Please try again.";
    public static final String NETWORK_ERROR_MSG = "No Internet Connection";
    public static final String ERROR_MSG_HEADER = "Error-Message";

    private final Throwable error;

    public NetworkError(Throwable error) {
        super(error);
        this.error = error;
    }

    public String getMessage() {
        return error.getMessage();
    }

    public boolean isAuthFailure() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_UNAUTHORIZED;
    }

    public boolean isResponseNull() {
        return error instanceof HttpException && ((HttpException) error).response() == null;
    }

    private String getJsonStringFromResponse(final retrofit2.Response<?> response) {
        try {
            String jsonString = response.errorBody().string();
            Response errorResponse = new Gson().fromJson(jsonString, Response.class);
            return errorResponse.message();
        } catch (Exception e) {
            return null;
        }
    }

    public String getAppErrorMessage() {
        if(this.error instanceof IOException) {
            return  NETWORK_ERROR_MSG;
        }

        if(!(this.error instanceof HttpException)) {
            return DEFAULT_ERROR_MSG;
        }

        retrofit2.Response<?> response = ((HttpException) this.error).response();
        if(response != null) {
            String msg = getJsonStringFromResponse(response);
            if(!TextUtils.isEmpty(msg)) {
                return msg;
            }

            Map<String,List<String>> headers = response.headers().toMultimap();
            if(headers.containsKey(ERROR_MSG_HEADER)) {
                return headers.get(ERROR_MSG_HEADER).get(0);
            }
        }

        return DEFAULT_ERROR_MSG;
    }

    public Throwable getError() {
        return error;
    }
}
