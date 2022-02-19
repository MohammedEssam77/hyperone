package com.example.hyperone.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hyperone.R;
import com.example.hyperone.pojo.Model;

import java.util.ArrayList;
import java.util.List;

public class UiAdapter extends RecyclerView.Adapter<UiAdapter.UiViewHolder> {
    private List<Model> mList;
    private Context mContext;

    public UiAdapter(Context mContext) {
        this.mContext = mContext;
        mList = new ArrayList<>();

    }

    public void setList(List<Model> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UiAdapter.UiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new UiViewHolder(v1);
    }

    @Override
    public void onBindViewHolder(@NonNull UiAdapter.UiViewHolder holder, int position) {
        Model model = mList.get(position);
        UiViewHolder viewHolder = (UiViewHolder) holder;
        final VideoView videoView = holder.videoTime;
        viewHolder.videoTime.setVideoURI(Uri.parse(mList.get(position).getUrl()));
        viewHolder.name.setText(model.getName());

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class UiViewHolder extends RecyclerView.ViewHolder {
        private Button name;
        private VideoView videoTime;

        public UiViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.button);
            videoTime = itemView.findViewById(R.id.VideoView);

        }

    }
}

