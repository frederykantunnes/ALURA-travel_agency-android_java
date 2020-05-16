package br.com.frederykantunnes.aluraviagens.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import br.com.frederykantunnes.aluraviagens.R;
import br.com.frederykantunnes.aluraviagens.model.Pacote;
import br.com.frederykantunnes.aluraviagens.util.FormatDiaUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacoteList;
    private Context context;
    public ListaPacotesAdapter(List<Pacote> pacoteList, Context context) {
        this.pacoteList = pacoteList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacoteList.size();
    }

    @Override
    public Object getItem(int position) {
        return pacoteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pacoteList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View viewCriada =  LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
        setData(position, viewCriada);
        return viewCriada;
    }

    @SuppressLint("SetTextI18n")
    private void setData(int position, View viewCriada) {
        TextView cidade = viewCriada.findViewById(R.id.item_cidade);
        TextView dias = viewCriada.findViewById(R.id.item_dias);
        TextView valor = viewCriada.findViewById(R.id.item_valor);
        ImageView imagem = viewCriada.findViewById(R.id.item_image);
        cidade.setText(pacoteList.get(position).getCidade());
        dias.setText(pacoteList.get(position).getDias()+ FormatDiaUtil.getDiasFormat(pacoteList.get(position).getDias()));
        valor.setText(pacoteList.get(position).getValor());
        imagem.setImageResource(R.drawable.recife);
    }


}
