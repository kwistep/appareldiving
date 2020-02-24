package com.appareldiving.adidasdatascraping.util;

import java.net.HttpURLConnection;
import java.util.Map;

abstract class Request {

    private HttpURLConnection urlConnection;

    private String response;

    void setHeaders(Map<String, String> headers)
    {
        for (Map.Entry<String, String> header : headers.entrySet())
        {
            this.urlConnection.setRequestProperty(header.getKey(), header.getValue());
        }
    }

    public void setConnectTimeout(int timeout)
    {
        this.urlConnection.setConnectTimeout(timeout);
    }

    public void setReadTimeout(int timeout)
    {
        this.urlConnection.setReadTimeout(timeout);
    }

    public HttpURLConnection getUrlConnection() {
        return urlConnection;
    }

    void setUrlConnection(HttpURLConnection urlConnection) {
        this.urlConnection = urlConnection;
    }

    public String getResponse() {
        return response;
    }

    void setResponse(String response) {
        this.response = response;
    }
}
