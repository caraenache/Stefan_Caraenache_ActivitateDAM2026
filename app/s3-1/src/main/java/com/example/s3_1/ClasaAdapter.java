package com.example.s3_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ClasaAdapter extends ArrayAdapter<ClasaDeElevi> {

    public ClasaAdapter(Context context, ArrayList<ClasaDeElevi> lista) {
        super(context, 0, lista);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_clasa, parent, false);
        }

        ClasaDeElevi clasa = getItem(position);

        TextView tvEtaj = convertView.findViewById(R.id.tvEtaj);
        TextView tvBanci = convertView.findViewById(R.id.tvBanci);
        TextView tvProiector = convertView.findViewById(R.id.tvProiector);

        String[] etaje = getContext().getResources().getStringArray(R.array.etaj);

        tvEtaj.setText(etaje[clasa.getEtaj()]);
        tvBanci.setText("Bănci: " + clasa.getNrBanci());
        tvProiector.setText("Proiector: " + (clasa.isAreProiector() ? "Da" : "Nu"));

        return convertView;
    }
}