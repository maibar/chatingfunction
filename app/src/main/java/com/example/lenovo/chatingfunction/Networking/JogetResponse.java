package com.example.lenovo.chatingfunction.Networking;

/**
 * Created by tmsasia on 11/08/2018.
 */

public class JogetResponse<T> {
    public interface Listener<T>{
        void onResponse(T response);
    }

    public interface ErrorListener{
        void onError(Exception error);
    }
}
