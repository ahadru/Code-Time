package com.example.codetime;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    String[] data;
    public RecyclerViewAdapter(String[] data){
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
        String title = data[position];
        viewHolder.title.setText(title);
        viewHolder.contestTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
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
