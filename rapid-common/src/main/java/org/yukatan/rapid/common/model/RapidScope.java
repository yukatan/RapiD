package org.yukatan.rapid.common.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public class RapidScope {

    private Map<String,String> headers;
    private Map<String,String> params;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RapidScope{" +
                "headers=" + headers +
                ", params=" + params +
                '}';
    }
}
