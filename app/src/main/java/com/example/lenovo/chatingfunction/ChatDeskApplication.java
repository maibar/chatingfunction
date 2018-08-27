package com.example.lenovo.chatingfunction;

import android.app.Application;
import android.app.DownloadManager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ChatDeskApplication extends Application {

    public static RequestQueue httpQueue = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(configuration);

        httpQueue = Volley.newRequestQueue(this);
    }
}
