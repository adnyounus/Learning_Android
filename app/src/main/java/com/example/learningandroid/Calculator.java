package com.example.learningandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import javax.script.ScriptException;
public class Calculator extends AppCompatActivity {
    private Button btn0, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    private Button btnMinus,btnPlus,btnEqual,btnMultiply,btnDivide,btnClear,btnMod,btnFact;
    private TextView txtResult, txtHistory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        btn0= findViewById(R.id.num_0);
        btn1= findViewById(R.id.num_1);
        btn2=findViewById(R.id.num_2);
        btn3=findViewById(R.id.num_3);
        btn4= findViewById(R.id.num_4);
        btn5= findViewById(R.id.num_5);
        btn6=findViewById(R.id.num_6);
        btn7=findViewById(R.id.num_7);
        btn8= findViewById(R.id.num_8);
        btn9= findViewById(R.id.num_9);

        btnMinus=findViewById(R.id.btn_minus);
        btnPlus=findViewById(R.id.btn_plus);
        btnEqual=findViewById(R.id.btn_equal);
        btnClear=findViewById(R.id.btn_clr);
        btnDivide=findViewById(R.id.btn_divide);
        btnMultiply=findViewById(R.id.btn_multiple);
        btnMod=findViewById(R.id.btn_mod);
        btnFact=findViewById(R.id.btn_fact);

        txtResult=findViewById(R.id.txt_result);
        txtHistory=findViewById(R.id.txt_history);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    txtHistory.setText("");
                    txtResult.setText("");

            }
        });


    }

    public void result_calculation(View v) throws ScriptException {
        Button button= (Button) v;

        String txt_main = txtResult.getText().toString();
        Expression e = new Expression(txt_main);
        double res= e.calculate();
        String result = String.valueOf(res);


        if( Double.isNaN(res) ){
            Toast.makeText(this, "Invalid Expression!", Toast.LENGTH_SHORT).show();
        }
        else {

            txtHistory.setText(txt_main);

            txtResult.setText(result);
        }


    }

    public void numberOperation(View v){
        Button button= (Button) v;
        String oper = button.getText().toString();
        if (oper.equals("mod")){
            txtResult.setText(txtResult.getText().toString()+"#");
        }
        else if (oper.equals("X")){
            txtResult.setText(txtResult.getText().toString()+"*");
        }
        else
        txtResult.setText(txtResult.getText().toString()+oper);
    }
}