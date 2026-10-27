package com.example.s3_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaClase extends AppCompatActivity {
    private ListView lvClase;
    private ArrayList<ClasaDeElevi> listaClase;
    private ArrayAdapter<ClasaDeElevi> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clase);

        lvClase = findViewById(R.id.lvClase);

        listaClase = getIntent().getParcelableArrayListExtra("listaClase");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClase);
        lvClase.setAdapter(adapter);

        lvClase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClasaDeElevi clasa = listaClase.get(position);
                Toast.makeText(ListaClase.this, clasa.toString(), Toast.LENGTH_LONG).show();
            }
        });

        lvClase.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listaClase.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(ListaClase.this, "Clasa a fost ștearsă", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}