package com.example.laptopstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class AddToCartShopping extends AppCompatActivity {
RecyclerView rvc;
HashSet<lap> ar;
SharedPreference sh;
Adapter adapter;
ArrayList<lap>arr;
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart_shopping);
        rvc=findViewById(R.id.rvcart);
        t=findViewById(R.id.tv1);
        rvc.setLayoutManager(new LinearLayoutManager(this));
        rvc.setHasFixedSize(true);
        arr=new ArrayList<>();
        sh=new SharedPreference();
        arr=sh.getFavorites(AddToCartShopping.this);
        adapter=new Adapter(arr,AddToCartShopping.this);
        rvc.setAdapter(adapter);
        t.setText("Total is : 3000");


    }
}
