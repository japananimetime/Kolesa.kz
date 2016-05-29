package com.example.hikaro.kolesakz;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Technology extends AppCompatActivity {
    public static boolean isOnline(Context context)
    {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting())
        {
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setContentView(R.layout.activity_politics);
        setSupportActionBar(toolbar);
        if(isOnline(getApplicationContext())){

        }
        else{
            Toast.makeText(this, "Устройство оффлайн", Toast.LENGTH_SHORT).show();
        }
        ListView listView;
        JsonGet newsRequest = new JsonGet();
        ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromTechnology();
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                String nonFixedLink= ((TextView) itemClicked).getText().toString();
                int index=nonFixedLink.lastIndexOf("http");
                String fixedLink=nonFixedLink.substring(index);
                Uri address = Uri.parse(fixedLink);
                Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openLinkIntent);
            }
        });
    }
}
