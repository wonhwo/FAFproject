package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class food1Activity extends AppCompatActivity{
    String Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food1);

        Intent intent=getIntent();
        Name=intent.getExtras().getString("1");

        ActionBar ac = getSupportActionBar();
        ac.setTitle("음식추천");

        Button b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(getApplicationContext(),list1Activity.class);
            public void onClick(View v) {
                intent.putExtra("1",Name);
                startActivity(intent);

            }
        });
        Button b2=(Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(getApplicationContext(),list2Activity.class);
            public void onClick(View v) {
                intent.putExtra("1",Name);
                startActivity(intent);

            }
        });
        Button b3=(Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(getApplicationContext(),list3Activity.class);
            public void onClick(View v) {
                intent.putExtra("1",Name);
                startActivity(intent);

            }
        });
        Button b4=(Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(getApplicationContext(),list4Activity.class);
            public void onClick(View v) {
                intent.putExtra("1",Name);
                startActivity(intent);

            }
        });
        Button b5=(Button) findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(getApplicationContext(),list5Activity.class);
            public void onClick(View v) {
                intent.putExtra("1",Name);
                startActivity(intent);

            }
        });

    }
}
