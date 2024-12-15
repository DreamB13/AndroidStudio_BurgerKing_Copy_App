package com.dreamb.burgerking_copy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;

import java.util.Arrays;
import java.util.List;

public class MoreActivity extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public MoreActivity() {
        // Required empty public constructor
    }

    public static MoreActivity newInstance(String param1, String param2) {
        MoreActivity fragment = new MoreActivity();
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

        View view = inflater.inflate(R.layout.fragment_more_activity, container, false);
        View sv = view.findViewById(R.id.horscrollview);

        RecyclerView recyclerView = view.findViewById(R.id.more_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<ParentItem> parentItems = Arrays.asList(
                new ParentItem("Parent 1", Arrays.asList("Child 1.1", "Child 1.2", "Child 1.3")),
                new ParentItem("Parent 2", Arrays.asList("Child 2.1", "Child 2.2")),
                new ParentItem("Parent 3", Arrays.asList("Child 3.1"))
        );

        ExpandableAdapter adapter = new ExpandableAdapter(parentItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}