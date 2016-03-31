package com.moby.calculatordemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button bt_0;
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button bt_4;
    private Button bt_5;
    private Button bt_6;
    private Button bt_7;
    private Button bt_8;
    private Button bt_9;
    private Button bt_dot;
    private Button bt_plus;
    private Button bt_minus;
    private Button bt_multiply;
    private Button bt_divide;
    private Button bt_c;
    private Button bt_plus_minus;
    private Button bt_is;
    private EditText et_input;
    private String calcSign;
    private String btnType; // num|calc
    private float firstNum = .0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * init
         */
        bt_0 = (Button) findViewById(R.id.bt_0);
        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        bt_4 = (Button) findViewById(R.id.bt_4);
        bt_5 = (Button) findViewById(R.id.bt_5);
        bt_6 = (Button) findViewById(R.id.bt_6);
        bt_7 = (Button) findViewById(R.id.bt_7);
        bt_8 = (Button) findViewById(R.id.bt_8);
        bt_9 = (Button) findViewById(R.id.bt_9);
        bt_dot = (Button) findViewById(R.id.bt_dot);
        bt_plus = (Button) findViewById(R.id.bt_plus);
        bt_minus = (Button) findViewById(R.id.bt_minus);
        bt_multiply = (Button) findViewById(R.id.bt_multiply);
        bt_divide = (Button) findViewById(R.id.bt_divide);
        bt_c = (Button) findViewById(R.id.bt_c);
        bt_plus_minus = (Button) findViewById(R.id.bt_plus_minus);
        bt_is = (Button) findViewById(R.id.bt_is);
        et_input = (EditText) findViewById(R.id.et_input);
        // event
        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_dot.setOnClickListener(this);
        bt_plus.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_multiply.setOnClickListener(this);
        bt_divide.setOnClickListener(this);
        bt_c.setOnClickListener(this);
        bt_plus_minus.setOnClickListener(this);
        bt_is.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        String str = et_input.getText().toString();
        if (str != null && !"".equals(str) && str.length() > 1) {
            bt_c.setText("DEL");
        } else {
            bt_c.setText("C");
        }

        switch (view.getId()) {
            case R.id.bt_0:
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
            case R.id.bt_dot:
                if ("calc".equals(btnType)) {
                    et_input.setText(((Button) view).getText());
                } else {
                    et_input.setText(str + ((Button) view).getText());
                }
                btnType = "num";
                break;
            case R.id.bt_plus:
                if ("num".equals(btnType)) {
                    if (("".equals(calcSign) || calcSign == null)) {
                        firstNum = Float.valueOf(str);
                    } else {
                        str = calcResult(firstNum, Float.valueOf(str), calcSign);
                        et_input.setText(str);
                        firstNum = Float.valueOf(str);
                    }

                }
                calcSign = "+";
                btnType = "calc";
                break;
            case R.id.bt_minus:
                if ("num".equals(btnType)) {
                    if (("".equals(calcSign) || calcSign == null)) {
                        firstNum = Float.valueOf(str);
                    } else {
                        str = calcResult(firstNum, Float.valueOf(str), calcSign);
                        et_input.setText(str);
                        firstNum = Float.valueOf(str);
                    }

                }
                calcSign = "-";
                btnType = "calc";
                break;
            case R.id.bt_multiply:
                if ("num".equals(btnType)) {
                    if (("".equals(calcSign) || calcSign == null)) {
                        firstNum = Float.valueOf(str);
                    } else {
                        str = calcResult(firstNum, Float.valueOf(str), calcSign);
                        et_input.setText(str);
                        firstNum = Float.valueOf(str);
                    }

                }
                calcSign = "*";
                btnType = "calc";
                break;
            case R.id.bt_divide:
                if ("num".equals(btnType)) {
                    if (("".equals(calcSign) || calcSign == null)) {
                        firstNum = Float.valueOf(str);
                    } else {
                        str = calcResult(firstNum, Float.valueOf(str), calcSign);
                        et_input.setText(str);
                        firstNum = Float.valueOf(str);

                    }

                }
                calcSign = "/";
                btnType = "calc";
                break;
            case R.id.bt_c:
                if ("DEL".equals(bt_c.getText())) {
                    et_input.setText(str.substring(0, str.length() - 1));
                } else {
                    calcSign = "";
                    btnType = "";
                    firstNum = .0f;
                    et_input.setText("");
                }
                break;
            case R.id.bt_is:
                if (str != null && !"".equals(str) && calcSign != null && !"".equals(calcSign)) {
                    str = calcResult(firstNum, Float.valueOf(str), calcSign);
                    et_input.setText(str);
                    firstNum = Float.valueOf(str);
                }
                btnType = "";
                break;
            default:
                break;
        }

    }

    private String calcResult(float fNum1, float fNum2, String pCalSign) {
        String result;
        float resultNum = .0f;
        switch (pCalSign) {
            case "+":
                resultNum = fNum1 + fNum2;
                break;
            case "-":
                resultNum = fNum1 - fNum2;
                break;
            case "*":
                resultNum = fNum1 * fNum2;
                break;
            case "/":
                if(fNum2 != 0){
                    resultNum = fNum1 / fNum2;
                }else{
                    resultNum = 0;
                }

                break;
            default:
                break;
        }
        try {
            String intNum = ("" + resultNum).substring(0, ("" + resultNum).indexOf("."));
            if (resultNum == Integer.parseInt(intNum)) {
                result = intNum;
            } else {
                result = "" + resultNum;
            }
        } catch (NumberFormatException ex) {
            result = "" + resultNum;
        }

        return result;
    }

}


