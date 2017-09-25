package com.example.deepak.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class NotificationClass extends ListFragment {

        String[] title={"Title"};
        int[] images={R.drawable.ic_action_name};
        ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
        SimpleAdapter adapter;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            HashMap<String, String> map=new HashMap<String, String>();
            for(int i=0;i<title.length;i++)
            {
                map=new HashMap<String, String>();
                map.put("Player", title[i]);
                map.put("Image", Integer.toString(images[i]));
                data.add(map);
            }
            String[] from={"Player","Image"};
            int[] to={R.id.title_notification,R.id.imageView_notification};
            adapter=new SimpleAdapter(getActivity(), data, R.layout.fragment_notification, from, to);
            setListAdapter(adapter);
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        @Override
        public void onStart() {
            super.onStart();
            getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> av, View v, int pos,
                                        long id) {
                    Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


