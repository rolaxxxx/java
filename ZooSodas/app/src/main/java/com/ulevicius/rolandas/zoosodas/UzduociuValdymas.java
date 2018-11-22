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
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class UzduociuValdymas extends Fragment implements AdapterView.OnItemSelectedListener {
    View myView;
    ArrayList<Uzduotis> uzduotys= new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.third_layout, container, false);
        ArrayList<String> gyvunaiUzduotims = new ArrayList<>();

        gyvunaiUzduotims.addAll(GyvunuValdymas.gyvunai);
        ArrayList<Darbuotojas> darbuotojaiUzduotims = new ArrayList<>();
        darbuotojaiUzduotims.addAll(DarbuotojuValdymas.darbuotojai);

        Spinner spinner = myView.findViewById(R.id.specifinisGyvunas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1,gyvunaiUzduotims);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);

        Spinner spinner2 = myView.findViewById(R.id.SpecifinisDarbuotojas);
        ArrayAdapter<Darbuotojas> adapter2 = new ArrayAdapter<>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1,darbuotojaiUzduotims );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter2);


        return myView;
    }





        public void onItemSelected (final AdapterView < ? > adapterView, View view, final int i, long l){
            String text = adapterView.getItemAtPosition(i).toString();
            Button button = (Button) myView.findViewById(R.id.Idarbinti_Darbuotoja);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Uzduotis tempUzduotis= new Uzduotis();
                    EditText ivestaUzduotis = (EditText)myView.findViewById(R.id.IvestaUzduotis);
                    Spinner specifinisGyvunas = (Spinner)myView.findViewById(R.id.specifinisGyvunas);
                    Spinner specifinisDarbuotojas = (Spinner)myView.findViewById(R.id.SpecifinisDarbuotojas);

                    String IvestaSpecifineUzduotis= ivestaUzduotis.getText().toString();
                    String getSpecifinisGyvunas= GyvunuValdymas.gyvunai.get(i);
                    String getSpecifinisDarbuotojas= DarbuotojuValdymas.darbuotojai.get(i).vardas;

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

