package com.example.laptopstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashSet;

public class LapActivity extends AppCompatActivity {
    HashSet<lap> h;
    TextView tt, td;
    ImageView i;
    ImageButton ib;
    SharedPreference sharedPreference;
    lap yomna;
    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lap);



        h = new HashSet<>();
        tt = (TextView) findViewById(R.id.tvlap);
        td = (TextView) findViewById(R.id.tvlapdes);
        i = (ImageView) findViewById(R.id.ivlap);
        ib = (ImageButton) findViewById(R.id.ibaddcart);
        sharedPreference = new SharedPreference();
        Intent in = getIntent();
        final String name = in.getExtras().getString("Tiltle");
        String des = in.getExtras().getString("des");
        int iv = in.getExtras().getInt("iv");
        tt.setText(name);
        td.setText(des);
        i.setImageResource(iv);



        yomna = new lap(name, iv, des);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                ArrayList<lap> hashSet ;
                hashSet=sharedPreference.getFavorites(LapActivity.this);
                if(hashSet.size()!=0){
                for (int i = 0; i < hashSet.size(); i++) {
                    if (!(hashSet.get(i).getName().equals(name))) {
                        count++;
                        if (count == hashSet.size()) {
                            sharedPreference.addFavorite(LapActivity.this, yomna);
                        }
                    }
                }

            }
            else sharedPreference.addFavorite(LapActivity.this, yomna);
            }
        });
    }
}