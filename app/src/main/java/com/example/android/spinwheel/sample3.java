package com.example.android.spinwheel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.LinkedHashMap;
import java.util.Map;

public class sample3 extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText name,email,number;
    private String Name,Email,Number;
private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample3);
        setDefault();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().trim().isEmpty())
                    Toast.makeText(sample3.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                else if(email.getText().toString().trim().isEmpty())
                    Toast.makeText(sample3.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                else if(number.getText().toString().trim().isEmpty())
                    Toast.makeText(sample3.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                else{
                    uploadData();
                }
            }
        });
    }

    private void setDefault() {
        name=(EditText)findViewById(R.id.fl_name_edittext);
        email=(EditText)findViewById(R.id.fl_email_edittext);
        number=(EditText)findViewById(R.id.fl_phn_no_edittext);
        submit=(Button) findViewById(R.id.fl_submit_button);
    }

    private void uploadData() {
        Name=name.getText().toString().trim();
        Email=email.getText().toString().trim();
        Number=number.getText().toString().trim();

        Map<String, Object> user = new LinkedHashMap<>();
        user.put("Name",Name);
        user.put("Email",Email);
        user.put("Number",Number);

        db.collection("users").document(Email).set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(sample3.this, "Data Upload Success", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(sample3.this, "Error!", Toast.LENGTH_SHORT).show();
                Log.d("TAG Database Error", e.toString());
            }
        });
    }
}