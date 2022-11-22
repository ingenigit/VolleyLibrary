package com.or2go.volleylibrary;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class HttpVolleyHelper {
    public Context mContext;
    public RequestQueue mRequstQueue;

    public HttpVolleyHelper(Context context)
    {
        mContext = context;
        mRequstQueue = Volley.newRequestQueue(mContext);
    }
    public boolean PostArrayRequest(String URL, HashMap<String, String> params, final CommApiCallback callback)
    {
        JSONObject postparams = new JSONObject(params);
        Response.Listener<JSONArray> postlistner = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    if (callback != null) {
                        callback.setResult(1);
                        callback.setResponse(response.toString());
                        callback.call();
                    }
                } /*catch (JSONException e) {
                    e.printStackTrace();
                } */
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Response.ErrorListener  errorlistner = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    if (callback != null) {
                        callback.setResult(0);
                        callback.setResponse(error.getMessage());
                        callback.call();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        JsonRequest<JSONArray> req = new CustomJsonArrayRequest(Request.Method.POST,URL,postparams ,postlistner, errorlistner );//JsonObjectRequest(Request.Method.POST,URL,postparams ,postlistner, errorlistner );
        //req.setRetryPolicy(new DefaultRetryPolicy(30 * 1000, 1, 3/*DefaultRetryPolicy.DEFAULT_BACKOFF_MULT*/));
        req.setRetryPolicy(new VolleyRetryHelper(10 * 1000, -1, 1));
        req.setShouldCache(false);
        mRequstQueue.add(req);
        return true;
    }

    public boolean PostArrayRequest(String URL, JSONObject postparams, final CommApiCallback callback)
    {
        Response.Listener<JSONArray> postlistner = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    if (callback != null) {
                        callback.setResult(1);
                        callback.setResponse(response.toString());
                        callback.call();
                    }
                } /*catch (JSONException e) {
                    e.printStackTrace();
                } */
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Response.ErrorListener errorlistner = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    if (callback != null) {
                        callback.setResult(0);
                        callback.setResponse(error.getMessage());
                        callback.call();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        JsonRequest<JSONArray> req = new CustomJsonArrayRequest(Request.Method.POST,URL,postparams ,postlistner, errorlistner );//JsonObjectRequest(Request.Method.POST,URL,postparams ,postlistner, errorlistner );
        //req.setRetryPolicy(new DefaultRetryPolicy(30 * 1000, 1, 3/*DefaultRetryPolicy.DEFAULT_BACKOFF_MULT*/));
        req.setRetryPolicy(new VolleyRetryHelper(30 * 1000, -1, 1));
        req.setShouldCache(false);
        mRequstQueue.add(req);
        return true;
    }

    public boolean PostObjectRequest(String URL, HashMap<String, String> params, final CommApiCallback callback)
    {
        JSONObject postparams = new JSONObject(params);
        Response.Listener<JSONObject> postlistner = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (callback != null) {
                        callback.setResult(1);
                        callback.setResponse(response.toString());
                        callback.call();
                    }
                } /*catch (JSONException e) {
                    e.printStackTrace();
                } */
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Response.ErrorListener  errorlistner = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    if (callback != null) {
                        callback.setResult(0);
                        callback.setResponse(error.getMessage());
                        callback.call();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        JsonRequest<JSONObject> req = new JsonObjectRequest(Request.Method.POST,URL,postparams ,postlistner, errorlistner );//JsonObjectRequest(Request.Method.POST,URL,postparams ,postlistner, errorlistner );
        //req.setRetryPolicy(new DefaultRetryPolicy(30 * 1000, 1, 3/*DefaultRetryPolicy.DEFAULT_BACKOFF_MULT*/));
        req.setRetryPolicy(new VolleyRetryHelper(30 * 1000, -1, 1));
        req.setShouldCache(false);
        mRequstQueue.add(req);
        return true;
    }
}
