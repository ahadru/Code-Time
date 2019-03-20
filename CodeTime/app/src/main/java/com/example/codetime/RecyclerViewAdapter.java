package com.example.codetime;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codetime.contest_data.codeforces.Groups;
import com.example.codetime.contest_data.codeforces.utilities.TimeFormater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Groups data;
    public RecyclerViewAdapter(Groups data){
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int contestDuration = data.durationSeconds.get(position);
        long startTimeInSecends = data.startTimeSeconds.get(position);
        long endTimeInSeconds = startTimeInSecends + (long) contestDuration;

        viewHolder.title.setText(data.WEBSITE_NAME);
        viewHolder.contestTitle.setText(data.name.get(position));
        viewHolder.status.setText(data.phase.get(position));


        //Time and date set
        String startTime = new TimeFormater(startTimeInSecends).getTime();
        String month = MONTH.getMonthValue(
                Integer.parseInt(startTime.split(" ")[0].split("-")[1])
        );
        String day = startTime.split(" ")[0].split("-")[2];
        String hour = startTime.split(" ")[1].split(":")[0];
        String munite = startTime.split(" ")[1].split(":")[1];
        viewHolder.timeStart.setText(hour + ":" + munite);
        viewHolder.dateStart.setText(month + ", " + day);

        String endTime = new TimeFormater(endTimeInSeconds).getTime();
        month = MONTH.getMonthValue(
                Integer.parseInt(endTime.split(" ")[0].split("-")[1])
        );
        day = endTime.split(" ")[0].split("-")[2];
        hour = endTime.split(" ")[1].split(":")[0];
        munite = endTime.split(" ")[1].split(":")[1];
        viewHolder.timeEnd.setText(hour + ":" + munite);
        viewHolder.dateEnd.setText(month + ", " + day);

        viewHolder.alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Alarm set",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.phase.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,contestTitle,status;
        ImageView contestImage,alarm;
        TextView timeStart, timeEnd,dateStart,dateEnd;

        public ViewHolder(View itemView){
            super(itemView);
            contestImage = itemView.findViewById(R.id.contest_title_image);
            title = itemView.findViewById(R.id.list_item_title);
            contestTitle = itemView.findViewById(R.id.contest_title);
            status = itemView.findViewById(R.id.contest_status);
            timeStart = itemView.findViewById(R.id.timeStart);
            timeEnd = itemView.findViewById(R.id.timeEnd);
            dateStart = itemView.findViewById(R.id.dateStart);
            dateEnd = itemView.findViewById(R.id.dateEnd);
            alarm = itemView.findViewById(R.id.alarm);
        }
    }
}
