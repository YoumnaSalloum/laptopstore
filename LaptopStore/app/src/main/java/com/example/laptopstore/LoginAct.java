package com.example.laptopstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAct extends AppCompatActivity {
    Button b;
    EditText pass;
    EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b = (Button) findViewById(R.id.button_login);
        pass = (EditText) findViewById(R.id.edittext_password);
        user = (EditText) findViewById(R.id.edittext_username);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void login() {
        String p = pass.getText().toString();
        String u = user.getText().toString();

        Log.i("pass",p);
        Log.i("pass",u);
        if (p.equals("youmna1998") && u.equals("youmna")) {
            Toast.makeText(this, "username and password matched..", Toast.LENGTH_SHORT).show();
            Intent HomePage = new Intent(LoginAct.this,ChooseTheLaptop.class);
            startActivity(HomePage);

        } else
            Toast.makeText(this, "username and password do not matched.. !!!", Toast.LENGTH_SHORT).show();


    }
}
