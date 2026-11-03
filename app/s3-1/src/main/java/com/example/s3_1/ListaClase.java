package com.example.s3_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaClase extends AppCompatActivity {
    private ListView lvClase;
    private ArrayList<ClasaDeElevi> listaClase;
    private ClasaAdapter adapter;
    private ActivityResultLauncher<Intent> launcher;
    private int pozitieSelectata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clase);

        lvClase = findViewById(R.id.lvClase);

        listaClase = getIntent().getParcelableArrayListExtra("listaClase");

        adapter = new ClasaAdapter(this, listaClase);
        lvClase.setAdapter(adapter);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            ClasaDeElevi clasa = result.getData().getExtras().getParcelable("clasa");
                            listaClase.set(pozitieSelectata, clasa);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });

        lvClase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaClase.this, listaClase.get(position).toString(), Toast.LENGTH_LONG).show();

                pozitieSelectata = position;
                Intent intent = new Intent(ListaClase.this, AdaugaClasaActivity.class);
                intent.putExtra("clasa", listaClase.get(position));
                launcher.launch(intent);
            }
        });

        lvClase.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listaClase.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}