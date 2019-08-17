package com.example.songdetails_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.songdetails_fragment.content.SongUtils;


public class SongDetailFragment extends Fragment {

    private SongUtils.Song mSong;

    public SongDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(SongUtils.SONG_ID_KEY)){
            mSong = SongUtils.SONG_ITEMS.get(getArguments().getInt(SongUtils.SONG_ID_KEY));
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.song_detail, container, false);
        // Show the detail information in a TextView.
        if (mSong != null) {
            ((TextView) rootView.findViewById(R.id.song_detail)).setText(mSong.details);
        }
        return rootView;
    }

    public static SongDetailFragment newInstance(int selectedSong){
        SongDetailFragment fragment = new SongDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SongUtils.SONG_ID_KEY, selectedSong);
        fragment.setArguments(bundle);
        return fragment;
    }

}
