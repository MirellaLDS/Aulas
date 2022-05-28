package com.example.listasrecyclerview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class VersionItemHolder extends RecyclerView.ViewHolder {

    private ConstraintLayout container;
    private TextView tvVersion;

    public VersionItemHolder(@NonNull View itemView) {
        super(itemView);

        container = itemView.findViewById(R.id.clBackgound);
        tvVersion = itemView.findViewById(R.id.tvVersion);
    }

    public void preencherItem(String version, String color) {
        container.setBackgroundColor(Color.parseColor(color));
        tvVersion.setText(version);
    }

    static VersionItemHolder createHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.version_item_layout, parent, false);
        return new VersionItemHolder(view);
    }

}
