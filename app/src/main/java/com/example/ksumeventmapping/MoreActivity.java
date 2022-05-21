package com.example.ksumeventmapping;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MoreActivity extends AppCompatActivity {

    TextView detailsText,d2;
    LinearLayout layout,l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_more);
        detailsText =findViewById(R.id.details);
//        detailsText.setMovementMethod(new ScrollingMovementMethod());
        layout=findViewById(R.id.layout2);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        d2=findViewById(R.id.details2);
        l2=findViewById(R.id.layout3);
        l2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }

    public void expand(View view){
        int v=(detailsText.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;

        TransitionManager.beginDelayedTransition(layout,new AutoTransition());
        detailsText.setVisibility(v);
    }

    public void expand1(View view1){
        int v1=(d2.getVisibility()== View.GONE)?View.VISIBLE:View.GONE;

        TransitionManager.beginDelayedTransition(l2,new AutoTransition());
        d2.setVisibility(v1);
    }

}