package com.example.gem4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterFIlm extends BaseAdapter {
    private List<Film> lista;
    private Context context;
    private int resLayout;

    public AdapterFIlm(List<Film> lista, Context context, int resLayout) {
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
        TextView tvTitlu = view.findViewById(R.id.budea_eduard_tv_titlu);

        Film film = (Film) getItem(position);

        tvId.setText("ID: " + film.getIdFilm());
        tvTitlu.setText("Titlu: " + film.getTitlu());

        return view;
    }
}
