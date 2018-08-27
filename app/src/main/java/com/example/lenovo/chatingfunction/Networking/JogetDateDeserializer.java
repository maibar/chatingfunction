package com.example.lenovo.chatingfunction.Networking;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tmsasia on 21/02/2017.
 */

public class JogetDateDeserializer implements JsonDeserializer<Date> {

    public Date deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = json.getAsString();
        try {
            return formatter.parse(strDate);
        } catch (ParseException e) {
            SimpleDateFormat dateCreatedFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
            strDate = strDate.replace(" ", "T");
            try {
                return dateCreatedFormatter.parse(strDate);
            } catch (ParseException e1) {
                return null;
            }
        }
    }
}
