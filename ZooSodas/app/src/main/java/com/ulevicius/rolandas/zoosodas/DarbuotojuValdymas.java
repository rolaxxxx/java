package com.ulevicius.rolandas.zoosodas;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DarbuotojuValdymas extends Fragment  implements AdapterView.OnItemSelectedListener {
    View myView;
    public static  ArrayList<Darbuotojas> darbuotojai= new ArrayList<>();
    Darbuotojas temporDarb=new Darbuotojas();
    EditText vardas;
    ArrayList<String> gyvunaikategorijai = new ArrayList<>();
    EditText pavarde;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout, container, false);
         vardas= (EditText)myView.findViewById(R.id.DarbuotojoVardas);
         pavarde = (EditText)myView.findViewById(R.id.DarbuotojoPavarde);
         vardas.setHint("Iveskite Vartotojo varda");
         pavarde.setHint("Iveskite Vartotojo pavarde");
        final GyvunaiRepository gyvunaiRepository = new GyvunaiRepository(getActivity().getApplicationContext());
         temporDarb.vardas="";
         temporDarb.pavarde="";
         temporDarb.priskirtaKategorija="";
        darbuotojai.add(0,temporDarb);
        gyvunaikategorijai.clear();
        gyvunaikategorijai.add("");
         gyvunaiRepository.ShowGyvunai(gyvunaikategorijai);

        vardas.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    vardas.setHint("");
                else
                    vardas.setHint("Iveskite Vartotojo varda");
            }
        });
        pavarde.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    pavarde.setHint("");
                else
                    pavarde.setHint("Iveskite Vartotojo pavarde");
            }
        });
            Spinner spinner = myView.findViewById(R.id.GyvunuKategorijosDarbuotojuKlaseje);
            ArrayAdapter adapter = new ArrayAdapter<>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, gyvunaikategorijai);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(adapter);


        return myView;

    }

    @Override
    public void onItemSelected (AdapterView < ? > adapterView, View view, final int i, long l ){
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), "pasirinktas itemas " + text, Toast.LENGTH_SHORT).show();
        Button button = (Button) myView.findViewById(R.id.Idarbinti_Darbuotoja);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Darbuotojas tempdarbuotojas= new Darbuotojas();
                 vardas = (EditText)myView.findViewById(R.id.DarbuotojoVardas);
                 pavarde = (EditText)myView.findViewById(R.id.DarbuotojoPavarde);
                String getVardas= vardas.getText().toString();
                String getPavarde= pavarde.getText().toString();
                String getKategorija= gyvunaikategorijai.get(i).toString();
                tempdarbuotojas.vardas=getVardas;
                tempdarbuotojas.pavarde=getPavarde;
                tempdarbuotojas.priskirtaKategorija=getKategorija;
                darbuotojai.add(tempdarbuotojas);
                Toast.makeText(getActivity().getBaseContext(), "Darbuotojas idarbintas " , Toast.LENGTH_LONG).show();
            }
        });



    }

    @Override
    public void onNothingSelected (AdapterView < ? > adapterView){

    }
}
