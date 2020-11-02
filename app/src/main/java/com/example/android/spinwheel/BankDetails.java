package com.example.android.spinwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BankDetails extends AppCompatActivity {

    private EditText name,number,ifsc,amount;
    private Button withdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);
        setDefault();
        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().trim().isEmpty())
                    Toast.makeText(BankDetails.this,"Please fill all details",Toast.LENGTH_SHORT).show();
                else if(number.getText().toString().trim().isEmpty())
                    Toast.makeText(BankDetails.this,"Please fill all details",Toast.LENGTH_SHORT).show();
                else if(ifsc.getText().toString().trim().isEmpty())
                    Toast.makeText(BankDetails.this,"Please fill all details",Toast.LENGTH_SHORT).show();
                else if(amount.getText().toString().trim().isEmpty())
                    Toast.makeText(BankDetails.this,"Please fill all details",Toast.LENGTH_SHORT).show();
                else
                {
                    Intent intent=new Intent(BankDetails.this,BankConfirmation.class);
                    intent.putExtra("name",name.getText().toString().trim());
                    intent.putExtra("number",number.getText().toString().trim());
                    intent.putExtra("ifsc",ifsc.getText().toString().trim());
                    intent.putExtra("amount",amount.getText().toString().trim());
                    startActivity(intent);
                }
            }
        });

    }
    
    public void setDefault(){
        name=(EditText)findViewById(R.id.wd_account_name);
        number=(EditText)findViewById(R.id.wd_account_number);
        amount=(EditText)findViewById(R.id.wd_amount);
        ifsc=(EditText)findViewById(R.id.wd_ifsc);
        withdraw=(Button) findViewById(R.id.wd_withdraw_button);
    }
}