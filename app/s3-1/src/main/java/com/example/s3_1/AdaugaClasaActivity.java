package com.example.s3_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdaugaClasaActivity extends AppCompatActivity {
    private EditText etNrBanci;
    private CheckBox cbAreProiector;
    private Spinner spEtaj;
    private Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_clasa);

        etNrBanci = findViewById(R.id.etNrBanci);
        cbAreProiector = findViewById(R.id.cbAreProiector);
        spEtaj = findViewById(R.id.spEtaj);
        btnSalveaza = findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etNrBanci.getText().toString().trim();
                if (text.isEmpty()) {
                    Toast.makeText(AdaugaClasaActivity.this, "Completează numărul de bănci!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int nrBanci = Integer.parseInt(text);
                boolean areProiector = cbAreProiector.isChecked();
                int etaj = spEtaj.getSelectedItemPosition();

                ClasaDeElevi clasa = new ClasaDeElevi(nrBanci, areProiector, etaj);

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