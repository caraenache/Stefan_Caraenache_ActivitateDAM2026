package com.example.s2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateRezultata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_rezultata);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it=getIntent();
        Bundle bundle = it.getExtras();
        String mesaj = bundle.getString("mesaj", "");
        int nr1 = bundle.getInt("nr1", 0);
        int nr2 = bundle.getInt("nr2", 0);

        Toast.makeText(this, mesaj, Toast.LENGTH_SHORT).show();

    }

//    public void openActivity(View view) {
//        Intent it = new Intent(this, ActivitateRezultata.class);
//        startActivity(it);
//    }
}