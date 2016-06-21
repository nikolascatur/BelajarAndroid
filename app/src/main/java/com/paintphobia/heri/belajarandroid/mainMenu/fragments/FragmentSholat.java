package com.paintphobia.heri.belajarandroid.mainMenu.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paintphobia.heri.belajarandroid.R;
import com.paintphobia.heri.belajarandroid.prayList.PrayListActivity;
import com.paintphobia.heri.belajarandroid.prayList.PrayTimeAdapter;
import com.paintphobia.heri.belajarandroid.services.PrayTimes;
import com.paintphobia.heri.belajarandroid.utils.Clock;
import com.paintphobia.heri.belajarandroid.utils.OnClockTickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentSholat.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentSholat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSholat extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ArrayList<PrayTimes> itemPrayData;
    private PrayTimeAdapter adapter;

    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    @BindView(R.id.timeNow)
    TextView txtTimeNow;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    public FragmentSholat() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSholat.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSholat newInstance(String param1, String param2) {
        FragmentSholat fragment = new FragmentSholat();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_sholat, container, false);

        ButterKnife.bind(this, view);

        Clock c = new Clock(this.getActivity(), Clock.TICKPERSECOND);
        c.AddClockTickListner(new OnClockTickListener() {
            @Override
            public void OnSecondTick(Time currentTime) {
                txtTimeNow.setText("NOW: "+DateFormat.format("h:mm:ss aa", currentTime.toMillis(true)).toString());
            }

            @Override
            public void OnMinuteTick(Time currentTime) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PrayListActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        myRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(layoutManager);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                itemPrayData = (ArrayList<PrayTimes>) data.getSerializableExtra("FETCH_RESULT");

                if(itemPrayData != null) {
                    adapter = new PrayTimeAdapter(itemPrayData);
                    myRecyclerView.setAdapter(adapter);
                }
            }
        }
    }
}
