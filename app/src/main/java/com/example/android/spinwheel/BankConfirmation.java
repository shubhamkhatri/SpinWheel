package com.example.android.spinwheel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.LinkedHashMap;
import java.util.Map;


public class BankConfirmation extends AppCompatActivity {

    private TextView  name,number,ifsc,amount;
    private Button confirm,cancel;
    private String  Name,Number,Ifsc,Amount;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

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
                uploadData();
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

    private void uploadData() {
        Name=name.getText().toString().trim();
        Number=number.getText().toString().trim();
        Ifsc=ifsc.getText().toString().trim();
        Amount=amount.getText().toString().trim();


        Map<String, Object> user = new LinkedHashMap<>();
        user.put("Name",Name);
        user.put("Number",Number);
        user.put("IFSC",Ifsc);
        user.put("Amount",Amount);

        db.collection("users").document().set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(BankConfirmation.this, "Data Upload Success", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(BankConfirmation.this, "Error!", Toast.LENGTH_SHORT).show();
                Log.d("TAG Database Error", e.toString());
            }
        });
    }
}