package com.example.activitate_seminar4;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BaterieAdapter extends BaseAdapter {
    private List<Baterie> baterii = null;
    private Context ctx;
    private int resursaLayout;

    public BaterieAdapter(Context ctx, int resursaLayout, List<Baterie> baterii) {
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
        this.baterii = baterii;
    }


    @Override
    public int getCount() {
        return baterii.size();
    }

    @Override
    public Object getItem(int position) {
        return baterii.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout,parent,false);

        TextView tvMarca = v.findViewById(R.id.tvMarca);
        TextView tvCapacitate = v.findViewById(R.id.tvCapacitate);
        TextView tvFastCharge = v.findViewById(R.id.tvFastCharge);

        Baterie baterie = (Baterie) getItem(position);
        tvMarca.setText(baterie.getMarca());
        tvCapacitate.setText("Capacitate: " + baterie.getCapacitate() + " mAh");

        if(baterie.isEsteReincarcabila()){
            tvFastCharge.setText("Fast Charge: Da");
        }else{
            tvFastCharge.setText("Fast Charge: Nu");
        }

        return v;
    }
}
