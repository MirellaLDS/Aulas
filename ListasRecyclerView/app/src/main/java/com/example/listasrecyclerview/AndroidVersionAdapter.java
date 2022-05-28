package com.example.listasrecyclerview;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AndroidVersionAdapter extends RecyclerView.Adapter<VersionItemHolder> {

    private List<String> versionData;
    private String[] colors;

    /**
     * Inicialize o conjunto de dados do Adaptador.
     *
     * @param versionData List<String> contendo os dados para preencher as visualizações a serem usadas
     * pelo RecyclerView.
     *
     * @param colors String[] contendo as cores para personalizar o background de cada item na listagem.
     */
    public AndroidVersionAdapter(List<String> versionData, String[] colors) {
        this.versionData = versionData;
        this.colors = colors;
    }

    // Adiciona mais itens a lista de Strings
    public void setVersionData(List<String> versionData) {
        this.versionData = versionData;
    }

    // Retorna a cor que deve ser definada no background do item
    private String getColor(int position) {
        return colors[position];
    }

    // Criar novas visualizações (invocadas pelo layout manager)
    @NonNull
    @Override
    public VersionItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return VersionItemHolder.createHolder(parent);
    }

    // Substituir o conteúdo de uma visualização (chamada pelo layout manager)
    @Override
    public void onBindViewHolder(@NonNull VersionItemHolder holder, int position) {
        // Obtém o elemento do seu conjunto de dados nesta posição e manda para o fixador (ItemViewHolder)
        holder.preencherItem(versionData.get(position), colors[position]);
    }

    // Retorne o tamanho do seu conjunto de dados (invocado pelo layout manager)
    @Override
    public int getItemCount() {
        return versionData.size();
    }
}
