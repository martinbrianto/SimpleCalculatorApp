package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText val1, val2;
    TextView result;
    Button calculate;

    float result_num;
    int num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.calculation));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

       result = (TextView)findViewById(R.id.result);
       val1 = (EditText)findViewById(R.id.number1);
       val2 = (EditText)findViewById(R.id.number2);
       calculate = (Button)findViewById(R.id.calculate);

       calculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               if(mySpinner.getSelectedItem().toString().equals("Add")){
                   num1 = Integer.parseInt(val1.getText().toString());
                   num2 = Integer.parseInt(val2.getText().toString());

                   result_num = num1 + num2;
                   result.setText(String.valueOf(result_num));


               }else if (mySpinner.getSelectedItem().toString().equals("Substract")){
                   num1 = Integer.parseInt(val1.getText().toString());
                   num2 = Integer.parseInt(val2.getText().toString());

                   result_num = num1 - num2;
                   result.setText(String.valueOf(result_num));

               }else if (mySpinner.getSelectedItem().toString().equals("Multiply")){
                   num1 = Integer.parseInt(val1.getText().toString());
                   num2 = Integer.parseInt(val2.getText().toString());

                   result_num = num1 * num2;
                   result.setText(String.valueOf(result_num));
               }

               else if (mySpinner.getSelectedItem().toString().equals("Divide")){
                   num1 = Integer.parseInt(val1.getText().toString());
                   num2 = Integer.parseInt(val2.getText().toString());
                   if(num2 == 0){
                       result.setText("Error");
                   }
                    else {
                       result_num = (float)num1 / num2;
                       result.setText(String.valueOf(result_num));
                   }
               }

           }
       });



    }
}

