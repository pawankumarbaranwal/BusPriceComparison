package com.pawan.buspricecomparison;

import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.pawan.pojo.ClearTripBus;
import com.pawan.pojo.PaytmBuses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Api requests
 */
public class ApiRequests
{
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(BusDetails.class, new BusDetailsDeserializer())
            .create();
    /**
     * Returns a dummy object
     *
     * @param listener is the listener for the correct answer
     * @param errorListener is the listener for the error response
     *
     * @return {@link GsonGetRequest}
     */
    public static GsonGetRequest<Set<ClearTripBus>> getObject

    (
            String url,
            @NonNull final Response.Listener<Set<ClearTripBus>> listener,
            @NonNull final Response.ErrorListener errorListener
    )
    {

        return new GsonGetRequest<Set<ClearTripBus>>
                (
                        url,
                        new TypeToken<Set<ClearTripBus>>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                );
    }

    /**
     * Returns a dummy object's array
     *
     * @param listener is the listener for the correct answer
     * @param errorListener is the listener for the error response
     *
     * @return {@link GsonGetRequest}
     */
    /*public static GsonGetRequest<ArrayList<DummyObject>> getDummyObjectArray
    (
            @NonNull final Response.Listener<ArrayList<DummyObject>> listener,
            @NonNull final Response.ErrorListener errorListener
    )
    {
        final String url = BuildConfig.apiDomainName + "/v2/5597d86a6344715505576725";
//        final String url = BuildConfig.apiDomainName + "/project-1.0.0-BUILD-SNAPSHOT/getOrgType";
        return new GsonGetRequest<>
                (
                        url,
                        new TypeToken<ArrayList<DummyObject>>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                );
    }*/


    /**
     * An example call (not used in this app example) to demonstrate how to do a Volley POST call
     * and parse the response with Gson.
     *
     * @param listener is the listener for the success response
     * @param errorListener is the listener for the error response
     *
     * @return {@link GsonPostRequest}
     */
   /* public static GsonPostRequest getDummyObjectArrayWithPost
    (
            @NonNull final Response.Listener<DummyObject> listener,
            @NonNull final Response.ErrorListener errorListener
    )
    {
        final String url = BuildConfig.apiDomainName + "/dummyPath";

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "Ficus");
        jsonObject.addProperty("surname", "Kirkpatrick");

        final JsonArray squareGuys = new JsonArray();
        final JsonObject dev1 = new JsonObject();
        final JsonObject dev2 = new JsonObject();
        dev1.addProperty("name", "Jake Wharton");
        dev2.addProperty("name", "Jesse Wilson");
        squareGuys.add(dev1);
        squareGuys.add(dev2);


        jsonObject.add("squareGuys", squareGuys);

        final GsonPostRequest gsonPostRequest = new GsonPostRequest<>
                (
                        url,
                        jsonObject.toString(),
                        new TypeToken<DummyObject>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                );

        gsonPostRequest.setShouldCache(false);

        return gsonPostRequest;
    }*/

    public static GsonPostRequest getPayObjectArrayWithPost
            (
                    @NonNull final Response.Listener<PaytmBuses[]> listener,
                    @NonNull final Response.ErrorListener errorListener,
                    final Map<String, String> mParams,
                    String registrationURL
            )
    {
        final String url = registrationURL;//"https://tickets.paytm.com/search";


        final JsonObject searchParams = new JsonObject();
        searchParams.addProperty("count",Integer.parseInt(mParams.get("count")));
        searchParams.addProperty("date",mParams.get("date"));
        searchParams.addProperty("destination",mParams.get("destination"));
        searchParams.addProperty("source",mParams.get("source"));
        Log.i("Input for Paytime", searchParams.toString());

        final GsonPostRequest gsonPostRequest = new GsonPostRequest<PaytmBuses[]>
                (
                        url,
                        searchParams.toString(),
                        new TypeToken<PaytmBuses[]>() {}.getType(),
                        gson,
                        listener,
                        errorListener
                ){
            @Override
            public Map<String, String> getHeaders () throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");

                return params;
            }

            @Override
            public Map<String, String> getParams() {
                return mParams;
            }
        };

        gsonPostRequest.setShouldCache(false);
        Log.i("RegistrationRes", gsonPostRequest.getBody().toString());
        return gsonPostRequest;
    }


}
