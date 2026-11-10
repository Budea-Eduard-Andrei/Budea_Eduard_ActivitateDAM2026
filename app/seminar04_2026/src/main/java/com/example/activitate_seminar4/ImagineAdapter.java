package com.example.activitate_seminar4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ImagineAdapter extends BaseAdapter {
    private Context ctx;
    private int resursaLayout;
    private List<ImaginiDomeniu> lista;

    public ImagineAdapter(Context ctx, int resursaLayout, List<ImaginiDomeniu> lista) {
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
        this.lista = lista;
    }

    @Override
    public int getCount() { return lista.size(); }
    @Override
    public Object getItem(int position) { return lista.get(position); }
    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        ImageView imagineIV = v.findViewById(R.id.imagineIV);
        TextView textDescriereTV = v.findViewById(R.id.textDescriereTV);

        ImaginiDomeniu element = (ImaginiDomeniu) getItem(position);
        imagineIV.setImageBitmap(element.getImagine());
        textDescriereTV.setText(element.getTextAfisat());

        return v;
    }
}