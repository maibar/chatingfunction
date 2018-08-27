package com.example.lenovo.chatingfunction.Networking;

/**
 * Created by tmsasia on 11/08/2018.
 */

public class API {
    private static final String BASE_URL = "http://52.221.188.40";

//    public static String urlAllTickets(String reportedBy){
//        return BASE_URL + "/jw/web/json/plugin/org.joget.custom.webservices.JsonApiPlugin/service?listId=issueList&action=list&appId=tcmsHelpdesk&filter1Column=reported_by&filter1Value="+ reportedBy + "&filter2Column=&filter2Value=&imageUrl=Yes&method=listDataList";
//    }
    //API get message
    public static String urlMessages(String ticket_id){
        return BASE_URL + "/jw/web/json/plugin/org.joget.custom.webservices.JsonApiPlugin/service?listId=chatList&action=list&appId=tcmsHelpdesk&filter1Column=80&filter1Value=80&filter2Column=&filter2Value=&imageUrl=Yes&method=listDataList";
    }

//    public static String urlLogin(){
//        return BASE_URL + "/jw/web/json/plugin/org.dcim.AuthService/service";
//    }
}
