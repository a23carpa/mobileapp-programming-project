package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<RecyclerItem> items;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, List<RecyclerItem> items, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.topText.setText("" + items.get(position).getName());
        holder.secondText.setText("Distance from the Sun: " + items.get(position).getDistanceFromSun());
        holder.thirdText.setText("Planet size: " + items.get(position).getSize());
        holder.bottomText.setText("Number of Moons: " + items.get(position).getMoonCount());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView topText;
        TextView secondText;
        TextView thirdText;
        TextView bottomText;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            topText = itemView.findViewById(R.id.recyclerName);
            secondText = itemView.findViewById(R.id.recyclerLocation);
            thirdText = itemView.findViewById(R.id.recyclerSize);
            bottomText = itemView.findViewById(R.id.recyclerMoons);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(items.get(getAdapterPosition()));
        }
    }

    public interface OnClickListener {
        void onClick(RecyclerItem item);
    }
}