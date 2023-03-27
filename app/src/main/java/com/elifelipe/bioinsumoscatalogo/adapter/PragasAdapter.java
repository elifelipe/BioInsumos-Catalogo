package com.elifelipe.bioinsumoscatalogo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.elifelipe.bioinsumoscatalogo.R;
import com.elifelipe.bioinsumoscatalogo.model.Pragas;

import java.util.Arrays;
import java.util.List;

public class PragasAdapter extends RecyclerView.Adapter<PragasAdapter.PragasViewHolder> {

    private List<Pragas> mPragasList;

    public PragasAdapter(List<Pragas> pragasList) {
        mPragasList = pragasList;
    }

    @Override
    public PragasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_pragas, parent, false);
        return new PragasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PragasViewHolder holder, int position) {
        Pragas pragas = mPragasList.get(position);
        holder.culturaTextView.setText(pragas.cultura);
        holder.nomeCientificoTextView.setText(pragas.nomeCientifico);
        holder.nomeComumTextView.setText(Arrays.toString(pragas.nomeComum));
    }

    @Override
    public int getItemCount() {
        return mPragasList.size();
    }

    public class PragasViewHolder extends RecyclerView.ViewHolder {
        public TextView culturaTextView;
        public TextView nomeCientificoTextView;
        public TextView nomeComumTextView;

        public PragasViewHolder(View itemView) {
            super(itemView);
            culturaTextView = itemView.findViewById(R.id.cultura_text_view);
            nomeCientificoTextView = itemView.findViewById(R.id.nome_cientifico_text_view);
            nomeComumTextView = itemView.findViewById(R.id.nome_comum_text_view);
        }
    }
}
