package com.example.lenovo.chatingfunction.Networking;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;


/**
 * Created by tmsasia on 14/09/2017.
 */

public class JogetRetryPolicy implements RetryPolicy {

    private JogetResponse.ErrorListener errorListener;

    public JogetRetryPolicy(JogetResponse.ErrorListener errorListener) {
        this.errorListener = errorListener;
    }


    public int getCurrentTimeout() {
        return 10000;
    }


    public int getCurrentRetryCount() {
        return 5;
    }


    public void retry(VolleyError error) throws VolleyError {
        if (errorListener != null) {
            errorListener.onError(error);
        }
    }
}
