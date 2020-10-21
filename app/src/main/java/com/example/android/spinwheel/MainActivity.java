package com.example.android.spinwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView wheel, gift, bonus;
    private EditText value;
    private Button spin;
    private TextView ans;
    private String txt;
    private int z = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefault();
        gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Gift", Toast.LENGTH_SHORT).show();
            }
        });
        bonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bonus", Toast.LENGTH_SHORT).show();
            }
        });
        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt = value.getText().toString();
                if (txt.isEmpty())
                    Toast.makeText(MainActivity.this, "Enter a Number", Toast.LENGTH_SHORT).show();
                else {
                    int rr = Integer.parseInt(txt);
                    if (rr >= 0 && rr <= 9) {
                        spinWheel(rr);
                    } else
                        Toast.makeText(MainActivity.this, "Enter Number only Between 0-9", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setDefault() {
        wheel = (ImageView) findViewById(R.id.spin_wheel_image);
        value = (EditText) findViewById(R.id.edit_text);
        spin = (Button) findViewById(R.id.spin_button);
        ans = (TextView) findViewById(R.id.ans_text);
        gift = (ImageView) findViewById(R.id.gift_image);
        bonus = (ImageView) findViewById(R.id.bonus_image);
    }

    public void spinWheel(final int rr) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, (360 - (rr * 36)) + 720,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());


        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                z = z + rr;
                final String result = String.valueOf(z);
                ans.setText(result);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
        wheel.startAnimation(rotateAnimation);
    }
}
