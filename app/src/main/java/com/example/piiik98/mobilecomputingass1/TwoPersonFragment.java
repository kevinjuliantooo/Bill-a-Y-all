package com.example.piiik98.mobilecomputingass1;

import android.content.Intent;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.content.*;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by piiik98 on 24/04/18.
 */

public class TwoPersonFragment extends Fragment {

    private Spinner spinner;
    private TextView totalResult, onePerson, twoPerson, result1, result2;
    private Switch gst_switch, service_switch;
    private double GSTValue_1, GSTValue_2, newGST1, newGST2, ServiceValue1, ServiceValue2;
    private SharedPreferences prefs;
    private Button button;
    private String sign;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.two_person_fragment, container, false);

        //prefs = getActivity().getSharedPreferences("Data", Context.MODE_PRIVATE);

        //int storeGST = prefs.getInt("GST", 0);
        totalResult = rootView.findViewById(R.id.totalResult);
        spinner = rootView.findViewById(R.id.spinner2);
        onePerson = rootView.findViewById(R.id.people1);
        twoPerson = rootView.findViewById(R.id.people2);
        gst_switch = rootView.findViewById(R.id.gst_switch);
        service_switch = rootView.findViewById(R.id.service_switch);
        result1 = rootView.findViewById(R.id.result1);
        result2 = rootView.findViewById(R.id.result2);
        button = rootView.findViewById(R.id.result_button);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.GST, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        onePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onePerson.setText("");

            }
        });

        twoPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoPerson.setText("");

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        GSTValue_1 = -1;
                        GSTValue_2 = -1;
                        sign = "";
                        break;
                    case 1:
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 7 / 100;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 7 / 100;
                        sign = "SGD";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 10 / 100;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 10 / 100;
                        sign = "IDR";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 6 / 100;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 6 / 100;
                        sign = "MYR";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 10 / 100;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 10 / 100;
                        sign = "VND";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 12 / 100;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 12 / 100;
                        sign = "PHP";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 10 / 100;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 10 / 100;
                        sign = "KRW";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 0 / 100;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 0 / 100;
                        sign = "CHY";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 12 / 100;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 12 / 100;
                        sign = "AUD";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        GSTValue_1 = 0;
                        GSTValue_2 = 0;
                        sign = "";
                        break;
                }
                gst_switch.setChecked(false);
                service_switch.setChecked(false);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        gst_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    if (GSTValue_1 == -1 && GSTValue_2 == -1){
                        Toast.makeText(getActivity(), "Please put the GST", Toast.LENGTH_SHORT).show();
                        gst_switch.setChecked(false);
                    } else {
                        newGST1 = GSTValue_1;
                        newGST2 = GSTValue_2;
                    }

                }
                else {
                    newGST1 = 0;
                    newGST2 = 0;
                }
            }
        });

        service_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ServiceValue1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 10 / 100;
                    ServiceValue2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 10 / 100;
                } else {
                    ServiceValue1 = 0;
                    ServiceValue2 = 0;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Result for First Person
                double inputPrice1 = Double.parseDouble(onePerson.getText().toString());
                double total1 = inputPrice1 + newGST1 + ServiceValue1;
                String value1 = Double.toString(total1);
                result1.setText(sign + value1);

                //Result for Second Person
                double inputPrice2 = Double.parseDouble(twoPerson.getText().toString());
                double total2 = inputPrice2 + newGST2 + ServiceValue2;
                String value2 = Double.toString(total2);
                result2.setText(sign + value2);

                //Total All Result
                double alltotal = total1 + total2;
                totalResult.setText(sign + Double.toString(alltotal));

            }
        });


        return rootView;



    }


}
