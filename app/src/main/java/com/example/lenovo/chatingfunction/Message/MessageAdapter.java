package com.example.lenovo.chatingfunction.Message;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.chatingfunction.R;

import java.util.ArrayList;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class MessageAdapter extends RealmRecyclerViewAdapter<Message, MessageAdapter.MessageViewHolder> {

    public MessageAdapter(@Nullable OrderedRealmCollection<Message> data, boolean autoUpdate) {
        super(data, autoUpdate);
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_layouts, parent, false);
//        return new MessageViewHolder(view);

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_chat, parent, false);
        return new MessageViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = getData().get(position);
        holder.tvchat.setText(message.message);
        holder.tvdate.setText(message.id);
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        View vContainer;
        TextView tvchat;
        TextView tvdate;

        public MessageViewHolder(View itemView) {
            super(itemView);
            tvchat = itemView.findViewById(R.id.tv_chat);
            tvdate = itemView.findViewById(R.id.tv_date);
            vContainer = itemView.findViewById(R.id.container);
        }
    }
}