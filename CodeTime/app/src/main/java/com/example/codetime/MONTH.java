package com.example.codetime;

public class MONTH {
    public static String []month = {"", "JANUARY","FEBRUARY","MARCH","APRIL",
            "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};

    public static String getMonthValue(int value) {
        switch (value) {
            case 1:
                return month[1];
            case 2:
                return month[2];
            case 3:
                return month[3];
            case 4:
                return month[4];
            case 5:
                return month[5];
            case 6:
                return month[6];
            case 7:
                return month[7];
            case 8:
                return month[8];
            case 9:
                return month[9];
            case 10:
                return month[10];
            case 11:
                return month[11];
            case 12:
                return month[12];
            default:
                return month[0];
        }
    }
}
