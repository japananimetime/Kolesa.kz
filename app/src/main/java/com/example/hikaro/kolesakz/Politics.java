package com.example.hikaro.kolesakz;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Politics extends AppCompatActivity {
    ListView listView;
    JsonGet newsRequest = new JsonGet();
    ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromPolitics();
    private ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setContentView(R.layout.activity_politics);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String [] newsAsStrings;
        newsAsStrings = new String[news.size()];
        for(int i=0; i<news.size(); i++){
            newsAsStrings[i]=news.get(i).toString();
        }
        listView = (ListView) findViewById(R.id.listView_politics);
        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, newsAsStrings);
        listView.setAdapter(mAdapter);
    }

}
