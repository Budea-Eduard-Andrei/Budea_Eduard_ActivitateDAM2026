package com.example.gem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class LaptopAdapter extends BaseAdapter {
    private List<Laptop> laptouri;
    private Context context;
    private int resLayout;

    public LaptopAdapter(List<Laptop> laptouri, Context context, int resLayout) {
        this.laptouri = laptouri;
        this.context = context;
        this.resLayout = resLayout;
    }

    @Override
    public int getCount() {
        return laptouri.size();
    }

    @Override
    public Object getItem(int position) {
        return laptouri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resLayout,parent,false);

        TextView tvID = view.findViewById(R.id.budea_eduard_tv_id);
        TextView tvPret = view.findViewById(R.id.budea_eduard_tv_pret);

        Laptop laptop = (Laptop) getItem(position);

        tvID.setText("ID-ul este: " + laptop.getIdLaptop());
        tvPret.setText("Pretul este: " + laptop.getPret() + " lei");

        return view;
    }
}
