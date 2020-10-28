package com.example.android.spinwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class buyTicket extends AppCompatActivity {

    private Button add0, minus0, add1, minus1, add2, minus2, add3, minus3, add4, minus4, add5, minus5, add6, minus6, add7, minus7, add8, minus8, add9, minus9;
    private TextView total, sum0, sum1, sum2, sum3, sum4, sum5, sum6, sum7, sum8, sum9;
    private int x0 = 0, x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0, x9 = 0;
    private RadioButton zero, one, two, three, four, five, six, seven, eight, nine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
        setDefault();
        setsum();
    }

    public void setDefault() {
        add0 = (Button) findViewById(R.id.add_cash_0);
        minus0 = (Button) findViewById(R.id.subtract_cash_0);
        sum0 = (TextView) findViewById(R.id.sum_0);
        add1 = (Button) findViewById(R.id.add_cash_1);
        minus1 = (Button) findViewById(R.id.subtract_cash_1);
        sum1 = (TextView) findViewById(R.id.sum_1);
        add2 = (Button) findViewById(R.id.add_cash_2);
        minus2 = (Button) findViewById(R.id.subtract_cash_2);
        sum2 = (TextView) findViewById(R.id.sum_2);
        add3 = (Button) findViewById(R.id.add_cash_3);
        minus3 = (Button) findViewById(R.id.subtract_cash_3);
        sum3 = (TextView) findViewById(R.id.sum_3);
        add4 = (Button) findViewById(R.id.add_cash_4);
        minus4 = (Button) findViewById(R.id.subtract_cash_4);
        sum4 = (TextView) findViewById(R.id.sum_4);
        add5 = (Button) findViewById(R.id.add_cash_5);
        minus5 = (Button) findViewById(R.id.subtract_cash_5);
        sum5 = (TextView) findViewById(R.id.sum_5);
        add6 = (Button) findViewById(R.id.add_cash_6);
        minus6 = (Button) findViewById(R.id.subtract_cash_6);
        sum6 = (TextView) findViewById(R.id.sum_6);
        add7 = (Button) findViewById(R.id.add_cash_7);
        minus7 = (Button) findViewById(R.id.subtract_cash_7);
        sum7 = (TextView) findViewById(R.id.sum_7);
        add8 = (Button) findViewById(R.id.add_cash_8);
        minus8 = (Button) findViewById(R.id.subtract_cash_8);
        sum8 = (TextView) findViewById(R.id.sum_8);
        add9 = (Button) findViewById(R.id.add_cash_9);
        minus9 = (Button) findViewById(R.id.subtract_cash_9);
        sum9 = (TextView) findViewById(R.id.sum_9);
        total = (TextView) findViewById(R.id.total_sum);
        zero = (RadioButton) findViewById(R.id.number_zero);
        one = (RadioButton) findViewById(R.id.number_one);
        two = (RadioButton) findViewById(R.id.number_two);
        three = (RadioButton) findViewById(R.id.number_three);
        four = (RadioButton) findViewById(R.id.number_four);
        five = (RadioButton) findViewById(R.id.number_five);
        six = (RadioButton) findViewById(R.id.number_six);
        seven = (RadioButton) findViewById(R.id.number_seven);
        eight = (RadioButton) findViewById(R.id.number_eight);
        nine = (RadioButton) findViewById(R.id.number_nine);

    }

    public void setsum() {
        add0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x0 = x0 + 5;
                sum0.setText(String.valueOf(x0));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x0 = x0 - 5;
                sum0.setText(String.valueOf(x0));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x1 = x1 + 5;
                sum1.setText(String.valueOf(x1));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x1 = x1 - 5;
                sum1.setText(String.valueOf(x1));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x2 = x2 + 5;
                sum2.setText(String.valueOf(x2));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x2 = x2 - 5;
                sum2.setText(String.valueOf(x2));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x3 = x3 + 5;
                sum3.setText(String.valueOf(x3));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x3 = x3 - 5;
                sum3.setText(String.valueOf(x3));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x4 = x4 + 5;
                sum4.setText(String.valueOf(x4));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x4 = x4 - 5;
                sum4.setText(String.valueOf(x4));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        add5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x5 = x5 + 5;
                sum5.setText(String.valueOf(x5));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x5 = x5 - 5;
                sum5.setText(String.valueOf(x5));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        add6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x6 = x6 + 5;
                sum6.setText(String.valueOf(x6));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x6 = x6 - 5;
                sum6.setText(String.valueOf(x6));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        add7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x7 = x7 + 5;
                sum7.setText(String.valueOf(x7));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x7 = x7 - 5;
                sum7.setText(String.valueOf(x7));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        add8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x8 = x8 + 5;
                sum8.setText(String.valueOf(x8));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x8 = x8 - 5;
                sum8.setText(String.valueOf(x8));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        add9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x9 = x9 + 5;
                sum9.setText(String.valueOf(x9));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
        minus9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x9 = x9 - 5;
                sum9.setText(String.valueOf(x9));
                total.setText("Total amount = " + String.valueOf(x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9));
            }
        });
    }
}
