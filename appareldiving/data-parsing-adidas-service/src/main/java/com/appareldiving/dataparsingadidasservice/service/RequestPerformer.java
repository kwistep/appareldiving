package com.appareldiving.dataparsingadidasservice.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class RequestPerformer  implements IRequestPerformer {


    private HttpURLConnection prepareRequest(String link) throws IOException {

        URL url = new URL(link);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(5000);
        urlConnection.setConnectTimeout(5000);

        return urlConnection;
    }




    @Override
    public String getResponse(String link) {

        String responseStr = Strings.EMPTY;

        try {
            HttpURLConnection urlConnection = prepareRequest(link);


            Map<String, String> headers = new HashMap<String, String>();
            headers.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            headers.put("accept-encoding", "text/html; charset=UTF-8");
            headers.put("accept-language", "en-US;q=0.9,en;q=0.8");
            headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");



                for (Map.Entry<String, String> header : headers.entrySet()) {
                    urlConnection.setRequestProperty(header.getKey(), header.getValue());
                }


            try {
                int responseCode = urlConnection.getResponseCode();

                if (responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_BAD_REQUEST) {
                    BufferedReader input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String nextString;
                    while ((nextString = input.readLine()) != null) {
                        response.append(nextString);
                    }
                    input.close();
                    responseStr = response.toString();
                } else {
                    //TODO logging
                    System.out.println("HTTP request failed.");
                }

            } catch (
                    IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseStr;
    }
}
