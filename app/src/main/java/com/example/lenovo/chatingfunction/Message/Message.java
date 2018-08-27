package com.example.lenovo.chatingfunction.Message;

import com.example.lenovo.chatingfunction.Networking.API;
import com.example.lenovo.chatingfunction.Networking.APIManager;
import com.example.lenovo.chatingfunction.Networking.JogetResponse;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

public class Message extends RealmObject {

    @PrimaryKey
    String message;
    String id;
    String ticket_id;
    Date dateModified;
    String status;
    String sender_id;
    String department_id;
    Date dateCreated;
    String receiver_id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }


    public static void fetchMessages(String ticketId, final JogetResponse.Listener<RealmResults<Message>> lister, final JogetResponse.ErrorListener errorListener){
        Realm realm = Realm.getDefaultInstance();
        lister.onResponse(realm.where(Message.class).findAll());

        String urlMessage = API.urlMessages("150");

        Type collectionType = new TypeToken<Message[]>() {
        }.getType();

        APIManager.loadData(urlMessage, collectionType, response -> {
            Message[] messages = (Message[]) response;

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(Arrays.asList(messages));
            realm.commitTransaction();

            RealmResults<Message> managedMessage = realm.where(Message.class).findAll();

            lister.onResponse(managedMessage);
        }, errorListener);
    }
}
