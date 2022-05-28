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

/**
 * Forneça uma referência ao tipo de exibição que
 * você está usando (ViewHolder personalizado).
 */
public class VersionItemHolder extends RecyclerView.ViewHolder {

    private ConstraintLayout container;
    private TextView tvVersion;

    public VersionItemHolder(@NonNull View itemView) {
        super(itemView);

        // Criar as referências para as views do layout
        container = itemView.findViewById(R.id.clBackgound);
        tvVersion = itemView.findViewById(R.id.tvVersion);
    }

    // Substitui o conteúdo da visualização pelo conteúdo enviado pelo adapter
    public void preencherItem(String version, String color) {
        container.setBackgroundColor(Color.parseColor(color));
        tvVersion.setText(version);
    }

    // Retorna para o adapter a instancia correta do ViewHolder.
    static VersionItemHolder createHolder(ViewGroup parent) {
        // Crie uma nova visualização, que define a interface do usuário do item de lista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.version_item_layout, parent, false);
        return new VersionItemHolder(view);
    }

}
