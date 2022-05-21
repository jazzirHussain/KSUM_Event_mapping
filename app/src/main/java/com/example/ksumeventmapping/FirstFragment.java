package com.example.ksumeventmapping;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import pl.droidsonroids.gif.GifImageView;

public class FirstFragment extends Fragment {
    GifImageView img1,img2;
    private int c;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false);



    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img1 = (GifImageView) getView().findViewById(R.id.outsideImageView1);
        img2 = (GifImageView) getView().findViewById(R.id.outsideImageView2);
//        Button btn = (Button) getView().findViewById(R.id.fab);
//        btn.setVisibility(View.GONE);
        if(getActivity().getIntent().hasExtra("eventData")){
            MainActivity activity =  (MainActivity) getActivity();
            CourseModal data = getActivity().getIntent().getParcelableExtra("eventData");
            Log.d("building","data: "+data.getBuilding());

            if(data.getBuilding() == 1){
                img1.setVisibility(View.VISIBLE);
            }else if(data.getBuilding() == 2){
                img2.setVisibility(View.VISIBLE);
            }

        }

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}