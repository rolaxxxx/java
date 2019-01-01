package com.ulevicius.rolandas.zoosodas;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.INVISIBLE;

public class UzduociuRodymas extends Fragment implements AdapterView.OnItemSelectedListener {
    View myView;
    int index=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fourth_layout, container, false);

        for(final Uzduotis uzduotis: UzduociuValdymas.uzduotys) {
            LayoutInflater in = (LayoutInflater) myView.getContext().getSystemService(myView.getContext().LAYOUT_INFLATER_SERVICE);
            View view = in.inflate(R.layout.row_layout, null);
            LinearLayout sc = (LinearLayout) myView.findViewById(R.id.InflUzduotys);
            final TextView darbuotojas2 = (TextView) view.findViewById(R.id.Darbuotojas);
            darbuotojas2.setId(index+1);
            darbuotojas2.setText(uzduotis.priskirtasDarbuotojas);
            final TextView UzduotisInfl = (TextView) view.findViewById(R.id.Uzduotis);
            UzduotisInfl.setId(index+1);
            UzduotisInfl.setText(uzduotis.tekstas);
            final Button btn = view.findViewById(R.id.patvirtintiUzduoti);
            final Button btn2 = view.findViewById(R.id.AtmestiUzduoti);
            btn.setId(index+1);
            btn2.setId(index+1);
            btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    UzduociuValdymas.uzduotys.remove(index-1);
                    btn.setVisibility(INVISIBLE);
                    btn2.setVisibility(INVISIBLE);
                    darbuotojas2.setVisibility(INVISIBLE);
                    UzduotisInfl.setVisibility(INVISIBLE);
                    index--;
                }
            });
            index++;
            btn.setText("Patvirtinti Uzduoti");
            btn2.setText("Istrinti uzduoti");
            sc.addView(view);

        }
        return myView;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
