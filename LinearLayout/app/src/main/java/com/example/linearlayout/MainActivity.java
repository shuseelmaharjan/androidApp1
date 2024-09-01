package com.example.linearlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvDisplay;
    private String currentNumber = "";
    private String firstOperand = "";
    private String operand = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.tvDisplay);

        View.OnClickListener numberClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                if(isNewOperation){
                    currentNumber = "";
                    isNewOperation = false;
                }
                currentNumber += btn.getText().toString();
                tvDisplay.setText(currentNumber);
            }
        };
        findViewById(R.id.btn0).setOnClickListener(numberClickListner);
        findViewById(R.id.btn1).setOnClickListener(numberClickListner);
        findViewById(R.id.btn2).setOnClickListener(numberClickListner);
        findViewById(R.id.btn3).setOnClickListener(numberClickListner);
        findViewById(R.id.btn4).setOnClickListener(numberClickListner);
        findViewById(R.id.btn5).setOnClickListener(numberClickListner);
        findViewById(R.id.btn6).setOnClickListener(numberClickListner);
        findViewById(R.id.btn7).setOnClickListener(numberClickListner);
        findViewById(R.id.btn8).setOnClickListener(numberClickListner);
        findViewById(R.id.btn9).setOnClickListener(numberClickListner);
        findViewById(R.id.btnDot).setOnClickListener(numberClickListner);

        View.OnClickListener operatorClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                if(!currentNumber.equals("")){
                    firstOperand = currentNumber;
                    operand = btn.getText().toString();
                    isNewOperation = true;
                }
            }
        };
        findViewById(R.id.btnAdd).setOnClickListener(numberClickListner);
        findViewById(R.id.btnSubtract).setOnClickListener(numberClickListner);
        findViewById(R.id.btnDivide).setOnClickListener(numberClickListner);
        findViewById(R.id.btnMultiply).setOnClickListener(numberClickListner);

        findViewById(R.id.btnEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!firstOperand.equals("") && !currentNumber.equals("")){
                    double result = 0.0;
                    double num1 = Double.parseDouble(firstOperand);
                    double num2 = Double.parseDouble(currentNumber);

                    switch (operand) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                tvDisplay.setText("Error");
                                return;
                            }
                            break;
                    }
                    tvDisplay.setText(String.valueOf(result));
                    currentNumber = String.valueOf(result);
                    isNewOperation = true;
                }
            }
        });
    }
}
