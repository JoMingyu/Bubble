package com.bubble.swcamp.android.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.activities.PhotoFilter;
import com.bubble.swcamp.android.adapter.FilterAdapter;
import com.bubble.swcamp.android.model.FilterItem;
import com.bubble.swcamp.android.model.SampleImage;
import com.bubble.swcamp.android.utils.FilterItemCallback;

import com.bubble.swcamp.android.utils.FilterltemManger;
import com.zomato.photofilters.SampleFilters;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.imageprocessors.subfilters.BrightnessSubfilter;
import com.zomato.photofilters.imageprocessors.subfilters.ContrastSubfilter;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;

import java.util.logging.LogRecord;


public class FilterSetupFragment extends Fragment implements FilterItemCallback {

    static {
        System.loadLibrary("NativeImageProcessor");
    }

    Context mcontext;
    Bitmap mBitmap;


    @SuppressLint("ValidFragment")
    public FilterSetupFragment(Context context, Bitmap bitmap){
        mcontext=context;
        this.mBitmap=bitmap;
    }

    Activity activity;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    ImageView mainImage;

    private String[] spinnerItems = new String[]{
            "효과",
            "카메라",
            "색상",
            "세부정보"
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fliter_setup, null);


        mainImage = (ImageView)rootView.findViewById(R.id.main_image);
        init(rootView);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event

    public void init(View rootView) {
        Spinner spinner = (Spinner) rootView.findViewById(R.id.filter_spinner);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.filter_recyclerView);



        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        bindingData();

       /* FilterAdapter adapter = new FilterAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);*/

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.textview_background, spinnerItems);
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

    public void bindingData() {
        Log.d("Binding----------Data","bindingData()");


        final Context context = getActivity();
        android.os.Handler handler = new android.os.Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Bitmap bitmapImage = Bitmap.createBitmap(mBitmap);

                FilterItem f1 = new FilterItem("따듯한");
                FilterItem f2 = new FilterItem("선명한");
                FilterItem f3 = new FilterItem("밝은");
                FilterItem f4 = new FilterItem("다정한");
                FilterItem f5 = new FilterItem("어두운");
                FilterItem f6 = new FilterItem("자세하게");

                f1.bitmap = bitmapImage;
                f2.bitmap = bitmapImage;
                f3.bitmap = bitmapImage;
                f4.bitmap = bitmapImage;
                f5.bitmap = bitmapImage;
                f6.bitmap = bitmapImage;


                //필터리스트 초기화
                FilterltemManger.clearFilter();

                FilterltemManger.addItem(f1);

                f2.filter = SampleFilters.getStarLitFilter();
                FilterltemManger.addItem(f2);

                f3.filter = SampleFilters.getBlueMessFilter();
                FilterltemManger.addItem(f3);

                f4.filter = SampleFilters.getAweStruckVibeFilter();
                FilterltemManger.addItem(f4);

                f5.filter = SampleFilters.getLimeStutterFilter();
                FilterltemManger.addItem(f5);

                f6.filter = SampleFilters.getNightWhisperFilter();
                FilterltemManger.addItem(f6);


                List<FilterItem> thumbs = FilterltemManger.processThumbs(context);


                FilterAdapter adapter = new FilterAdapter(thumbs, context,mBitmap);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };
        handler.post(r);
    }


    @Override
    public void onItemClick(Filter filter) {
        mainImage.setImageBitmap(filter.processFilter(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.test_image), 640, 640, false)));
    }


}
