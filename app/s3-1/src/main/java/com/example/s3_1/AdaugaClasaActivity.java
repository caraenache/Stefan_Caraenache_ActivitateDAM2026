package com.example.s3_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AdaugaClasaActivity extends AppCompatActivity {
    private EditText etNrBanci;
    private CheckBox cbAreProiector;
    private Spinner spEtaj;
    private Button btnSalveaza;
    private ClasaDeElevi clasaDeEditat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_clasa);

        etNrBanci = findViewById(R.id.etNrBanci);
        cbAreProiector = findViewById(R.id.cbAreProiector);
        spEtaj = findViewById(R.id.spEtaj);
        btnSalveaza = findViewById(R.id.btnSalveaza);

        clasaDeEditat = getIntent().getParcelableExtra("clasa");

        if (clasaDeEditat != null) {
            etNrBanci.setText(String.valueOf(clasaDeEditat.getNrBanci()));
            cbAreProiector.setChecked(clasaDeEditat.isAreProiector());
            spEtaj.setSelection(clasaDeEditat.getEtaj());
        }

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nrBanci = Integer.parseInt(etNrBanci.getText().toString());
                boolean areProiector = cbAreProiector.isChecked();
                int etaj = spEtaj.getSelectedItemPosition();

                ClasaDeElevi clasa;
                if (clasaDeEditat == null) {
                    clasa = new ClasaDeElevi(nrBanci, areProiector, etaj);
                } else {
                    clasa = clasaDeEditat;
                    clasa.setNrBanci(nrBanci);
                    clasa.setAreProiector(areProiector);
                    clasa.setEtaj(etaj);
                }

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelable("clasa", clasa);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}