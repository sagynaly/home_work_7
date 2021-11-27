package com.example.homework_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String operation;
    TextView tv_result;
    Integer firstValue, secondValue;
    Boolean success = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = findViewById(R.id.result);


    }

    public void onClickNumber(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                textNumber("1");
                break;
            case R.id.btn_two:
                textNumber("2");
                break;
            case R.id.btn_three:
                textNumber("3");
                break;
            case R.id.btn_four:
                textNumber("4");
                break;
            case R.id.btn_five:
                textNumber("5");
                break;
            case R.id.btn_six:
                textNumber("6");
                break;
            case R.id.btn_seven:
                textNumber("7");
                break;
            case R.id.btn_eight:
                textNumber("8");
                break;
            case R.id.btn_nine:
                textNumber("9");
                break;
            case R.id.btn_zero:
                textNumber("0");
                break;
            case R.id.btn_clear:
                tv_result.setText("0");
                break;

        }
    }

    private void textNumber(String s) {
        if (success) {
            tv_result.setText("");
            success = false;
        }
        if (tv_result.getText().toString().equals("0")) {
            tv_result.setText(s);
        } else {
            tv_result.append(s);
        }

    }

    public void clickOperation(View w) {
        switch (w.getId()) {
            case R.id.btn_plus:
                firstValue = Integer.parseInt(tv_result.getText().toString());
                tv_result.setText(firstValue + "+");
                operation = "+";
                break;
            case R.id.btn_equals:
                secondValue = Integer.parseInt(tv_result.getText().toString()
                        .replace(firstValue + operation, ""));
                success = true;
                if (tv_result.getText().toString().replace(firstValue + operation, "") != "") {
                    switch (operation) {
                        case "+":
                            tv_result.setText(firstValue + operation + secondValue + "\n=" + (firstValue + secondValue));
                            break;
                        case "-":
                            tv_result.setText(firstValue + operation + secondValue + "\n=" + (firstValue - secondValue));
                            break;
                        case "*":
                            tv_result.setText(firstValue + operation + secondValue + "\n=" + (firstValue * secondValue));
                            break;
                        case "/":
                            tv_result.setText(firstValue + operation + secondValue + "\n=" + (firstValue / secondValue));
                            break;
                    }
                }
                break;
            case R.id.btn_minus:
                firstValue = Integer.parseInt(tv_result.getText().toString());
                tv_result.setText(firstValue + "-");
                operation = "-";
                break;
            case R.id.btn_multiply:
                firstValue = Integer.parseInt(tv_result.getText().toString());
                tv_result.setText(firstValue + "*");
                operation = "*";
                break;
            case R.id.btn_division:
                firstValue = Integer.parseInt(tv_result.getText().toString());
                tv_result.setText(firstValue + "/");
                operation = "/";
                break;
        }
    }
}