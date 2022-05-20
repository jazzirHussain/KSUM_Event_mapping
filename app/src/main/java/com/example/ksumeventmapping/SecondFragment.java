package com.example.ksumeventmapping;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONException;
import org.json.JSONObject;

public class SecondFragment extends Fragment {

    ImageView imageView;
    ImageView imageView2;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        JSONObject data = null;
        String src = null;
        try {
            data = new JSONObject(getActivity().getIntent().getStringExtra("eventData"));
            src = convertToFormat(data.getString("venue"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int markerId = getActivity().getResources().getIdentifier(src, "id", getActivity().getApplicationContext().getPackageName());
        ImageView i_but = (ImageView) view.findViewById(markerId);
        i_but.setVisibility(View.VISIBLE);
        ImageView img;
        img = view.findViewById(R.id.fragMap);

        int drawableId = getActivity().getResources().getIdentifier(src, "drawable", getActivity().getApplicationContext().getPackageName());
        img.setImageResource(drawableId);
        JSONObject finalData = data;
        i_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getActivity().getIntent().hasExtra("eventData")){

                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
                    View bottomSheetView = LayoutInflater.from(getActivity().getApplicationContext())
                            .inflate(
                                    R.layout.activity_bottomdialog,
                                    (LinearLayout)view.findViewById(R.id.bottomSheetContainer));
                    bottomSheetDialog.setContentView( bottomSheetView);
                    bottomSheetDialog.show( );
                    TextView name,desc,time,room;
                    name = bottomSheetDialog.findViewById(R.id.textView2);
                    desc = bottomSheetDialog.findViewById(R.id.textView3);
                    time = bottomSheetDialog.findViewById(R.id.textView4);
                    room = bottomSheetDialog.findViewById(R.id.textView5);
                    CharSequence c = "sdds";
                    try {
                        name.setText(finalData.getString("title"));
                        desc.setText(finalData.getString("content"));
                        time.setText(finalData.getString("date"));
                        room.setText(finalData.getString("venue"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }else{
                    Toast toast=Toast.makeText(getActivity().getApplicationContext(),"Select an Event",Toast.LENGTH_SHORT);
                }
            }
        }
        );





    }
    public String convertToFormat(String src){
        src = src.toLowerCase();
        src = src.replaceAll("\\s","_");
        Log.d("src: ",src);
        return src;

    }
}