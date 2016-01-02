package com.pawan.buspricecomparison;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Deserializer for a dummy object
 *
 * Convert a JsonObject into a Dummy object.
 */
public class BusDetailsDeserializer implements JsonDeserializer<BusDetailsStatus>
{
    @Override
    public BusDetailsStatus deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException
    {
        final BusDetailsStatus busDetailsStatus = new BusDetailsStatus();
        final JsonObject jsonObject = json.getAsJsonObject();

        busDetailsStatus.setStatusCode(jsonObject.get("statusCode").getAsString());
        busDetailsStatus.setStatusMessage(jsonObject.get("statusMessage").getAsString());

        return busDetailsStatus;
    }
}
