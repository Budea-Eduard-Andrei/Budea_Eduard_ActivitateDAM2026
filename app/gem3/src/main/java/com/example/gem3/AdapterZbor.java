package com.example.gem3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterZbor extends BaseAdapter {
    private List<Zbor> lista;
    private Context context;
    private int resLayout;

    public AdapterZbor(List<Zbor> lista, Context context, int resLayout) {
        this.lista = lista;
        this.context = context;
        this.resLayout = resLayout;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resLayout,parent,false);

        TextView tvId = view.findViewById(R.id.budea_eduard_tv_ID);
        TextView tvPret = view.findViewById(R.id.budea_eduard_tv_Pret);

        Zbor zbor = (Zbor) getItem(position);

        tvId.setText("ID: " + zbor.getIdZbor());
        tvPret.setText("Pret: " + zbor.getPretBilet());

        return view;
    }
}
