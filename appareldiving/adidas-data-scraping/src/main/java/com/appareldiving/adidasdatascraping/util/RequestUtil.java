package com.appareldiving.adidasdatascraping.util;

import com.appareldiving.adidasdatascraping.util.exceptions.InputUrlIsNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class RequestUtil {

    public static GetRequest prepareGetRequest(String url) throws IOException, InputUrlIsNull {
        GetRequest getRequest =  new GetRequest(url);
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        headers.put("accept-encoding", "text/html; charset=UTF-8");
        headers.put("accept-language", "en-US;q=0.9,en;q=0.8");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
        getRequest.setHeaders(headers);

        return getRequest;
    }

    public static void performRequest(Request request) {
        try {
            int responseCode = request.getUrlConnection().getResponseCode();

            if (responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_BAD_REQUEST) {
                BufferedReader input = new BufferedReader(new InputStreamReader(request.getUrlConnection().getInputStream()));
                StringBuilder response = new StringBuilder();
                String nextString;
                while ((nextString = input.readLine()) != null) {
                    response.append(nextString);
                }
                input.close();
                request.setResponse(response.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
