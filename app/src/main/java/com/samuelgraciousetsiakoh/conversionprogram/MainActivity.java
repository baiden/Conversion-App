package com.samuelgraciousetsiakoh.conversionprogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //Variables to handle the various widgets
    private TextView valueTextView;
    private TextView displayTextView;
    private RadioGroup radioAction;
    private EditText valueEditText;


    //Creating the object for value formatting
    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();
    private static final DecimalFormat number = new DecimalFormat("##.0000");


    //Input value variable
    private double distance = 0.0;
    //private double emMan = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Getting references to the various widgets
        valueTextView = (TextView) findViewById(R.id.valueTextView);
        valueEditText = (EditText)findViewById(R.id.valueEditText);
        displayTextView = (TextView) findViewById(R.id.displayTextView);
        radioAction = (RadioGroup) findViewById(R.id.radioAction);
        valueEditText.addTextChangedListener(valueEditTextWatcher);

        //radio group text listener
        radioAction.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton listen = (RadioButton) group.findViewById(checkedId);

                switch (listen.getId()){
                    case R.id. kiloRadioButton:
                        showKilo();
                        break;
                    case R.id.inchRadioButton:
                        showInches();
                        break;
                    case R.id.feetRadioButton:
                        showFeet();
                        break;

                }
            }
        });

    }

    public void showInches() {
        double inches = distance * 39.37;
        displayTextView.setText(number.format(inches));
    }

    public void showFeet() {
        double feet = distance * 3.281;
        displayTextView.setText(number.format(feet));
    }

    public void showKilo() {
        double kilo = distance * 0.001;
        displayTextView.setText(number.format(kilo));
    }

    private final TextWatcher valueEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            try {
                //Toast.makeText(MainActivity.this, "A change occurred", Toast.LENGTH_SHORT);
                distance = Double.parseDouble(charSequence.toString());
                valueTextView.setText(number.format(distance));
            } catch (NumberFormatException e) {
                valueTextView.setText("");
                distance = 0.0;
               // Toast.makeText(MainActivity.this, "Warning! Error!", Toast.LENGTH_SHORT);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };



}

