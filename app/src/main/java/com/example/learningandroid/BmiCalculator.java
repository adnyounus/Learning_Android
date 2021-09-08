package com.example.learningandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Formatter;

public class BmiCalculator extends AppCompatActivity implements View.OnClickListener {
    private Button buttonGo;
    private EditText heightVal, weightVal;
    private TextView resultNum, resultTxt;
    private ImageView imageBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        heightVal= findViewById(R.id.height_val);
        weightVal= findViewById(R.id.weight_val);
        buttonGo= findViewById(R.id.button_go);
        resultNum= findViewById(R.id.result_num);
        resultTxt= findViewById(R.id.result_txt);
        imageBmi= findViewById(R.id.image_bmi);

        buttonGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if( (heightVal.getText().toString().length() > 0) && (weightVal.getText().toString().length() > 0)){

            double weight = Double.parseDouble(weightVal.getText().toString());
            double height = Double.parseDouble(heightVal.getText().toString());
            if( weight > 0.00 && height > 0.00 ){
                double result_bmi = weight/(height*height);
                Formatter formatter = new Formatter();
                formatter.format("%.2f", result_bmi);
                resultNum.setText("Your BMI is "+ formatter.toString());

                if( result_bmi <= 18.50 ){
                    resultTxt.setText("You are Underweight!");
                    imageBmi.setImageResource(R.drawable.skinny);
                }
                else if( result_bmi > 18.50 && result_bmi < 25.00 ){
                    resultTxt.setText("Your BMI is in Normal Range!");
                    imageBmi.setImageResource(R.drawable.strong);
                }
                else{
                    resultTxt.setText("You are Overweight!");
                    imageBmi.setImageResource(R.drawable.fat);
                }
            }
            else{
                Toast.makeText(this, "Height/Weight cannot be 0", Toast.LENGTH_SHORT).show();
            }



        }
        else {
            Toast.makeText(this, "Enter weight/height value first!", Toast.LENGTH_SHORT).show();
        }

    }
}