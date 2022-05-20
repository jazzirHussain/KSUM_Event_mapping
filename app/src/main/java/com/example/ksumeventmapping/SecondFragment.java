package com.example.ksumeventmapping;

import android.os.Bundle;
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

public class SecondFragment extends Fragment {

    ImageView imageView;
    ImageView imageView2;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        int i=1;
        if(i==1){
            View view = inflater.inflate(R.layout.fragment_second,container,false);
            imageView = (ImageView) view.findViewById(R.id.imageView3);
            imageView.setVisibility(View.VISIBLE);
            imageView2 = (ImageView) view.findViewById(R.id.imageView2);
            imageView2.setVisibility(View.VISIBLE);

        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView i_but = (ImageView) view.findViewById(R.id.fragm);
        i_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseModal data =getActivity().getIntent().getParcelableExtra("eventData");
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
                    name.setText(data.getName());
                    desc.setText(data.getDesc());
                    time.setText(data.getTime());
                    room.setText(data.getRoom());
                }else{
                    Toast toast=Toast.makeText(getActivity().getApplicationContext(),"Select an Event",Toast.LENGTH_SHORT);
                }
            }
        }
        );

    }
}