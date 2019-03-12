package com.example.codetime.contest_api_call;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

import com.example.codetime.MainActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CodeforcesUpdate extends AsyncTask<Void, Integer,String>{
    final String API_URL = "http://codeforces.com/api/contest.list?gym=false";
    private String data;
    private ProgressDialog dialog;
    Context main;
    public CodeforcesUpdate(Context c){
        main = c;
    }

    public String getData(){
        return data;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(main);
        dialog.setMessage("Updating Data...");
        dialog.setCancelable(true);
        dialog.show();
    }

    @Override
    protected String doInBackground(Void... strings) {
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
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
