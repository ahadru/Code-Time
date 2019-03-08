package com.example.codetime.contest_api_call;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Codeforces /*extends AsyncTask<String,String,String> */{


    public String update() {
        final String API_URL = "http://codeforces.com/api/contest.list?gym=false";
        StringBuilder strBuild = new StringBuilder();

        try {
            URL url = new URL(API_URL);
            HttpURLConnection u = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader internetBuffer = new BufferedReader(new InputStreamReader(u.getInputStream()));
                String line;

                while ((line = internetBuffer.readLine()) != null) {
                    strBuild.append(line);
                }
                internetBuffer.close();


            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            } finally {
                u.disconnect();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return strBuild.toString();
    }

//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//    }
//
//    @Override
//    protected String doInBackground(String... strings) {
//
//        return null;
//    }
}
