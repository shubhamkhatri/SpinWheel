package com.example.android.spinwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class BankConfirmation extends AppCompatActivity {

    private TextView  name,number,ifsc,amount;
    private Button confirm,cancel;
    private String  Name,Number,Ifsc,Amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_confirmation);

        setDefault();

        Intent i=getIntent();
        Name=i.getStringExtra("name");
        Amount=i.getStringExtra("amount");
        Ifsc=i.getStringExtra("ifsc");
        Number=i.getStringExtra("number");
        name.setText(Name);
        amount.setText(Amount);
        ifsc.setText(Ifsc);
        number.setText(Number);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BankConfirmation.this,"Confirm Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setDefault(){
        name=(TextView) findViewById(R.id.cn_account_name);
        number=(TextView) findViewById(R.id.cn_account_number);
        amount=(TextView) findViewById(R.id.cn_amount);
        ifsc=(TextView) findViewById(R.id.cn_ifsc);
        confirm=(Button) findViewById(R.id.cn_confirm_button);
       cancel=(Button) findViewById(R.id.cn_cancel_button);
    }
}