package com.example.codetime;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codetime.contest_data.codeforces.Groups;

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
        viewHolder.title.setText(data.WEBSITE_NAME);
        viewHolder.contestTitle.setText(data.name.get(position));
        viewHolder.status.setText(data.phase.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,contestTitle,status;
        ImageView contestImage;

        public ViewHolder(View itemView){
            super(itemView);
            contestImage = itemView.findViewById(R.id.contest_title_image);
            title = itemView.findViewById(R.id.list_item_title);
            contestTitle = itemView.findViewById(R.id.contest_title);
            status = itemView.findViewById(R.id.contest_status);

        }

    }
}
