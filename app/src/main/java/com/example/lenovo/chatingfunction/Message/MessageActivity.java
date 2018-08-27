package com.example.lenovo.chatingfunction.Message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.lenovo.chatingfunction.R;
import com.example.lenovo.chatingfunction.Utils.Alert;

public class MessageActivity extends AppCompatActivity {

    private MessageAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String ticketId = getIntent().getStringExtra("TICKET_ID");

        final RecyclerView recyclerView = findViewById(R.id.display_chat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Message.fetchMessages(ticketId, messages -> {
            if (mAdapter == null) {
                MessageAdapter adapter = new MessageAdapter(messages, true);
                recyclerView.setAdapter(adapter);
            }
        }, error -> {
            Alert.showAlert(MessageActivity.this, "Error", error.getLocalizedMessage(), "OK", ()->{
                finish();
            });
        });
    }
}