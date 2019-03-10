package com.example.codetime.contest_data.codeforces.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormater {
    private String BDTTime;

    public TimeFormater(long unixSeconds){
        Date date = new Date(unixSeconds*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

        BDTTime = sdf.format(date);
    }
    public String getTime(){
        return BDTTime;
    }
}
