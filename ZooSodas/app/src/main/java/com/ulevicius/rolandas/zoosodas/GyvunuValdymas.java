package com.ulevicius.rolandas.zoosodas;

import android.app.Fragment;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.provider.ContactsContract;
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
    public static ArrayList<String> gyvunaiVald= new ArrayList<>();

    EditText txt,txt2;

    Gyvunas blankGyvunas= new Gyvunas();




    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_layout, container, false);
        button = (Button) myView.findViewById(R.id.ikeltiGyvuna);
        txt = (EditText)myView.findViewById(R.id.gyvuno_kategorija);
        txt2=(EditText)myView.findViewById(R.id.gyvuno_rusis);
        final GyvunaiRepository gyvunaiRepository = new GyvunaiRepository(getActivity().getApplicationContext());
            //gyvunaiRepository.deleteAll(); // kaskart vis istrinu itemus gali buti problemu kai padarysiu kitus view su gyvunais
        txt.setHint("Ivesti gyvunu kategorija");
        txt2.setHint("Ivesti gyvunu rusi");
        gyvunaiVald.add("");
        gyvunaiRepository.ShowGyvunai(gyvunaiVald);
        //blankGyvunas.kategorija="";
       // blankGyvunas.rusis="";

        txt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    txt.setHint("");
                else
                    txt.setHint("Ivesti gyvunu kategorija");
            }
        });
        txt2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    txt2.setHint("");
                else
                    txt2.setHint("Ivesti gyvunu rusi");
            }
        });
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Gyvunas tempGyvunas = new Gyvunas();
                String getInput= txt.getText().toString();
                String getInput2= txt2.getText().toString();
                tempGyvunas.kategorija=getInput;
                tempGyvunas.rusis=getInput2;
                gyvunaiRepository.insertGyvunas(tempGyvunas);
                gyvunaiVald.clear();
                gyvunaiRepository.ShowGyvunai(gyvunaiVald);
                Toast.makeText(getActivity().getApplicationContext(), "gyvunas ikeltas " + gyvunaiVald.size(), Toast.LENGTH_LONG).show();
            }
        });



        Spinner spinner2 = myView.findViewById(R.id.GyvunuKategorijosIskelimui);
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, gyvunaiVald);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);


        return myView;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, final int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Button button = (Button) myView.findViewById(R.id.iskeltiGyvuna);
        final GyvunaiRepository gyvunaiRepository = new GyvunaiRepository(getActivity().getApplicationContext());
//        Toast.makeText(adapterView.getContext(), "pasirinktas gyvunas " + text, Toast.LENGTH_SHORT).show();
        final CheckBox checkBox= (CheckBox) myView.findViewById(R.id.pasirinkimoPatvirtinimas);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    gyvunaiRepository.deleteOne(i);
                    gyvunaiVald.clear();
                    gyvunaiRepository.ShowGyvunai(gyvunaiVald);
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
