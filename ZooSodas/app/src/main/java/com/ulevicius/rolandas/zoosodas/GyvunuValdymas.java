package com.ulevicius.rolandas.zoosodas;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GyvunuValdymas extends Fragment implements AdapterView.OnItemSelectedListener, Serializable {
    View myView;
    public static ArrayList<String> gyvunai= new ArrayList<>();
    public ArrayList<String> getGyvunai() {
        return gyvunai;
    }
    EditText txt;

    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_layout, container, false);
        button = (Button) myView.findViewById(R.id.ikeltiGyvuna);
        txt = (EditText)myView.findViewById(R.id.gyvuno_kategorija);
        txt.setHint("Ivesti gyvunu kategorija");

        gyvunai.add("");
        txt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    txt.setHint("");
                else
                    txt.setHint("Ivesti gyvunu kategorija");
            }
        });
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String getInput= txt.getText().toString();
                gyvunai.add(getInput);
                Toast.makeText(getActivity().getApplicationContext(), "gyvunas ikeltas " + gyvunai.size(), Toast.LENGTH_LONG).show();
            }
        });

        Spinner spinner2 = myView.findViewById(R.id.GyvunuKategorijosIskelimui);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, gyvunai);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);


        return myView;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, final int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Button button = (Button) myView.findViewById(R.id.iskeltiGyvuna);
//        Toast.makeText(adapterView.getContext(), "pasirinktas gyvunas " + text, Toast.LENGTH_SHORT).show();
        final CheckBox checkBox= (CheckBox) myView.findViewById(R.id.pasirinkimoPatvirtinimas);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    gyvunai.remove(i);
                    Toast.makeText(getActivity().getBaseContext(), "istrintas gyvunas ", Toast.LENGTH_LONG).show();

                }
                else Toast.makeText(getActivity().getBaseContext(), "patvirtinimo varnele nepazymeta ", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
