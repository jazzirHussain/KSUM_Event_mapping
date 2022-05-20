package com.example.ksumeventmapping;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class CustomListAdapter extends BaseAdapter implements Filterable {

    Context mContext;
    List<String> mList,cList;

    public CustomListAdapter (Context context, List<String> list) {
        mList = list;
        cList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // This method is called to draw each row of the list
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // here you inflate the layout you want for the row
        @SuppressLint("ViewHolder") final View view = View.inflate(mContext, R.layout.item_list, null);

        // you bind the layout with the content of your list
        // for each element of your list of notes, the adapter will create a row and affect the right title
        final TextView noteTitle= (TextView)view.findViewById(R.id.note_title);
        noteTitle.setText(mList.get(position));

        return view;
    }
    public String checkList(List<String> list, String query){
        for (int i = 0; i < getCount(); i++){
            if(getItem(i).toLowerCase().equals(query.toLowerCase())){
//                mList = getItem(i);
                return getItem(i);
            }
        }
        return "";
    }
    @Override
    public Filter getFilter()
    {
        return new Filter()
        {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence)
            {
                FilterResults results = new FilterResults();

                //If there's nothing to filter on, return the original data for your list
                if(charSequence == null || charSequence.length() == 0)
                {
                    results.values = cList;
                    results.count = cList.size();
                }
                else
                {
                    ArrayList<String> filteredResultsData = new ArrayList<String>();


                    String filterString = charSequence.toString().toLowerCase();
                    String filterableString;

                    for(int i = 0; i<cList.size(); i++){
                        filterableString = cList.get(i);
                        if(filterableString.toLowerCase().contains(filterString)){
                            filteredResultsData.add(filterableString);
                        }
                    }

                    results.values = filteredResultsData;
                    results.count = filteredResultsData.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults)
            {
                mList = (List<String>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
