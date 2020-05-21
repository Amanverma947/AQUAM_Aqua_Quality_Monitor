package buttons.storytelleraman.com.aquam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Check_Quality extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button view_details_button;
    List<String> spinnerArea_jbp = new ArrayList<>();
    List<String> spinnerArea_bhp = new ArrayList<>();
    private String URL = "https://harshswaroopsingh.000webhostapp.com/display_citys.php";
    private Spinner spinner_city, spinner_area;
    public List<String> cityarray,areaarray,devicenoarray;
    private  JSONArray result,result1;
    String sp1,sp2,sp3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__quality);
        view_details_button = findViewById(R.id.view_details_id);

        cityarray = new ArrayList<>();


        spinner_city = findViewById(R.id.city_spinner_id);
        spinner_area = findViewById(R.id.area_spinner_id);

        //getCity(getData(Config.DATA_URL));
        //getArea(getData(Config.AREA_URL));
        getData(Config.DATA_URL);
        spinner_city.setOnItemSelectedListener(this);
        spinner_area.setOnItemSelectedListener(this);

        view_details_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Final_Details.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, final int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        areaarray = new ArrayList<>();
        devicenoarray = new ArrayList<>();



            sp1 = String.valueOf(spinner_city.getSelectedItem());

        //Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();


     //getArea(getData(Config.AREA_URL+sp1),arg2);

        StringRequest sr = new StringRequest(Config.AREA_URL+sp1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result1 = j.getJSONArray(Config.JSON_ARRAY1);

                            //Calling method getStudents to get the students from the JSON Array
                            getArea(result1,arg2);
                            getDeviceNo(result,arg2);
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

        //Adding request to the queue
        rq.add(sr);


    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    private void getData(String url){
        //Creating a string request
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray(Config.JSON_ARRAY);

                            //Calling method getStudents to get the students from the JSON Array
                            getCity(result);
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


        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
        //return(result);
    }
    private void getCity(JSONArray j){
        //Traversing through all the items in the json array
        for(int i=0;i<j.length();i++){
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                cityarray.add(json.getString(Config.TAG_CITY));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //Setting adapter to show the items in the spinner
        spinner_city.setAdapter(new ArrayAdapter<String>(Check_Quality.this, android.R.layout.simple_spinner_dropdown_item, cityarray));
    }

    private void getArea(JSONArray j,int k){
        //Traversing through all the items in the json array
        for(int i=0;i<j.length();i++){
            try {
                //Getting json object
                    JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                areaarray.add(json.getString(Config.TAG_AREA));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        sp2=areaarray.get(k);



        //Setting adapter to show the items in the spinner
        spinner_area.setAdapter(new ArrayAdapter<String>(Check_Quality.this, android.R.layout.simple_spinner_dropdown_item, areaarray));
    }

    private void getDeviceNo(JSONArray j,int k){
        //Traversing through all the items in the json array
        for(int i=0;i<j.length();i++){
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                devicenoarray.add(json.getString(Config.TAG_DEVICE_NO1));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



       sp3=devicenoarray.get(k).toString();
    }


    }

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__quality);
        view_details_button = findViewById(R.id.view_details_id);

        view_details_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Final_Details.class);
                startActivity(i);
            }
        });

        spinner = findViewById(R.id.city_spinner_id);
        spinner2 = findViewById(R.id.area_spinner_id);

        spinnerArray.add("JABALPUR");
        spinnerArray.add("BHOPAL");

// (3) create an adapter from the list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_spinner_item,
                spinnerArray
        );

//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// (4) set the adapter on the spinner
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    String text;

                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        Context context = getApplicationContext();
                        if (position == 0) {
                            text = "JABALPUR";
                            spinnerArea_jbp.add("Narmada Road");
                            spinnerArea_jbp.add("Shakti Nagar");
                            spinnerArea_jbp.add("Labour Chowk");
                            spinnerArea_jbp.add("Hathital");
                            spinnerArea_jbp.add("Civic Centre");
                            spinnerArea_jbp.add("Ranital");
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                    getApplicationContext(),
                                    android.R.layout.simple_spinner_item,
                                    spinnerArea_jbp
                            );
                            spinner2.setAdapter(adapter);

                        } else {
                            text = "BHOPAL";
                            spinnerArea_bhp.add("Gandhi Nagar");
                            spinnerArea_bhp.add("Raja Bhoj Lake");
                            spinnerArea_bhp.add("Hanuman Ganj");
                            spinnerArea_bhp.add("HabibGang");
                            spinnerArea_bhp.add("People's City");
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                    getApplicationContext(),
                                    android.R.layout.simple_spinner_item,
                                    spinnerArea_bhp
                            );
                            spinner2.setAdapter(adapter);
                        }
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();


                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                        Toast toast = Toast.makeText(getApplicationContext(), "NOTHING SELECTED", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
    /*
        ArrayList<String> CityName;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            CityName=new ArrayList<>();
            spinner=(Spinner)findViewById(R.id.city_spinner_id);
            loadSpinnerData(URL);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String country=   spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                    Toast.makeText(getApplicationContext(),country,Toast.LENGTH_LONG).show();
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    // DO Nothing here
                }
            });
        }
        private void loadSpinnerData(String url) {
            RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try{
                        JSONObject jsonObject=new JSONObject(response);
                        if(jsonObject.getInt("success")==1){
                            JSONArray jsonArray=jsonObject.getJSONArray("Name");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                String country=jsonObject1.getString("Country");
                                CityName.add(country);
                            }
                        }
                        spinner.setAdapter(new ArrayAdapter<String>(Check_Quality.this, android.R.layout.simple_spinner_dropdown_item, CityName));
                    }catch (JSONException e){e.printStackTrace();}
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

    }*/








