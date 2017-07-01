package com.example.unibratec.iot.http;

import android.content.Context;

import com.example.unibratec.iot.model.User;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by mvpires on 01/07/17.
 */

public class UserDeserializer implements JsonDeserializer<User>{

    Context mContext;

    public UserDeserializer(Context context)
    {
        this.mContext = context;
    }


    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        try {

            JsonObject jsonObject = (JsonObject) json;

            User user = new User();
            user.setNome(jsonObject.get("nome").getAsString());
            user.setEndereco(jsonObject.get("endereco").getAsString());
            user.setTelefone(jsonObject.get("telefone").getAsString());
            user.setCpf(jsonObject.get("cpf").getAsString());
            user.setVolume(jsonObject.get("volume").getAsFloat());

            return user;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }
}
