package com.example.hikaro.kolesakz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Internet extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setContentView(R.layout.activity_politics);
        setSupportActionBar(toolbar);
        ListView listView;
        JsonGet newsRequest = new JsonGet();
        ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromInternet();
        ArrayAdapter<Spanned> mAdapter;
        String[] newsAsStrings;
        newsAsStrings = new String[news.size()];
        for (int i = 0; i < news.size(); i++) {
            newsAsStrings[i] = news.get(i).toString();
        }
        listView = (ListView) findViewById(R.id.listView);
        Spanned[] taggedNews = new Spanned[newsAsStrings.length];
        for(int i = 0 ; i < newsAsStrings.length; i++) {
            taggedNews[i] = Html.fromHtml(newsAsStrings[i]);
        }
        mAdapter = new ArrayAdapter<>(this,
                R.layout.list_item, taggedNews);

        listView.setAdapter(mAdapter);
    }
}
