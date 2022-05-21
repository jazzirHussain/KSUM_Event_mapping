package com.example.ksumeventmapping;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.json.JSONException;
import org.json.JSONObject;

import pl.droidsonroids.gif.GifImageView;

public class FirstFragment extends Fragment {
    private static GifImageView img1,img2;
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
        Log.i("building","data: ;kjkl");
        if(getActivity().getIntent().hasExtra("eventData")){

            MainActivity activity =  (MainActivity) getActivity();
            Building b = new Building();
            try {
                JSONObject data = new JSONObject(getActivity().getIntent().getStringExtra("eventData"));
                String venue = data.getString("building");
                if(venue.equals("Flea Bazaar")||venue.equals("Food Fest")||venue.equals("Main Entrance")||venue.equals("Fab Hub")){
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }

                if(venue.equals("Integrated Startup Complex")){
                    img1.setVisibility(View.VISIBLE);
                }else if(venue.equals("Digital Hub")){
                    img2.setVisibility(View.VISIBLE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
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