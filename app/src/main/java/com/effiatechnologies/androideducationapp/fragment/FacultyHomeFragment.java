package com.effiatechnologies.androideducationapp.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.effiatechnologies.androideducationapp.R;

/**
 * Created by Administrator on 05-01-2017.
 */

public class FacultyHomeFragment extends Fragment {

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
    private LinearLayout kannadaLayout;
    private LinearLayout englishLayout;
    private LinearLayout hindiLayout;
    private LinearLayout socialLayout;
    private LinearLayout scienceLayout;
    private LinearLayout mathsLayout;

    public FacultyHomeFragment() {
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculty_home_page, container, false);
      //  Log.d(TAG, "inside onCreateView");

        kannadaLayout = view.findViewById(R.id.layout_Kannada);
        englishLayout = view.findViewById(R.id.layout_English);
        hindiLayout = view.findViewById(R.id.layout_Hindi);
        socialLayout = view.findViewById(R.id.layout_Social);
        scienceLayout = view.findViewById(R.id.layout_Science);
        mathsLayout = view.findViewById(R.id.layout_Maths);

        kannadaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new KannadaFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }
        });
        englishLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new EnglishFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }
        });
        hindiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new HindiFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }
        });
        socialLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new SocialFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }
        });
        scienceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new ScienceFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }
        });
        mathsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new MathsFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }
        });


        return view;
    }
}
