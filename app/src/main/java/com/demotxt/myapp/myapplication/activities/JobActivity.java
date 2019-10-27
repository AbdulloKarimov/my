package com.demotxt.myapp.myapplication.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.demotxt.myapp.myapplication.R;
import com.squareup.picasso.Picasso;

public class JobActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // hide the default actionbar
//        getSupportActionBar().hide();


        // Recieve data

        String Bewerber_Kontakt  = getIntent().getExtras().getString("Bewerber_Kontakt");
        String Bundesland = getIntent().getExtras().getString("Bundesland");
        String Einsatzort = getIntent().getExtras().getString("Einsatzort") ;


        String Anscheiben_zur_Stelle = getIntent().getExtras().getString("Anscheiben_zur_Stelle") ;
        String Bezeichnung_der_Stelle = getIntent().getExtras().getString("Bezeichnung_der_Stelle") ;
        String Logo = getIntent().getExtras().getString("Logo") ;

        String E_Mail = getIntent().getExtras().getString("E_Mail") ;
        String street = getIntent().getExtras().getString("street") ;
        String anspreshpartner = getIntent().getExtras().getString("anspreshpartner") ;
        String umzeit = getIntent().getExtras().getString("umzeit") ;
        String abteilung = getIntent().getExtras().getString("abteilung");


        //String Stelle_Aktiv_bis = getIntent().getExtras().getString("Stelle_Aktiv_bis");


        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView bewerberkontakt_info = findViewById(R.id.bewerberinfo);
        TextView bundesland_info = findViewById(R.id.bundeslandinfo) ;
        TextView einsatzort_info = findViewById(R.id.einsatzortinfo);

        TextView anschreiben_info = findViewById(R.id.anschreibeninfo);
        TextView bezeichnung_info = findViewById(R.id.bezeichnunginfo);
        ImageView img = findViewById(R.id.logoinfo);

        TextView email_info = findViewById(R.id.email);
        TextView adress_info = findViewById(R.id.adress);
        TextView anspreschpartner_info = findViewById(R.id.anspreschpartner);
        TextView umzeit_info = findViewById(R.id.umzeit);

        // setting values to each view


        bewerberkontakt_info.setText(Bewerber_Kontakt);
        bundesland_info.setText("Bundesland: "+Bundesland);
        einsatzort_info.setText("Einsatzort: "+Einsatzort);

        anschreiben_info.setText(Anscheiben_zur_Stelle);
        bezeichnung_info.setText(Bezeichnung_der_Stelle);

        email_info.setText("E-Mail: "+E_Mail);
        adress_info.setText("Strasse: "+street);
        anspreschpartner_info.setText("Anspreschpartner: "+anspreshpartner);
        umzeit_info.setText("Umfang: "+umzeit);


        if (abteilung.equals("null")) {
            collapsingToolbarLayout.setTitle("keine Abteilung");
        }
        else {
            collapsingToolbarLayout.setTitle(abteilung);
        }

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
//        Glide.with(this).load(Logo).apply(requestOptions).into(img);
        Picasso.get().load(Logo).into(img);





    }
}
