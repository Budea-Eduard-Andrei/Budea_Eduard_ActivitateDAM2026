package com.example.pb2_grup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TabletaAdapter extends BaseAdapter {
    private List<Tableta> tablete;
    private Context context;
    private int resursaLayout;

    public TabletaAdapter(List<Tableta> tablete, Context context, int resursaLayout) {
        this.tablete = tablete;
        this.context = context;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return tablete.size();
    }

    @Override
    public Object getItem(int position) {
        return tablete.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resursaLayout,parent,false);

        TextView tvModel = view.findViewById(R.id.budea_eduard_tv_item_model);
        TextView tvMemorie = view.findViewById(R.id.budea_eduard_tv_item_memorie);

        Tableta tabletaCurenta = (Tableta) getItem(position);

        tvModel.setText("Model: " + tabletaCurenta.getModel());
        tvMemorie.setText("Memorie: " + tabletaCurenta.getSpatiuMemorie() + " GB");

        return view;
    }
}
