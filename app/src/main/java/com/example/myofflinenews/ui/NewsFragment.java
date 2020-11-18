package com.example.myofflinenews.ui;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myofflinenews.MainViewModel;
import com.example.myofflinenews.R;
import com.example.myofflinenews.adapters.MainRecyclerViewAdapter;
import com.example.myofflinenews.models.Article;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view = null;
MainViewModel mainViewModel;
ProgressDialog progressDialog;
 List<Article> articles=new ArrayList<>();
 MainRecyclerViewAdapter adapter;
    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RetroFitPostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
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
        //    progressDialog = new ProgressDialog(getActivity());
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.news_frag, container, false);
        initViews(view);
        setAdapter();
        mainViewModel.getNews().observe(getActivity(), new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articles) {
                adapter.setData(articles);

            }
        });

        return  view;
    }

    RecyclerView recyclerView;
    private void initViews(View view){
        recyclerView = view.findViewById(R.id.rv_news);
    }


    private void setAdapter(){
        adapter = new MainRecyclerViewAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
