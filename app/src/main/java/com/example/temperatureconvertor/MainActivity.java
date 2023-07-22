package com.example.temperatureconvertor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber;
    TextView textView,textView2,textView3,textView4,textView5,textView6;
    Button button,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final boolean[] convert = {false};

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        editTextNumber = findViewById(R.id.editTextNumber);
        button =findViewById(R.id.button);
        button2 =findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            convert[0] = !convert[0];
            if(convert[0]){
                FahrenheitToCelsius();
            }
            else{
                CelsiusToFahrenheit();
            }
        });
        button.setOnClickListener(v -> ConvertTemperature(convert[0]));
        editTextNumber.setOnClickListener(v -> {
            textView4.setText("");
            editTextNumber.setText("");
            editTextNumber.setCursorVisible(true);

        });

        editTextNumber.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // do your stuff here
                ConvertTemperature(convert[0]);
                editTextNumber.setCursorVisible(false);
            }
            return false;
        });
    }

    @SuppressLint("SetTextI18n")
    private void CelsiusToFahrenheit() {
        textView2.setText("Enter Your Temperature in Celsius");
        textView3.setText("Fahrenheit");
        button.setText("Convert To Fahrenheit");
        textView4.setText("");
        editTextNumber.setText("");
        textView6.setText("°C");
        textView5.setText("°F");
        editTextNumber.setCursorVisible(false);
    }

    @SuppressLint("SetTextI18n")
    private void FahrenheitToCelsius() {
        textView2.setText("Enter Your Temperature in Fahrenheit");
        textView3.setText("Celsius");
        button.setText("Convert To Celsius");
        textView4.setText("");
        editTextNumber.setText("");
        textView6.setText("°F");
        textView5.setText("°C");
        editTextNumber.setCursorVisible(false);
    }

    @SuppressLint("SetTextI18n")
    private void ConvertTemperature(boolean convert) {
        String valueEnteredinCelsius = editTextNumber.getText().toString();
        if(!convert) {
            if(valueEnteredinCelsius.equals("") || valueEnteredinCelsius.isEmpty()){
                Toast.makeText(getApplicationContext(), "Invalid Temperature", Toast.LENGTH_SHORT).show();
            }
            else {
                double Celsius = Double.parseDouble(valueEnteredinCelsius);
                double Fahrenheit = (Celsius * 9) / 5 + 32;
                editTextNumber.setText(String.format(Locale.US, "%.2f", Celsius));
                textView4.setText(String.format(Locale.US, "%.2f", Fahrenheit));
                editTextNumber.setCursorVisible(false);
            }
        }
        else{
            if(valueEnteredinCelsius.equals("") || valueEnteredinCelsius.isEmpty() ){
                Toast.makeText(getApplicationContext(), "Invalid Temperature", Toast.LENGTH_SHORT).show();
            }
            else {
                double Fahrenheit = Double.parseDouble(valueEnteredinCelsius);
                double Celsius = (Fahrenheit - 32) * 5 / 9;
                editTextNumber.setText(String.format(Locale.US, "%.2f", Fahrenheit));
                textView4.setText(String.format(Locale.US, "%.2f", Celsius));
                editTextNumber.setCursorVisible(false);
            }
        }
    }
}