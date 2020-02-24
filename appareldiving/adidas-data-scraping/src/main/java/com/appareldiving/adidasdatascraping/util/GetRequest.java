package com.appareldiving.adidasdatascraping.util;

import com.appareldiving.adidasdatascraping.util.exceptions.InputUrlIsNull;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetRequest extends Request {


    GetRequest(String urlStr) throws InputUrlIsNull, IOException
    {
        super();
        if( urlStr == null )
        {
            throw new InputUrlIsNull();
        }
        try {
            URL url = new URL(urlStr);
            super.setUrlConnection((HttpURLConnection) url.openConnection());
            super.getUrlConnection().setRequestMethod("GET");
            super.getUrlConnection().setReadTimeout(5000);
            super.getUrlConnection().setConnectTimeout(5000);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
