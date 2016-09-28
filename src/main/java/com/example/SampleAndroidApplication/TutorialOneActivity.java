package com.example.SampleAndroidApplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.utilities.MyHttpClient;

/**
 * Created by chokst on 3/19/15.
 */
public class TutorialOneActivity  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial1);
        TextView httpClientOutput = (TextView) findViewById(R.id.textView);
        MyHttpClient myHttpClient = new MyHttpClient();
        try {
            httpClientOutput.setText(myHttpClient.getInternetData());
        } catch (Exception e) {
            e.printStackTrace();
            httpClientOutput.setText("Could not retrieve data from httpClient");
        }
    }
}
