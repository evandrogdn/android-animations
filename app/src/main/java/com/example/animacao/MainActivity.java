package com.example.animacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
    implements Animation.AnimationListener
{
    private ImageView imageView;
    private Button buttonAntecipate;
    private Button buttonCycle;
    private Button buttonDecelerate;
    private Button buttonLinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        buttonAntecipate = findViewById(R.id.btn_antecipate);
        buttonCycle = findViewById(R.id.btn_cycle);
        buttonDecelerate = findViewById(R.id.btn_declarate);
        buttonLinear = findViewById(R.id.btn_linear);

        onLoadListeners();
    }

    private void onLoadListeners() {
        buttonAntecipate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAntecipateButton();
            }
        });

        buttonCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCycleButton();
            }
        });

        buttonDecelerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDecelerateButton();
            }
        });

        buttonLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLinearButton();
            }
        });
    }

    private void disableButtons() {
        buttonAntecipate.setEnabled(false);
        buttonCycle.setEnabled(false);
        buttonDecelerate.setEnabled(false);
        buttonLinear.setEnabled(false);
    }

    private void enableButtons() {
        buttonAntecipate.setEnabled(true);
        buttonCycle.setEnabled(true);
        buttonDecelerate.setEnabled(true);
        buttonLinear.setEnabled(true);
    }

    public void onClickAntecipateButton() {
        AnticipateInterpolator interpolator = new AnticipateInterpolator();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animation.setInterpolator(interpolator);
        animation.setAnimationListener(this);

        imageView.requestLayout();
        imageView.setAnimation(animation);

        animation.start();
        disableButtons();
    }

    public void onClickCycleButton() {
        CycleInterpolator interpolator = new CycleInterpolator(2);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        animation.setInterpolator(interpolator);
        animation.setAnimationListener(this);

        imageView.requestLayout();
        imageView.setAnimation(animation);

        animation.start();
        disableButtons();
    }

    public void onClickDecelerateButton() {
        DecelerateInterpolator interpolator = new DecelerateInterpolator();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        animation.setInterpolator(interpolator);
        animation.setAnimationListener(this);

        imageView.requestLayout();
        imageView.setAnimation(animation);

        animation.start();
        disableButtons();
    }

    public void onClickLinearButton() {
        LinearInterpolator interpolator = new LinearInterpolator();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        animation.setInterpolator(interpolator);
        animation.setAnimationListener(this);

        imageView.requestLayout();
        imageView.setAnimation(animation);

        animation.start();
        disableButtons();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        enableButtons();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
