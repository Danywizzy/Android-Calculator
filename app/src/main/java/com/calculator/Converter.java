package com.calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;


public class Converter extends AppCompatActivity {

    Spinner convertFromUnitTypeSpinner;
    Spinner convertToUnitTypeSpinner;

    String[] unitTypes = {"millimetres", "centimetres", "metres", "kilometres", "feet", "yards", "miles"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.primaryDarkColor));

        convertFromUnitTypeSpinner = (Spinner) findViewById(R.id.spinnerfrom);
        convertToUnitTypeSpinner = (Spinner) findViewById(R.id.spinnerto);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, unitTypes);

        convertFromUnitTypeSpinner.setAdapter(spinnerAdapter);
        convertToUnitTypeSpinner.setAdapter(spinnerAdapter);
    }

    public void onClickConvertButtonEvent(View view){

        double beginning_qty;
        double ending_qty;
        String beginning_unit_type;
        String ending_unit_type;

        EditText qtyEditText = (EditText) findViewById(R.id.enter);
        TextView resultOutputTextView = (TextView) findViewById(R.id.result);

        LengthConvert lengthConverter = new LengthConvert();

        if(!qtyEditText.getText().toString().equals("")){

            beginning_qty = Double.parseDouble(qtyEditText.getText().toString());
            beginning_unit_type = convertFromUnitTypeSpinner.getSelectedItem().toString();
            ending_unit_type = convertToUnitTypeSpinner.getSelectedItem().toString();

            lengthConverter.setBeginning_qty(beginning_qty);
            lengthConverter.setFrom_unit(beginning_unit_type);
            lengthConverter.setTo_unit(ending_unit_type);

            ending_qty = lengthConverter.calculateEnding_qty();
            lengthConverter.setEnding_qty(ending_qty);

            resultOutputTextView.setText(lengthConverter.toString());
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Enter Quantity";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
        }
    }
}
