package com.bubble.swcamp.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bubble.swcamp.android.R;
import com.bubble.swcamp.android.adapter.SamplePhotoAdapter;
import com.bubble.swcamp.android.model.SampleImage;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class Photo extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<SampleImage> arrayList;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (SamplePhotoAdapter.REQUEST_CODE == requestCode) {
            if (resultCode == Activity.RESULT_OK) {

                ImageView imageView = (ImageView) findViewById(R.id.real_image);
                //Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                Uri uri = data.getData();
                ImageView imageView_gab=(ImageView)findViewById(R.id.sample_image);
                imageView_gab.setVisibility(View.GONE);
                /*Intent intent=new Intent(getApplicationContext(),SamplePhotoAdapter.class);
                intent.putExtra("image",data);
                startActivity(intent);*/

                Glide.with(getApplicationContext()).load(uri).into(imageView);
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);


        layoutManager=new GridLayoutManager(getApplicationContext(),3);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.photo_recyclerView);

        getData();
        setBuuton();

        recyclerView.setAdapter(new SamplePhotoAdapter(getApplicationContext()));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3,dpToPx(70),true));
        recyclerView.setLayoutManager(layoutManager);

    }

    public void getData(){
        arrayList=new ArrayList<>();
        arrayList.add(new SampleImage(22));
        arrayList.add(new SampleImage(22));
        arrayList.add(new SampleImage(22));
        arrayList.add(new SampleImage(22));
        arrayList.add(new SampleImage(22));
        arrayList.add(new SampleImage(22));
        arrayList.add(new SampleImage(22));
        arrayList.add(new SampleImage(22));
        arrayList.add(new SampleImage(22));


    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount,int spacing,boolean includeEdge){
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if(includeEdge){
                outRect.left = spacing = column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if(position<spanCount){
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            }else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column+1) * spacing / spanCount;
                if(position>=spanCount){
                    outRect.top = spacing;
                }
            }
        }


    }
    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));
    }

    public void setBuuton(){
        Button back=(Button)findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button next=(Button)findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),PhotoFilter.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
