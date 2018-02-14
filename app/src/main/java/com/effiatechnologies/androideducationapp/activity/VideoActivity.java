package com.effiatechnologies.androideducationapp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.effiatechnologies.androideducationapp.adapter.PendingClaimsAdapter;
import com.effiatechnologies.androideducationapp.model.PendingClaimsModel;
import com.effiatechnologies.androideducationapp.R;

import java.util.ArrayList;
import java.util.List;


public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button btn_Unit;
    private LinearLayout layout_Scrolling;
    private String video_url;
    private MediaController mediaController;
    ProgressDialog pDialog;
    RecyclerView itemRecyclerview;
    String VideoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4";
    private List<PendingClaimsModel> pendingClaimsModelList;
    private static final String[] ITEMS = new String[]{
            "Unit 1 ", "Unit 2 ", "Unit 3 ", "Unit 4 ", "Unit 5 "};

    private PendingClaimsAdapter pendingClaimsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video_url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4";
        mediaController = new MediaController(this);
        prepareMovieData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        videoView = findViewById(R.id.VideoView);
        playVideo();
      //  btn_Unit = findViewById(R.id.btnUnit);
      //  layout_Scrolling = findViewById(R.id.scrollinglayout);
        /*itemRecyclerview = findViewById(R.id.items_recyclerView);
        itemRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        itemRecyclerview.setHasFixedSize(true);
        pendingClaimsAdapter = new PendingClaimsAdapter(getApplicationContext(), pendingClaimsModelList);
        itemRecyclerview.setAdapter(pendingClaimsAdapter);
        pendingClaimsAdapter.notifyDataSetChanged();
        //playVideoImage = (ImageView) findViewById(R.id.imgVideoPlay);

       // playVideo();
        itemRecyclerview.addOnItemTouchListener(
                new RecyclerItemClickListener(this, itemRecyclerview, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {
                        playVideo();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        playVideo();
                    }
                })
        );*/


       /* btn_Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });*/

    }


    private void prepareMovieData() {

        pendingClaimsModelList = new ArrayList<>();
        pendingClaimsModelList.add(new PendingClaimsModel(1234,"Unit 1"));
        pendingClaimsModelList.add(new PendingClaimsModel(5678,"Unit 2"));
        pendingClaimsModelList.add(new PendingClaimsModel(8798,"Unit 3"));
        pendingClaimsModelList.add(new PendingClaimsModel(9880,"Unit 4"));
        pendingClaimsModelList.add(new PendingClaimsModel(8998,"Unit 5"));
        //Log.d(TAG, pendingClaimsModelList + " pending claims details ");

    }

    private void playVideo() {

        final ProgressDialog mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading Video Please Wait...");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

        videoView.setMediaController(mediaController);
        videoView.setZOrderOnTop(true);
        videoView.setVideoURI(Uri.parse(video_url));
        videoView.setBackgroundResource(0);
        //videoView.setBackgroundResource(R.drawable.default_video);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {

                //playVideoImage.setVisibility(View.GONE);

                videoView.start();
                videoView.setBackgroundColor(Color.TRANSPARENT);
                mProgressDialog.dismiss();
            }
        });

    }
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;

        public interface OnItemClickListener {
            public void onItemClick(View view, int position);

            public void onLongItemClick(View view, int position);
        }

        GestureDetector mGestureDetector;

        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mListener != null) {
                        mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
                return true;
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {


            case android.R.id.home:

                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
