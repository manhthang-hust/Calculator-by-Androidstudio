package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView result;
    TextView textUp;
    private StringBuffer str = new StringBuffer("");
    private StringBuffer exp = new StringBuffer("");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.textView2);
        textUp = findViewById(R.id.textView);
    }
    private void updateText(String strToAdd){
        if(strToAdd == "+/-"){
            str.insert(0, "- ");
        } else {
            str.append(strToAdd);
        }
        result.setText(str);
    }
    private void updateCount(String strToAdd){
        exp.append(" " + str + " " + strToAdd);
        str.delete(0, str.length());
        textUp.setText(exp);
        result.setText(str);
    }
    public void btnCE(View view){
        str.delete(0, str.length());
        result.setText(str);
    }
    public void btnC(View view){
        str.delete(0, str.length());
        exp.delete(0, exp.length());
        result.setText(str);
        textUp.setText(exp);
    }
    public void btnDiv(View view){
        updateCount("/");
    }
    public void btnBackSpace(View view){
        if(str.length() != 0){
            str.deleteCharAt(str.length() - 1);
        }
        result.setText(str);
    }
    public void btn7(View view){
        updateText("7");
    }
    public void btn8(View view){
        updateText("8");
    }
    public void btn9(View view){
        updateText("9");
    }
    public void btnMulti(View view){
        updateCount("*");
    }
    public void btn4(View view){
        updateText("4");
    }
    public void btn5(View view){
        updateText("5");
    }
    public void btn6(View view){
        updateText("6");
    }
    public void btnSub(View view){
        updateCount("-");
    }
    public void btn1(View view){
        updateText("1");
    }
    public void btn2(View view){
        updateText("2");
    }
    public void btn3(View view){
        updateText("3");
    }
    public void btnAdd(View view){
        updateCount("+");
    }
    public void btnSigned(View view){
        updateText("+/-");
    }
    public void btn0(View view){
        updateText("0");
    }
    public void btnDot(View view){
        updateText(".");
    }
    public void btnEqual(View view){
        updateCount("");
        System.out.println(exp);
        Double resultExp = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            resultExp = (double)engine.eval(exp.toString());
        } catch (ScriptException e){
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(resultExp != null){
            result.setText(String.valueOf(resultExp.doubleValue()));
        }
        str.delete(0, str.length());
        exp.delete(0, exp.length());
    }


}