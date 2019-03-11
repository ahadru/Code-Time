package com.example.codetime;
import com.example.codetime.contest_api_call.CodeforcesUpdate;
import com.example.codetime.contest_data.codeforces.*;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private final String FILE_PATH = "contest_data.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //modified Activity Task



        //Activity Task when the app will run
        //recycle view by these data
        String json = readFromInternet();
        if(json == null){
            json = readFromInternal();
            if(json == null || json.equals("")){
                try {
                    InputStream is = getAssets().open("all_contest_data.json");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    json = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            CodeforceContestInfo info = new CodeforceContestInfo(json);
            recyclerView.setAdapter(new RecyclerViewAdapter(info.getAllContest()));

        }
        else{
            writeFile(json);
            CodeforceContestInfo info = new CodeforceContestInfo(json);
            recyclerView.setAdapter(new RecyclerViewAdapter(info.getAllContest()));
        }

    }

    //data will be written in the internal storage
    void writeFile(String json){
        try {
            FileOutputStream w = openFileOutput(FILE_PATH, Context.MODE_PRIVATE);
            w.write(json.getBytes());
            w.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //data will be read from internal storage
    String readFromInternal(){
        StringBuilder readFile = new StringBuilder();
        try {
            FileInputStream r = openFileInput(FILE_PATH);
            InputStreamReader ir = new InputStreamReader(r);
            BufferedReader br = new BufferedReader(ir);
            String text;
            while ((text = br.readLine()) != null){
                readFile.append(text).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readFile.toString();
    }

    //data will be collected from codeforces web server by codeforeces api
    String readFromInternet(){
        String json;
        CodeforcesUpdate internet = new CodeforcesUpdate();
        internet.execute();
        json = internet.getData();
        return json;
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refresh) {
            Toast.makeText(MainActivity.this,"Refreshed",Toast.LENGTH_SHORT);
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            // Handle the camera action
        } else if (id == R.id.nav_websites) {
            Intent intent = new Intent(MainActivity.this, Websites.class);
            startActivity(intent);

        } else if (id == R.id.nav_tutorials) {

        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(MainActivity.this,Settings.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
