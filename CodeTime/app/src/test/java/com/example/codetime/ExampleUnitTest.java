package com.example.codetime;

import com.example.codetime.contest_data.codeforces.CodeforceContestInfo;
import com.example.codetime.contest_data.codeforces.Groups;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
//    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
//    }

    public void codeTest(){
        String jason = "{\n" +
                "  \"status\": \"OK\",\n" +
                "  \"result\": [\n" +
                "    {\n" +
                "      \"id\": 1119,\n" +
                "      \"name\": \"Codeforces Global Round 2\",\n" +
                "      \"type\": \"CF\",\n" +
                "      \"phase\": \"BEFORE\",\n" +
                "      \"frozen\": false,\n" +
                "      \"durationSeconds\": 7200,\n" +
                "      \"startTimeSeconds\": 1554550500,\n" +
                "      \"relativeTimeSeconds\": -2685948\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1136,\n" +
                "      \"name\": \"Codeforces Round #546 (Div. 2)\",\n" +
                "      \"type\": \"CF\",\n" +
                "      \"phase\": \"BEFORE\",\n" +
                "      \"frozen\": false,\n" +
                "      \"durationSeconds\": 7200,\n" +
                "      \"startTimeSeconds\": 1552322100,\n" +
                "      \"relativeTimeSeconds\": -457548\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1137,\n" +
                "      \"name\": \"Codeforces Round #545 (Div. 1)\",\n" +
                "      \"type\": \"CF\",\n" +
                "      \"phase\": \"BEFORE\",\n" +
                "      \"frozen\": false,\n" +
                "      \"durationSeconds\": 9000,\n" +
                "      \"startTimeSeconds\": 1552035900,\n" +
                "      \"relativeTimeSeconds\": -171348\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1138,\n" +
                "      \"name\": \"Codeforces Round #545 (Div. 2)\",\n" +
                "      \"type\": \"CF\",\n" +
                "      \"phase\": \"BEFORE\",\n" +
                "      \"frozen\": false,\n" +
                "      \"durationSeconds\": 9000,\n" +
                "      \"startTimeSeconds\": 1552035900,\n" +
                "      \"relativeTimeSeconds\": -171348\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1133,\n" +
                "      \"name\": \"Codeforces Round #544 (Div. 3)\",\n" +
                "      \"type\": \"ICPC\",\n" +
                "      \"phase\": \"BEFORE\",\n" +
                "      \"frozen\": false,\n" +
                "      \"durationSeconds\": 7200,\n" +
                "      \"startTimeSeconds\": 1551971100,\n" +
                "      \"relativeTimeSeconds\": -106550\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1132,\n" +
                "      \"name\": \"Educational Codeforces Round 61 (Rated for Div. 2)\",\n" +
                "      \"type\": \"ICPC\",\n" +
                "      \"phase\": \"FINISHED\",\n" +
                "      \"frozen\": false,\n" +
                "      \"durationSeconds\": 8100,\n" +
                "      \"startTimeSeconds\": 1551798300,\n" +
                "      \"relativeTimeSeconds\": 66251\n" +
                "    }";
        CodeforceContestInfo ob = new CodeforceContestInfo(jason);
        Groups data = new Groups();
        data = ob.getAllContest();
        assertEquals(data.getMinSize(),5,5);
    }

}