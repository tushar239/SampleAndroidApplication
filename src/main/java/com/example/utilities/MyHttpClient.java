package com.example.utilities;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by chokst on 3/19/15.
 */
public class MyHttpClient {
    public String getInternetData() throws Exception {
        BufferedReader in = null;
        String data = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            URI website = new URI("http://www.mybringback.com");
            HttpGet httpGet = new HttpGet();
            httpGet.setURI(website);
            HttpResponse response = httpClient.execute(httpGet);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String l = "";
            String nl = System.getProperty("line.separator");
            while((l = in.readLine()) != null) {
                sb.append(l + nl);
            }
            in.close();
            data = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();;
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return data;
    }
}
