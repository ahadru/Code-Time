package com.example.codetime.contest_data.codeforces;


//This class will be used as a blueprint of codeforces contest data
import java.util.ArrayList;
public class Groups extends Data{
    public int id;
    public final String WEBSITE_NAME = "Codeforces";
    public  ArrayList<String> name;
    public ArrayList<String> phase;
    public ArrayList<Integer>durationSeconds;
    public ArrayList<Integer>startTimeSeconds;
    public ArrayList<Integer> relativeTimeSeconds;


    //minimum size of all data
    public int getMinSize(){
        int s = Math.min(name.size(),phase.size());
        s = Math.min(s,durationSeconds.size());
        return s;
    }
}
