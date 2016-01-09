package com.pawan.buspricecomparison;

import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pawan.pojo.ClearTripBus;

import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Makes a get request and converts the response from JsonElement into a
 * list of objects/object using with Google Gson.
 */
public class GsonGetRequest<T> extends Request<T>
{
    private final Gson gson;
    private final Type type;
    private final Response.Listener<T> listener;

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url URL of the request to make
     * @param type is the type of the object to be returned
     * @param listener is the listener for the right answer
     * @param errorListener  is the listener for the wrong answer
     */
    public GsonGetRequest
    (
            @NonNull final String url,
            @NonNull final Type type,
            @NonNull final Gson gson,
            @NonNull final Response.Listener<T> listener,
            @NonNull final Response.ErrorListener errorListener
    )
    {
        super(Method.GET, url, errorListener);

        this.gson = gson;
        this.type = type;
        this.listener = listener;
    }

    @Override
    protected void deliverResponse(T response)
    {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response)
    {
        try
        {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));

            JsonElement jelement = new JsonParser().parse(json);
            JsonObject  jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject("btd");

            String s= jobject.toString();
            Log.d("GetResponse", jobject.toString());
            Log.d("GetResponse", s.substring(s.length()-10,s.length()));
            Log.d("GetResponse", s.substring(1,10));

            Gson gson = new Gson();
            List<ClearTripBus> busList = new ArrayList<ClearTripBus>();
            Type mapType = new TypeToken<Map<String,ClearTripBus>>() {}.getType();
            Map<String, ClearTripBus> map = gson.fromJson(jobject.toString(), mapType);
            //System.out.println(map);


            for ( Map.Entry<String, ClearTripBus> entry : map.entrySet()) {
                String key = entry.getKey();
                ClearTripBus clearTripBus = new ClearTripBus();
                clearTripBus=entry.getValue();
                busList.add(clearTripBus);

                Log.i("pppppppppppp", ""+key + "\t" + clearTripBus.getAt() + "" + clearTripBus.getDpi());

            }


            return (Response<T>) Response.success
                    (
                            busList,
                            HttpHeaderParser.parseCacheHeaders(response)
                    );
        }
        catch (UnsupportedEncodingException e)
        {
            return Response.error(new ParseError(e));
        }
        catch (JsonSyntaxException e)
        {
            return Response.error(new ParseError(e));
        }
    }
}
