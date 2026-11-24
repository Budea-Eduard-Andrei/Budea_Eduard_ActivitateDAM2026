package com.example.gem2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterMasina extends BaseAdapter {
    private List<Masina> lista;
    private Context context;
    private int resLayout;

    public AdapterMasina(List<Masina> lista, Context context, int resLayout) {
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
        TextView tvMarca = view.findViewById(R.id.budea_eduard_tv_Model);

        Masina masina = (Masina) getItem(position);

        tvId.setText("Id: " + masina.getCodMasina());
        tvMarca.setText(("Marca: " + masina.getMarca()));

        return view;
    }
}
