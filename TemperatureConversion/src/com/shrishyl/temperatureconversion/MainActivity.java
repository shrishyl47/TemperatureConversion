package com.shrishyl.temperatureconversion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText1);
    }

    public void myClickHandler(View view)
    {
    	switch (view.getId()) 
    	{
    		case R.id.button1:
				RadioButton celsiusButton = (RadioButton) findViewById(R.id.radioButton1);
				RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radioButton2);
				if (text.getText().length() == 0) 
				{
					Toast.makeText(this, "Please enter a valid number",Toast.LENGTH_LONG).show();
					return;
				}
				
				float inputValue = Float.parseFloat(text.getText().toString());
				if (celsiusButton.isChecked()) 
				{
					text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
				}
				else
				{
					text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
				}
				break;
    	}
    }

    private float convertFahrenheitToCelsius(float fahrenheit) 
    {
    	return ((fahrenheit - 32) * 5 / 9);
    }
    private float convertCelsiusToFahrenheit(float celsius) 
    {
    	return ((celsius * 9) / 5) + 32;
    }
}