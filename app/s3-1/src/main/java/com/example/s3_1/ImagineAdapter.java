package com.example.s3_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImagineAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ImaginiDomeniu> lista;

    public ImagineAdapter(Context context, int layout, List<ImaginiDomeniu> lista) {
        this.context = context;
        this.layout = layout;
        this.lista = lista;
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        }

        ImaginiDomeniu item = lista.get(position);

        ImageView imagineIV = convertView.findViewById(R.id.imagineIV);
        TextView textTV = convertView.findViewById(R.id.textTV);

        imagineIV.setImageBitmap(item.getImagine());
        textTV.setText(item.getTextAfisat());

        return convertView;
    }
}