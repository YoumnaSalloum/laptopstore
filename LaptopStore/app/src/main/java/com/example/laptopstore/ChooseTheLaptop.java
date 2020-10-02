package com.example.laptopstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class ChooseTheLaptop extends AppCompatActivity {
    CheckBox acer;
    CheckBox asus;
    CheckBox dell;
    CheckBox hp;
    CheckBox lenova;
    CheckBox samsung;
    RadioButton four;
    RadioButton six;
    RadioButton eght;
    Button submit;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_the_laptop);
        acer = findViewById(R.id.acer);
        asus = findViewById(R.id.asus);
        dell = findViewById(R.id.dell);
        hp = findViewById(R.id.hp);
        lenova = findViewById(R.id.lenova);
        samsung = findViewById(R.id.samsung);
        /////////////////////////////////////////
        four = (RadioButton) findViewById(R.id.fRam);
        six = (RadioButton) findViewById(R.id.sRam);
        eght = (RadioButton) findViewById(R.id.eRam);
        submit = findViewById(R.id.submit);
        cancel = findViewById(R.id.cancel);
//////////////////////////////////////////////////
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalamount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");
                if (acer.isChecked()) {
                    result.append("\nacer 100Rs");
                    totalamount += 100;
                }
                if (asus.isChecked()) {
                    result.append("\nasus 50Rs");
                    totalamount += 50;
                }
                if (dell.isChecked()) {
                    result.append("\ndell 120Rs");
                    totalamount += 120;
                }
                if (hp.isChecked()) {
                    result.append("\nhp 300Rs");
                    totalamount += 300;
                }
                if (lenova.isChecked()) {
                    result.append("\nlenova 200Rs");
                    totalamount += 200;
                }
                if (samsung.isChecked()) {
                    result.append("\nsamsung 170Rs");
                    totalamount += 170;
                }


                result.append("\nTotal: " + totalamount + "Rs");
                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void show(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.fRam:
                if (checked)
                    // Pirates are the best
                    Toast.makeText(this, "dell and asus", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sRam:
                if (checked)
                    // Ninjas rule
                    Toast.makeText(this,"acer and lenova",Toast.LENGTH_LONG).show();
                break;
            case R.id.eRam:
                if (checked)
                    // Ninjas rule
                    Toast.makeText(this,"samsung and hp",Toast.LENGTH_LONG).show();
                break;


        }

    }

    public void cancel(View view) {
        Intent i=new Intent(ChooseTheLaptop.this,MainActivity.class);
        startActivity(i);
    this.finish();
    }
}
