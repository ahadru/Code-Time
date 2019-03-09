package com.example.codetime.contest_api_call;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CodeforcesUpdate extends AsyncTask<String,String,String>{
    final String API_URL = "http://codeforces.com/api/contest.list?gym=false";
    private String data;

    public String getData(){
        return data;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
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
                data = strBuild.toString();
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
        return null;
    }
}
