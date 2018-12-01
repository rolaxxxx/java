package com.ulevicius.rolandas.zoosodas;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class UzduociuValdymas extends Fragment implements AdapterView.OnItemSelectedListener {
    View myView;

    public static ArrayList<Uzduotis> uzduotys= new ArrayList<>();
    ArrayList<Darbuotojas>persortintiDarbuotojai=new ArrayList<>();
    ArrayList<Darbuotojas> darbuotojaiUzduotims = new ArrayList<>();
    ArrayList<String> gyvunaiUzduotims = new ArrayList<>();
    Darbuotojas blankWorker=new Darbuotojas();
    EditText ivestaUzduotis;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.third_layout, container, false);
        ivestaUzduotis = (EditText)myView.findViewById(R.id.IvestaUzduotis);
        ivestaUzduotis.setHint("Iveskite uzduoti pasirinktam darbuotojui");
        blankWorker.priskirtaKategorija="";
        blankWorker.vardas="";
        final GyvunaiRepository gyvunaiRepository = new GyvunaiRepository(getActivity().getApplicationContext());
        blankWorker.pavarde="";
        persortintiDarbuotojai.add(0, blankWorker);
        gyvunaiUzduotims.clear();
        gyvunaiUzduotims.add("");
        gyvunaiRepository.ShowGyvunai(gyvunaiUzduotims);

        darbuotojaiUzduotims.addAll(DarbuotojuValdymas.darbuotojai);

        Spinner spinner = myView.findViewById(R.id.specifinisGyvunas);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1,gyvunaiUzduotims);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);


        Spinner spinner2 = myView.findViewById(R.id.SpecifinisDarbuotojas);
        ArrayAdapter<Darbuotojas> adapter2 = new ArrayAdapter<>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, persortintiDarbuotojai );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter2);

        ivestaUzduotis.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    ivestaUzduotis.setHint("");
                else
                    ivestaUzduotis.setHint("Iveskite uzduoti pasirinktam darbuotojui");
            }
        });


        return myView;
    }




        @Override
        public void onItemSelected (final AdapterView < ? > adapterView, View view, final int i, long l){
            String text = adapterView.getItemAtPosition(i).toString();
            Button button = (Button) myView.findViewById(R.id.issaugotiUzduoti);
            Spinner specG = myView.findViewById(R.id.specifinisGyvunas);
            String SpecGyvunas=gyvunaiUzduotims.get(i);
            if(!SpecGyvunas.isEmpty())
            {
                persortintiDarbuotojai.clear();
                persortintiDarbuotojai.add(blankWorker);
                for(Darbuotojas tempDarbuotojas:darbuotojaiUzduotims){
                    if(SpecGyvunas.equals(tempDarbuotojas.priskirtaKategorija))
                        persortintiDarbuotojai.add(tempDarbuotojas);
                }
            }
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Uzduotis tempUzduotis= new Uzduotis();
                    ivestaUzduotis = (EditText)myView.findViewById(R.id.IvestaUzduotis);
                    Spinner specifinisGyvunas = (Spinner)myView.findViewById(R.id.specifinisGyvunas);
                    Spinner specifinisDarbuotojas = (Spinner)myView.findViewById(R.id.SpecifinisDarbuotojas);

                    String IvestaSpecifineUzduotis= ivestaUzduotis.getText().toString();
                    String getSpecifinisGyvunas= specifinisGyvunas.getSelectedItem().toString();
                    String getSpecifinisDarbuotojas= specifinisDarbuotojas.getSelectedItem().toString();

                    tempUzduotis.tekstas=IvestaSpecifineUzduotis;
                    tempUzduotis.specifinisGyvunas=getSpecifinisGyvunas;
                    tempUzduotis.priskirtasDarbuotojas=getSpecifinisDarbuotojas;
                    uzduotys.add(tempUzduotis);
                    Toast.makeText(getActivity().getBaseContext(), "Uzduotis issaugota " , Toast.LENGTH_LONG).show();

                }
            });

        }

    @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

        }

    }

