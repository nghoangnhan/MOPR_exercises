package com.example.fragmenttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;


public class ListMenuFragment extends ListFragment {
    String[] users = new String[] { "Suresh","Rohini","Trishika","Praveen","Sateesh","Madhav" };
    String[] location = new String[]{"Hyderabad","Guntur","Hyderabad","Bangalore","Vizag","Nagpur"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        View view = inflater.inflate(R.layout.listitems_info, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, users);
        setListAdapter(adapter);
        return view;
    }
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        DetailsFragment txt = (DetailsFragment) getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change("Name" + users[position], "Location:" + location[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}
