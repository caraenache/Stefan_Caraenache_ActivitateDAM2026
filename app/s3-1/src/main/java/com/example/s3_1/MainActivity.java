package com.example.s3_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvClasa;
    private ActivityResultLauncher<Intent> launcher;
    private ArrayList<ClasaDeElevi> listaClase = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvClasa = findViewById(R.id.tvClasa);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            Bundle bundle = result.getData().getExtras();
                            ClasaDeElevi clasa = bundle.getParcelable("clasa");

                            listaClase.add(clasa);

                            tvClasa.setText(clasa.toString());
                            Toast.makeText(MainActivity.this,
                                    "Clase în listă: " + listaClase.size(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        Button btnAdauga = findViewById(R.id.btnAdauga);
        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdaugaClasaActivity.class);
                launcher.launch(intent);
            }
        });

        Button btnLista = findViewById(R.id.btnLista);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaClase.class);
                intent.putParcelableArrayListExtra("listaClase", listaClase);
                startActivity(intent);
            }
        });
    }
}