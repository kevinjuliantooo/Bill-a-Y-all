package com.example.piiik98.mobilecomputingass1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class PersonActivity extends AppCompatActivity {
    EditText realPriceText;
    TextView result;
    Switch GST, Service;
    Button button;
    Spinner spinner;
    double GSTValue, ServiceValue, fee, newGSTValue;
    String sign, stringPercentageFee;
    int percentageFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        realPriceText = findViewById(R.id.normalPrice);
        GST = findViewById(R.id.gstSwitch);
        Service = findViewById(R.id.serviceSwitch);
        result = findViewById(R.id.resultText);
        button = (Button) findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.GST, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        realPriceText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realPriceText.setText("");
                GST.setChecked(false);
                Service.setChecked(false);

            }
        });

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                switch (i) {
                    case 0:
                        GSTValue = -1;
                        sign = "";
                        break;
                    case 1:
                        sign = "SGD";
                        //fee = 7 / 100;
                        GST.setText("GST Tax 7%");
                        GSTValue = Double.parseDouble(String.valueOf(realPriceText.getText())) * 7/100;
                        Toast.makeText(getBaseContext(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        sign = "IDR";
                        //fee = 10 / 100;
                        GSTValue = Double.parseDouble(String.valueOf(realPriceText.getText())) * 10/100;
                        GST.setText("GST Tax 10%");
                        Toast.makeText(getBaseContext(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        sign = "MYR";
                        //fee = 6 / 100;
                        GSTValue = Double.parseDouble(String.valueOf(realPriceText.getText())) * 6/100;
                        GST.setText("GST Tax 6%");
                        Toast.makeText(getBaseContext(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        sign = "VND";
                        //fee = 10 / 100;
                        GSTValue = Double.parseDouble(String.valueOf(realPriceText.getText())) * 10/100;
                        GST.setText("GST Tax 10%");
                        Toast.makeText(getBaseContext(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        sign = "PHP";
                        //fee = 12/100;
                        GSTValue = Double.parseDouble(String.valueOf(realPriceText.getText())) * 12/100;
                        GST.setText("GST Tax 12%");
                        Toast.makeText(getBaseContext(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        sign = "KRW";
                        //fee = 10 / 100;
                        GSTValue = Double.parseDouble(String.valueOf(realPriceText.getText())) * 10/100;
                        GST.setText("GST Tax 10%");
                        Toast.makeText(getBaseContext(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        sign = "CHY";
                        fee = 0;
                        GSTValue = Double.parseDouble(String.valueOf(realPriceText.getText())) * 0;
                        GST.setText("GST Tax 0%");
                        Toast.makeText(getBaseContext(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        sign = "AUD";
                        fee = 12/100;
                        GSTValue = Double.parseDouble(String.valueOf(realPriceText.getText())) * 12/100;
                        GST.setText("GST Tax 12%");
                        Toast.makeText(getBaseContext(), sign + " Choosen", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        fee = 0;
                        sign = "";
                        GST.setText("GST Tax 0%");
                        break;
                }
                GST.setChecked(false);
                Service.setChecked(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        GST.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    if (GSTValue == -1 ){
                        Toast.makeText(getBaseContext(), "Please put the GST", Toast.LENGTH_SHORT).show();
                        GST.setChecked(false);
                    } else {
                        newGSTValue = GSTValue;
                    }
                }
                else {
                    newGSTValue = 0;
                }
            }
        });


        Service.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    if (realPriceText.equals("0")){
                        result.setText("you forgot put the number");
                    } else {
                        ServiceValue = Double.parseDouble(String.valueOf(realPriceText.getText())) * 10 / 100;
                    }
                } else {
                    ServiceValue = 0;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GSTValue < 0){
                    Toast.makeText(getBaseContext(), "Please put the GST", Toast.LENGTH_LONG).show();
                } else {
                    double inputPrice = Double.parseDouble(realPriceText.getText().toString());
                    double total = inputPrice + newGSTValue + ServiceValue;
                    String value = Double.toString(total);
                    result.setText(sign+ " " + value);

                    }
                }

        });
    }
}
