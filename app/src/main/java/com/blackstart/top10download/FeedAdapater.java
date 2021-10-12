package com.blackstart.top10download;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapater extends RecyclerView.Adapter<FeedAdapater.ViewHolder> {
    private static final String TAG = "FeedAdapater";

    private final ArrayList<FieldEntry> songs;


    public FeedAdapater(ArrayList<FieldEntry> songs) {
        this.songs = songs;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.my_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FeedAdapater.ViewHolder holder, int position) {
        FieldEntry entry = songs.get(position);

        // Set item views based on your views and data model
        TextView textViewArtist = holder.tvArtistName;
        textViewArtist.setText(entry.getArtist());
        TextView textTrackName = holder.tvTrackName;
        textTrackName.setText(entry.getTitle());
        TextView textSummary = holder.tvSummary;
        textSummary.setText(entry.getRights());

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTrackName;
        TextView tvArtistName;
        TextView tvSummary;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTrackName = itemView.findViewById(R.id.tvTrackName);
            tvArtistName = itemView.findViewById(R.id.tvArtist);
            tvSummary = itemView.findViewById(R.id.tvSummary);
        }

        public void bindFeed(FieldEntry song) {
            tvTrackName.setText(song.getTitle());
            tvArtistName.setText(song.getArtist());
            tvSummary.setText(song.getRights());
        }
    }
}
