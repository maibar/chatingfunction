package com.example.lenovo.chatingfunction.Networking;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.lenovo.chatingfunction.ChatDeskApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by tmsasia on 11/08/2018.
 */

public class APIManager {

    public static void loadData(String url, final Type collectionType, final JogetResponse.Listener listener, final JogetResponse.ErrorListener errorListener) {

        StringRequest request = new StringRequest(Request.Method.GET, url, data -> {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Date.class, new JogetDateDeserializer());
            Gson gson = builder.create();

            listener.onResponse(gson.fromJson(data, collectionType));
        }, error -> {
            errorListener.onError(error);
        });

        ChatDeskApplication.httpQueue.add(request);
    }

    public static void postData(String url, JSONObject payload, Type collectionType, JogetResponse.Listener listener, JogetResponse.ErrorListener errorListener){
        StringRequest request = new StringRequest(Request.Method.POST, url, (response) -> {

            Log.d("CART_RESPONSE", response);
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Date.class, new JogetDateDeserializer());
            Gson gson = builder.create();

            try {
                listener.onResponse(gson.fromJson(response, collectionType));
            }catch (Exception e){
                errorListener.onError(e);
            }
        }, (error) -> {
            errorListener.onError(error);
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    if (payload != null) {
                        return payload.toString().getBytes("utf-8");
                    }
                } catch (UnsupportedEncodingException e) {
                    errorListener.onError(e);
                }
                return null;
            }

            @Override
            public String getBodyContentType() {
                return "application/json;charset=utf-8";
            }
        };
        request.setRetryPolicy( new JogetRetryPolicy(errorListener));
        ChatDeskApplication.httpQueue.add(request);
    }
}
