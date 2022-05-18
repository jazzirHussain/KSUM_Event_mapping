package com.example.ksumeventmapping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class bottomdialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomdialog);
        Button btn= findViewById(R.id.btn_show);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(bottomdialog.this);
                View bottomSheetView = LayoutInflater.from( getApplicationContext ( ))
                .inflate(
                        R.layout.activity_bottomdialog,
                        (LinearLayout)findViewById(R.id.bottomSheetContainer));
                bottomSheetDialog.setContentView( bottomSheetView);
                bottomSheetDialog.show( );
            }
        });
    }
}