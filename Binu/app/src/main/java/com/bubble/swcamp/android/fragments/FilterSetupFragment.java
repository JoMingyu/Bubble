package com.bubble.swcamp.android.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.adapter.FilterAdapter;
import com.bubble.swcamp.android.model.FilterItem;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.imageprocessors.subfilters.BrightnessSubfilter;
import com.zomato.photofilters.imageprocessors.subfilters.ContrastSubfilter;

import java.util.ArrayList;


public class FilterSetupFragment extends Fragment {


    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<FilterItem> arrayList;
    Filter myFilter;
    private String[] spinnerItems = new String[]{
            "카메라",
            "색상",
            "세부정보",
            "효과"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_fliter_setup,container,false);
        init(rootView);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event

    public void init(View rootView){
        Spinner spinner=(Spinner)rootView.findViewById(R.id.filter_spinner);

        getCameraData();
        final RecyclerView recyclerView=(RecyclerView)rootView.findViewById(R.id.filter_recyclerView);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        arrayList=getCameraData();
        final FilterAdapter adapter=new FilterAdapter(getActivity(),arrayList);
        recyclerView.setAdapter(adapter);

        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(getActivity(),R.layout.textview_background,spinnerItems);
        stringArrayAdapter.setDropDownViewResource(R.layout.textview_background);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //recyclerView.setAdapter(new FilterAdapter(getActivity(),getColorData()));
                //notify();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public ArrayList getCameraData(){
        ArrayList<FilterItem> arrayList=new ArrayList<>();
        arrayList.add(new FilterItem(R.drawable.test_image,"고대비"));
        arrayList.add(new FilterItem(R.drawable.test_image,"균일"));
        arrayList.add(new FilterItem(R.drawable.test_image,"따듯한 그림자"));
        arrayList.add(new FilterItem(R.drawable.test_image,"고대비 흑백"));
        arrayList.add(new FilterItem(R.drawable.test_image,"균일 흑백"));
        return  arrayList;
    }

    public ArrayList<FilterItem> getColorData(){
        ArrayList<FilterItem> arrayList=new ArrayList<>();
        arrayList.add(new FilterItem(R.drawable.image_color_test,"활력1"));
        arrayList.add(new FilterItem(R.drawable.image_color_test,"활력2"));
        arrayList.add(new FilterItem(R.drawable.image_color_test,"활력3"));
        return arrayList;
    }

    public void getFilters(ArrayList<FilterItem> arrayList,Bitmap bitmap){
        myFilter=new Filter();

        myFilter.addSubFilter(new BrightnessSubfilter(30));
        myFilter.addSubFilter(new ContrastSubfilter(1.1f));



    }




}
