package com.example.s3_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Imagini extends AppCompatActivity {
    private List<ImaginiDomeniu> lista = new ArrayList<>();
    private List<Bitmap> imagini = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagini);

        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://p1.akcdn.net/full/772553766.optoma-w400lve.jpg");
        linkuriImagini.add("https://www.officedirect.ro/image/catalog/blog-imagini/15amenajare-sala-de-clasa.jpg");
        linkuriImagini.add("https://upload.wikimedia.org/wikipedia/commons/9/90/Banca_%28Germania%29_-_2008.jpg");
        linkuriImagini.add("https://upload.wikimedia.org/wikipedia/commons/2/2a/Schema_mansarda_vs_etaj.jpg");
        linkuriImagini.add("https://thumbs.dreamstime.com/b/profesor-de-liceu-%C8%9Bine-o-lec%C8%9Bie-cu-elevii-ridic%C3%A2nd-m%C3%A2inile-41532403.jpg");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (String link : linkuriImagini) {
                    HttpURLConnection con = null;
                    try {
                        URL url = new URL(link);
                        con = (HttpURLConnection) url.openConnection();
                        con.setRequestProperty("User-Agent", "ClaseApp/1.0");
                        InputStream is = con.getInputStream();
                        imagini.add(BitmapFactory.decodeStream(is));
                    } catch (IOException e) {
                        imagini.add(null);
                    } finally {
                        if (con != null) {
                            con.disconnect();
                        }
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        lista.add(new ImaginiDomeniu("Videoproiector", imagini.get(0), "https://en.wikipedia.org/wiki/Video_projector"));
                        lista.add(new ImaginiDomeniu("Sală de clasă", imagini.get(1), "https://en.wikipedia.org/wiki/Classroom"));
                        lista.add(new ImaginiDomeniu("Bancă", imagini.get(2), "https://en.wikipedia.org/wiki/Desk"));
                        lista.add(new ImaginiDomeniu("Etaj", imagini.get(3), "https://en.wikipedia.org/wiki/Storey"));
                        lista.add(new ImaginiDomeniu("Elevi", imagini.get(4), "https://en.wikipedia.org/wiki/Student"));

                        ListView lv = findViewById(R.id.imagini);
                        ImagineAdapter adapter = new ImagineAdapter(getApplicationContext(), R.layout.imagine_layout, lista);
                        lv.setAdapter(adapter);
                    }
                });
            }
        });

        ListView lv = findViewById(R.id.imagini);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(getApplicationContext(), DeschideWeb.class);
                it.putExtra("link", lista.get(i).getLink());
                startActivity(it);
            }
        });
    }
}