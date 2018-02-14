package com.effiatechnologies.androideducationapp.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.effiatechnologies.androideducationapp.R;
import com.effiatechnologies.androideducationapp.activity.VideoActivity;

/**
 * Created by Administrator on 05-01-2017.
 */

public class MathsFragment extends Fragment {

   // private static final String TAG = "adminhomepage";

    //private AdminHomeFragment.AdminHomePageServices mApiService = null;
    private AlertDialog.Builder builder;
    private ProgressDialog progressDialog;

    private Activity mActivity = null;
    private Context mContext = null;

    private FragmentManager mFragmentManager = null;
    private FragmentTransaction mFragmentTransaction = null;
    private String userDisplayName;
    private String userRoleDescription;
    private TextView tvFacultyName;
    private ListView rec_KannadaSub;
    private static final String[] ITEMS = new String[]{
            "Unit 1 ", "Unit 2 ", "Unit 3 ", "Unit 4 ", "Unit 5 "};
    private ArrayAdapter<String> itemsAdapter;
    public MathsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // Log.d(TAG, "inside onCreate");
        mActivity = getActivity();
        mContext = getContext();
        builder = new AlertDialog.Builder(mContext);
        progressDialog = new ProgressDialog(mContext);
        mFragmentManager = getFragmentManager();
        itemsAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, ITEMS);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maths_home_page, container, false);
      //  Log.d(TAG, "inside onCreateView");

        rec_KannadaSub = view.findViewById(R.id.rec_Maths);
        //rec_KannadaSub.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, true));
        rec_KannadaSub.setAdapter(itemsAdapter);


        rec_KannadaSub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(mContext, VideoActivity.class);
                startActivity(intent);
            }


        });
        return view;
    }
}
