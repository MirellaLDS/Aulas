package com.example.listasrecyclerview;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AndroidVersionAdapter extends RecyclerView.Adapter<VersionItemHolder> {

    private List<String> versionData;
    private String[] colors;

    public AndroidVersionAdapter(List<String> versionData, String[] colors) {
        this.versionData = versionData;
        this.colors = colors;
    }

    public void setVersionData(List<String> versionData) {
        this.versionData = versionData;
    }

    private String getColor(int position) {
        return colors[position];
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    @NonNull
    @Override
    public VersionItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return VersionItemHolder.createHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionItemHolder holder, int position) {
        holder.preencherItem(versionData.get(position), colors[position]);
    }

    @Override
    public int getItemCount() {
        return versionData.size();
    }
}
