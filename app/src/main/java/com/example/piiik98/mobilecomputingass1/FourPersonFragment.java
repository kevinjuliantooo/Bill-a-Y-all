package com.example.piiik98.mobilecomputingass1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by piiik98 on 24/04/18.
 */

public class FourPersonFragment extends Fragment {


    private Spinner spinner;
    private TextView totalResult, onePerson, twoPerson, threePerson, fourPerson, result1, result2, result3, result4;
    private Switch gst_switch, service_switch;
    private double GSTValue_1, GSTValue_2, GSTValue_3, GSTValue_4, newGST1, newGST2, newGST3, newGST4, ServiceValue1, ServiceValue2, ServiceValue3, ServiceValue4, gst_percent;
    private SharedPreferences prefs;
    private Button button;
    private String sign;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.four_person_fragment, container, false);

        //prefs = getActivity().getSharedPreferences("Data", Context.MODE_PRIVATE);

        //int storeGST = prefs.getInt("GST", 0);
        totalResult = rootView.findViewById(R.id.totalResult);
        spinner = rootView.findViewById(R.id.spinner2);
        onePerson = rootView.findViewById(R.id.people1);
        twoPerson = rootView.findViewById(R.id.people2);
        threePerson = rootView.findViewById(R.id.people3);
        fourPerson = rootView.findViewById(R.id.people4);
        gst_switch = rootView.findViewById(R.id.gst_switch);
        service_switch = rootView.findViewById(R.id.service_switch);
        result1 = rootView.findViewById(R.id.result1);
        result2 = rootView.findViewById(R.id.result2);
        result3 = rootView.findViewById(R.id.result3);
        result4 = rootView.findViewById(R.id.result4);
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

        threePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threePerson.setText("");

            }
        });

        fourPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourPerson.setText("");

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        GSTValue_1 = -1;
                        GSTValue_2 = -1;
                        GSTValue_3 = -1;
                        GSTValue_4 = -1;
                        sign = "";
                        break;
                    case 1:
                        gst_percent = 7 / 100;
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * gst_percent;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * gst_percent;
                        GSTValue_3 = Double.parseDouble(String.valueOf(threePerson.getText())) * gst_percent;
                        GSTValue_4 = Double.parseDouble(String.valueOf(fourPerson.getText())) * gst_percent;
                        sign = "SGD";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        gst_percent = 10 / 100;
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * gst_percent;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * gst_percent;
                        GSTValue_3 = Double.parseDouble(String.valueOf(threePerson.getText())) * gst_percent;
                        GSTValue_4 = Double.parseDouble(String.valueOf(fourPerson.getText())) * gst_percent;
                        sign = "IDR";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        gst_percent = 6 / 100;
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * gst_percent;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * gst_percent;
                        GSTValue_3 = Double.parseDouble(String.valueOf(threePerson.getText())) * gst_percent;
                        GSTValue_4 = Double.parseDouble(String.valueOf(fourPerson.getText())) * gst_percent;
                        sign = "MYR";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        gst_percent = 10 / 100;
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * gst_percent;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * gst_percent;
                        GSTValue_3 = Double.parseDouble(String.valueOf(threePerson.getText())) * gst_percent;
                        GSTValue_4 = Double.parseDouble(String.valueOf(fourPerson.getText())) * gst_percent;
                        sign = "VND";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        gst_percent = 12 / 100;
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * gst_percent;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * gst_percent;
                        GSTValue_3 = Double.parseDouble(String.valueOf(threePerson.getText())) * gst_percent;
                        GSTValue_4 = Double.parseDouble(String.valueOf(fourPerson.getText())) * gst_percent;
                        sign = "PHP";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        gst_percent = 10 / 100;
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * gst_percent;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * gst_percent;
                        GSTValue_3 = Double.parseDouble(String.valueOf(threePerson.getText())) * gst_percent;
                        GSTValue_4 = Double.parseDouble(String.valueOf(fourPerson.getText())) * gst_percent;
                        sign = "KRW";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        gst_percent = 0 / 100;
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * gst_percent;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * gst_percent;
                        GSTValue_3 = Double.parseDouble(String.valueOf(threePerson.getText())) * gst_percent;
                        GSTValue_4 = Double.parseDouble(String.valueOf(fourPerson.getText())) * gst_percent;
                        sign = "CHY";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        gst_percent = 12 / 100;
                        GSTValue_1 = Double.parseDouble(String.valueOf(onePerson.getText())) * gst_percent;
                        GSTValue_2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * gst_percent;
                        GSTValue_3 = Double.parseDouble(String.valueOf(threePerson.getText())) * gst_percent;
                        GSTValue_4 = Double.parseDouble(String.valueOf(fourPerson.getText())) * gst_percent;
                        sign = "AUD";
                        Toast.makeText(getActivity(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        GSTValue_1 = -1;
                        GSTValue_2 = -1;
                        GSTValue_3 = -1;
                        GSTValue_4 = -1;
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
                if (b) {
                    if (GSTValue_1 == -1) {
                        Toast.makeText(getActivity(), "Please put the GST", Toast.LENGTH_SHORT).show();
                        gst_switch.setChecked(false);
                    } else {
                        newGST1 = GSTValue_1;
                        newGST2 = GSTValue_2;
                        newGST3 = GSTValue_3;
                        newGST4 = GSTValue_4;
                    }

                } else {
                    newGST1 = 0;
                    newGST2 = 0;
                    newGST3 = 0;
                    newGST4 = 0;
                }
            }
        });

        service_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ServiceValue1 = Double.parseDouble(String.valueOf(onePerson.getText())) * 10 / 100;
                    ServiceValue2 = Double.parseDouble(String.valueOf(twoPerson.getText())) * 10 / 100;
                    ServiceValue3 = Double.parseDouble(String.valueOf(threePerson.getText())) * 10 / 100;
                    ServiceValue4 = Double.parseDouble(String.valueOf(fourPerson.getText())) * 10 / 100;
                } else {
                    ServiceValue1 = 0;
                    ServiceValue2 = 0;
                    ServiceValue3 = 0;
                    ServiceValue4 = 0;
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

                //Result for Third Person
                double inputPrice3 = Double.parseDouble(threePerson.getText().toString());
                double total3 = inputPrice3 + newGST3 + ServiceValue3;
                String value3 = Double.toString(total3);
                result3.setText(sign + value3);

                //Result for Fourth Person
                double inputPrice4 = Double.parseDouble(fourPerson.getText().toString());
                double total4 = inputPrice4 + newGST4 + ServiceValue4;
                String value4 = Double.toString(total4);
                result4.setText(sign + value4);


                //Total All Result
                double alltotal = total1 + total2 + total3 + total4;
                totalResult.setText(sign + Double.toString(alltotal));

            }
        });


        return rootView;

    }
}
