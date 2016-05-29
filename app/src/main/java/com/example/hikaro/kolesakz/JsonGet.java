package com.example.hikaro.kolesakz;

import android.app.Activity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Hikaro on 27.05.2016.
 */
public class JsonGet {
    public String requestGET(String link) {
        String result="";
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("User-Agent", "Java bot");

            conn.connect();

            int code=conn.getResponseCode();

            if (code==200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    result+=inputLine;
                }

                in.close();
            }
            else{
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }

            conn.disconnect();
            conn=null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
//    NewsClass[] getTwentyNewsfromAll(){
//        String link ="";
//        String json = requestGET(link);
//    }
    ArrayList<NewsClass> getTwentyNewsfromPolitics(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=1&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }


    ArrayList<NewsClass> getTwentyNewsfromWorld(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=2&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromSociety(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=3&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromEconomics(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=4&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromSports(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=5&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromAccidents(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=6&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromCulture(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=7&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromScience(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=8&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromHealth(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=9&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromTechnology(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=10&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromInternet(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=11&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromAuto(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=12&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromTourism(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=13&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
    ArrayList<NewsClass> getTwentyNewsfromKazakh(){
        ArrayList<NewsClass> NewsArray = new ArrayList<NewsClass>();
        String link ="https://api.i-news.kz/news/search?query[cat_id]=14&text=&limit=20&appId=Ozaa5nic5oeph7eethok&appKey=ushoh4ahpe8Aghahreel&version=1";
        String json = requestGET(link);
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray news = object.getJSONArray("news");
            for(int i=0; i<20; i++){
                NewsClass oneFromTwenty=new NewsClass();
                JSONObject oneFromNews = news.getJSONObject(i);
                oneFromTwenty.setTitle(oneFromNews.getString("title"));
                oneFromTwenty.setDescription(oneFromNews.getString("description"));
                oneFromTwenty.setSource(oneFromNews.getString("url"));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssz");
                Date date =  df.parse(oneFromNews.getString("date"));
                oneFromTwenty.setDate(date);
                NewsArray.add(oneFromTwenty);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NewsArray;
    }
}
