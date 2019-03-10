package com.example.codetime;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        if(data.phase.get(position).equals("BEFORE")){
            viewHolder.status.setText("Upcoming");
        }
        else{
            viewHolder.status.setText("Live");
        }
        viewHolder.timeStart.setText(new TimeFormater(startTimeInSecends).getTime());
        viewHolder.timeEnd.setText(new TimeFormater(endTimeInSeconds).getTime());
        //viewHolder.contestImage.set

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,contestTitle,status;
        ImageView contestImage;
        TextView timeStart, timeEnd;

        public ViewHolder(View itemView){
            super(itemView);
            contestImage = itemView.findViewById(R.id.contest_title_image);
            title = itemView.findViewById(R.id.list_item_title);
            contestTitle = itemView.findViewById(R.id.contest_title);
            status = itemView.findViewById(R.id.contest_status);
            timeStart = itemView.findViewById(R.id.timeStart);
            timeEnd = itemView.findViewById(R.id.timeEnd);
        }

    }
}
