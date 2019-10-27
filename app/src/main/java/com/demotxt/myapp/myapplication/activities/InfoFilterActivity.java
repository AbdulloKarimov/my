package com.demotxt.myapp.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.demotxt.myapp.myapplication.R;
import com.demotxt.myapp.myapplication.adapters.RecyclerViewAdapter;
import com.demotxt.myapp.myapplication.model.Job;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InfoFilterActivity extends AppCompatActivity {

    private String bundeslandFiltr = "";
    private String arten = "";
    private String berufsfelder = "";
    private String JSON_URL = "https://www.wikway.de/companies/offers-json?password=ain1018" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Job> lstJob;
    private RecyclerView recyclerView ;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("SucheJob");
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(false);

        if (bundeslandFiltr.equals("null") || bundeslandFiltr.equals("Alle") || bundeslandFiltr.equals(null)) {
        } else {
            bundeslandFiltr ="&bundesland="+getIntent().getStringExtra("bundesland");
        }

        if (berufsfelder.equals("null") || berufsfelder.equals("Alle") || berufsfelder.equals(null)) {
        } else {
            berufsfelder ="&berufsfeld="+getIntent().getStringExtra("berufsfelder");
        }

        if (arten.equals("null") || arten.equals("Alle") || arten.equals(null)) {
        } else {
            arten ="&art="+getIntent().getStringExtra("arten");
        }

        reconnection();

        Button filter_btn = (Button)findViewById(R.id.filtr);
        filter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoFilterActivity.this,FilterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void reconnection(){
        lstJob = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL+bundeslandFiltr, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Job job = new Job() ;
                        job.setBewerber_Kontakt(jsonObject.getString("Bewerberkontakt Firma"));
                        job.setBundesland(jsonObject.getString("Bundesland"));
                        job.setEinsatzort(jsonObject.getString("Einsatzort"));
                        job.setStelle_Aktiv_bis(jsonObject.getString("Stelle aktiv bis (Publikationsende)"));

                        job.setAnscheiben_zur_Stelle(jsonObject.getString("Anschreiben zur Stelle"));
                        job.setBezeichnung_der_Stelle(jsonObject.getString("Bezeichnung der Stelle"));

                        job.setLogo(jsonObject.getString("Logo"));

                        job.setE_Mail(jsonObject.getString("E-Mail"));
                        job.setStreet(jsonObject.getString("Straße"));
                        job.setAnspreshpartner(jsonObject.getString("Ansprechpartner"));
                        job.setUmzeit(jsonObject.getString("Umfang"));

                        job.setAbteilung(jsonObject.getString("Abteilung"));
                        lstJob.add(job);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstJob);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(InfoFilterActivity.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Job> lstJob) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, lstJob) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}