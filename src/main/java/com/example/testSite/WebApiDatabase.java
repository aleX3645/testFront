package com.example.testSite;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebApiDatabase {
    String url = "http://localhost:8888/equation/getEquationById";

    public String getJson(String id, String lang){
        StringBuilder sb = new StringBuilder();
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url+ "?id=" + id + "&lang=" + lang).openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            connection.connect();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null){
                    sb.append(line);
                }
            }
            System.out.println(sb.toString());
        }catch (Throwable cause){
            cause.printStackTrace();
        }finally {
            if(connection != null){
                connection.disconnect();

            }
        }
        return sb.toString();
    }
}
