package com.elifelipe.bioinsumoscatalogo.adapter;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.elifelipe.bioinsumoscatalogo.R;
import com.elifelipe.bioinsumoscatalogo.model.Data;
import com.elifelipe.bioinsumoscatalogo.model.Pragas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterBiologicos extends RecyclerView.Adapter<AdapterBiologicos.DataViewHolder> {

    private List<Data> dataList = new ArrayList<>();

    public AdapterBiologicos(List<Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_biologicos, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.registroProdutoTextView.setText(data.registroProduto);
        holder.marcaComercialTextView.setText(data.marcaComercial);
        holder.titularRegistroTextView.setText(data.titularRegistro);
        holder.ingredienteAtivo.setText(data.ingredienteAtivo);



        String[] array = data.classes;
        String textoSemColchetes = String.join(", ", array);


        holder.classesTextView.setText(textoSemColchetes);
        boolean aprovado;
        aprovado = Boolean.parseBoolean(data.aprovadoParaAgriculturaOrganica);

        if (aprovado == true){
            data.aprovadoParaAgriculturaOrganica = "Sim";
        }else {
            data.aprovadoParaAgriculturaOrganica = "Não";
        }
        holder.aprovadoParaAgriculturaOrganicaTextView.setText(data.aprovadoParaAgriculturaOrganica);
        holder.classificacaoToxicologicaTextView.setText(data.classificacaoToxicologica);
        holder.classificacaoAmbientalTextView.setText(data.classificacaoAmbiental);

        String link = data.url;
        String text = "Visite o site";
        String htmlLink = "<a href='" + link + "'>" + text + "</a>";
        holder.urlTextView.setText(Html.fromHtml(htmlLink));
        holder.urlTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // Exibindo dados da lista de pragas
        StringBuilder pragasText = new StringBuilder();
        for (Pragas p : data.pragas) {
            pragasText.append(p.cultura).append(", ");
            pragasText.append(p.nomeCientifico).append(", ");

            String arrays[] = p.nomeComum;

            pragasText.append(Arrays.toString(arrays)).append(", ");
        }
        holder.pragasTextView.setText(pragasText.toString());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        public TextView registroProdutoTextView;
        public TextView marcaComercialTextView;
        public TextView titularRegistroTextView;
        public TextView ingredienteAtivo;
        public TextView classesTextView;
        public TextView aprovadoParaAgriculturaOrganicaTextView;
        public TextView classificacaoToxicologicaTextView;
        public TextView classificacaoAmbientalTextView;

        public TextView urlTextView;
        public TextView pragasTextView;

        public DataViewHolder(View itemView) {
            super(itemView);
            registroProdutoTextView = itemView.findViewById(R.id.registro_produto_textview);
            marcaComercialTextView = itemView.findViewById(R.id.marca_comercial_textview);
            titularRegistroTextView = itemView.findViewById(R.id.titular_registro_textview);
            ingredienteAtivo = itemView.findViewById(R.id.ingrediente_ativo_textview);
            classesTextView = itemView.findViewById(R.id.classes_textview);
            aprovadoParaAgriculturaOrganicaTextView = itemView.findViewById(R.id.aprovado_agricultura_organica_textview);
            classificacaoToxicologicaTextView = itemView.findViewById(R.id.classificacao_toxicologica_textview);
            classificacaoAmbientalTextView = itemView.findViewById(R.id.classificacao_ambiental_textview);
            urlTextView = itemView.findViewById(R.id.url_textview);
            pragasTextView = itemView.findViewById(R.id.pragas_text);
        }
    }
}