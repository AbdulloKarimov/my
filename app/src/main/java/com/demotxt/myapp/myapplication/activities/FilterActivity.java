package com.demotxt.myapp.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.demotxt.myapp.myapplication.R;

public class FilterActivity extends AppCompatActivity {
    public static final String[] arten = {"Alle",
            "Stelle",
            "Nebenjob/+Ferienjob",
            "Ausbildungsstelle",
            "Studienplatz/+Werkstudent",
            "Praktikum/+Referendariat",
            "Abschlussarbeit"};

    public static final String[] bundeslands = {"Alle",
            "Bayern",
            "Berlin", "Hamburg",
            "Rheinland-Pfalz",
            "Saarland", "Sachsen",
            "Thüringen",
            "Deutschland",
            "Ausland"};

    public static final String[] berufsfelder = {"Alle",
            "Beratung+&+Consulting",
            "Elektronik,+Elektrotechnik",
            "Geisteswissenschaften,+Sprachen",
            "Informatik",
            "Ingenieurswissenschaften",
            "IT+&+Telekommunikation",
            "Kunst,+Kultur,+Gestaltung",
            "Landwirtschaft,+Natur,+Umwelt",
            "Medien+&+Unterhaltung"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        inizialisation();
    }

    public void inizialisation() {
        final Spinner spinner = (Spinner) findViewById(R.id.spinerbundesland);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinerarten);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinerberufsfelder);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bundeslands);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arten);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, berufsfelder);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        Button btn_go = (Button) findViewById(R.id.btn_filter);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FilterActivity.this, InfoFilterActivity.class);
                intent.putExtra("bundesland", spinner.getSelectedItem().toString());
                intent.putExtra("arten", spinner2.getSelectedItem().toString());
                intent.putExtra("berufsfelder", spinner3.getSelectedItem().toString());

                startActivity(intent);
            }
        });


    }
}
