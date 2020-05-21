package buttons.storytelleraman.com.aquam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;


public class Final_Details<sr> extends AppCompatActivity {
    TextView device_no,last_updated,pH_value,Turbidity_value,status;
    Button feedback;
    private JSONArray result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final__details);

        device_no = findViewById(R.id.device_no__id);
        last_updated = findViewById(R.id.last_updated_id);
        pH_value = findViewById(R.id.pH_value_id);
        Turbidity_value = findViewById(R.id.turbidity_val_id);
        status = findViewById(R.id.status_id);
        feedback = findViewById(R.id.feedback_id);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), feedback_window.class);
                startActivity(i);
            }
        });


        //}

        Check_Quality cq = new Check_Quality();

        StringRequest sr = new StringRequest(Config.ACCESS_DATA_URL + "area_name=" + cq.sp2 + "&device_name=" + cq.sp3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray(Config.JSON_ARRAY1);

                            //device_no.setText(result.getString(0));
                            String xx=result.getString(0);
                            Toast.makeText(Final_Details.this, xx, Toast.LENGTH_SHORT).show();
                            //Calling method getStudents to get the students from the JSON Array
                            /*getDeviceNo(result);
                            getph(result);
                            getTurbidity(result);
                            getTime(result);*/
                            //return(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });

        RequestQueue rq = Volley.newRequestQueue(this);
        rq.add(sr);
        //Adding request to the queue

    }

    /*
    private void getTime(JSONArray j) {
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                last_updated.setText(getText(Config.TAG_last_updated));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    private void getTurbidity(JSONArray j) {
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                Turbidity_value.setText(Config.TAG_turbitity);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private void getph(JSONArray j) {
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                pH_value.setText(Config.TAG_PH);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private void getDeviceNo(JSONArray j) {
        //Traversing through all the items in the json array
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                device_no.setText(Config.SERIAL_NO);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }*/
}



