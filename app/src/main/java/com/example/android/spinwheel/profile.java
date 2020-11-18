package com.example.android.spinwheel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends AppCompatActivity {

    private CircleImageView dp;
    public static final int STORAGE_REQUEST_CODE = 400;
    public static final int IMAGE_PICK_GALLERY_CODE = 1000;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private TextView timeLeft,nextGameText;
    private String time, tt = "00:00:00";
    private Button play;
    private LinearLayout nextGame;

    String storagePermission[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setDefault();
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (!checkStoragePermission()) {

            requestStoragePermission();
        } else {
            File folder = Environment.getExternalStoragePublicDirectory("/spinwheel/");
            if (folder.exists()) {
                Uri file = Uri.fromFile(new File(folder, "profile_pic.jpg"));
                if (file != null) {
                    Picasso
                            .get()
                            .load(file)
                            .into(dp);

                }
            }
        }

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkStoragePermission()) {

                    requestStoragePermission();
                } else {
                    pickGallery();
                }
            }
        });
        setTimeLeft();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profile.this, MainActivity.class));
            }
        });

    }

    private void setTimeLeft() {
        db.collection("games").document("game1").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                time = documentSnapshot.getString("time");
                String ar[]=time.split(" ");
                nextGameText.setText(ar[1]);
                try {
                    compareTime(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(profile.this, "Error004", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void compareTime(String time1) throws ParseException {
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");


        Date d1 = Calendar.getInstance().getTime();
        Date d2 = sdf.parse(String.valueOf(time1));

        long difference_In_Time1
                = d2.getTime() - d1.getTime();
        new CountDownTimer(difference_In_Time1, 1000) {

            public void onTick(long millisUntilFinished) {

                long difference_In_Time = millisUntilFinished;
                long difference_In_Seconds
                        = (difference_In_Time
                        / 1000)
                        % 60;

                long difference_In_Minutes
                        = (difference_In_Time
                        / (1000 * 60))
                        % 60;

                long difference_In_Hours
                        = (difference_In_Time
                        / (1000 * 60 * 60))
                        % 24;

                if(difference_In_Hours/10==0 && difference_In_Minutes/10==0 && difference_In_Seconds/10==0)
                    tt = "0"+difference_In_Hours + ":0" + difference_In_Minutes + ":0" + difference_In_Seconds;
                if(difference_In_Hours/10==0 && difference_In_Minutes/10==0 && difference_In_Seconds/10!=0)
                    tt = "0"+difference_In_Hours + ":0" + difference_In_Minutes + ":" + difference_In_Seconds;
                if(difference_In_Hours/10==0 && difference_In_Minutes/10!=0 && difference_In_Seconds/10==0)
                    tt = "0"+difference_In_Hours + ":" + difference_In_Minutes + ":0" + difference_In_Seconds;
                if(difference_In_Hours/10!=0 && difference_In_Minutes/10==0 && difference_In_Seconds/10==0)
                    tt = difference_In_Hours + ":0" + difference_In_Minutes + ":0" + difference_In_Seconds;
                if(difference_In_Hours/10!=0 && difference_In_Minutes/10!=0 && difference_In_Seconds/10==0)
                    tt = difference_In_Hours + ":" + difference_In_Minutes + ":0" + difference_In_Seconds;
                if(difference_In_Hours/10!=0 && difference_In_Minutes/10==0 && difference_In_Seconds/10!=0)
                    tt = difference_In_Hours + ":0" + difference_In_Minutes + ":" + difference_In_Seconds;
                if(difference_In_Hours/10==0 && difference_In_Minutes/10!=0 && difference_In_Seconds/10!=0)
                    tt = "0"+difference_In_Hours + ":" + difference_In_Minutes + ":" + difference_In_Seconds;
                if(difference_In_Hours/10!=0 && difference_In_Minutes/10!=0 && difference_In_Seconds/10!=0)
                    tt = difference_In_Hours + ":" + difference_In_Minutes + ":" + difference_In_Seconds;
                timeLeft.setText(tt);
            }

            @Override
            public void onFinish() {
                timeLeft.setVisibility(View.INVISIBLE);
                nextGame.setVisibility(View.INVISIBLE);
                play.setVisibility(View.VISIBLE);
                play.setClickable(true);
            }
        }.start();
    }

    public void setDefault() {
        nextGame = (LinearLayout) findViewById(R.id.linear_profile);
        dp = (CircleImageView) findViewById(R.id.hm_profilePic);
        timeLeft = (TextView) findViewById(R.id.p_time_left);
        play = (Button) findViewById(R.id.p_play);
        nextGameText= (TextView) findViewById(R.id.p_next_game);
    }

    private void pickGallery() {

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select image"), IMAGE_PICK_GALLERY_CODE);
    }

    private boolean checkStoragePermission() {
        boolean result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, storagePermission, STORAGE_REQUEST_CODE);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case STORAGE_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean writeStorageAccepted = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    if (writeStorageAccepted) {
                        //pickGallery();
                    } else {
                        Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_PICK_GALLERY_CODE) {
                CropImage.activity(data.getData())
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(this);
            }
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                dp.setImageURI(resultUri);

                BitmapDrawable bitmapDrawable = (BitmapDrawable) dp.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                saveImage(bitmap);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void saveImage(Bitmap path) {

        String p = Environment.getExternalStorageDirectory() + "/" + "SpinWheel" + "/";
        File dir = new File(p);
        dir.mkdir();
        File file = new File(dir, "profile_pic" + ".jpg");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            path.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            Toast.makeText(getApplicationContext(), "File saved ", Toast.LENGTH_SHORT).show();
            fos.flush();
            fos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}

