package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int a = 1;
    int b=1;
    String Name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ac = getSupportActionBar();
        ac.setTitle("Home");
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b1.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                CustomDialog3 dialog2 = new CustomDialog3(this);
                dialog2.show();


                break;


            default:
        }
        return super.onOptionsItemSelected(item);
    }

    public void OnClickHandler() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("경고").setMessage("먹지 못하는 음식이나 알레르기가 있으면 조건 검색을 이용하여 주세요!");

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }
    public void OnClickHandler2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("정보").setMessage("음식 알레르기 정보를 더 알고 싶으시다면 오른쪽 상단의 물음표를 클릭해주세요!");

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, food1Activity.class);
        switch (v.getId()) {
            case R.id.b1:
                if(a==1){
                    OnClickHandler();
                    a=0;
                }
                else if(a==0){
                    intent.putExtra("1",Name);
                    startActivity(intent);
                }
                break;

                case R.id.b2:
                    if (Name=="") {
                        if(b==1){OnClickHandler2();b=0;}
                        else{
                    CustomDialog2 dialog = new CustomDialog2(this);
                    dialog.setDialogListener(new CustomDialog2.CustomDialogListener() {
                        public void onPositiveClicked(String name) {
                            Name = name;
                        }

                        @Override
                        public void onNegativeClicked() {

                        }
                    });
                        dialog.show();
                        }
                    }
                    else{

                        intent.putExtra("1",Name);
                        startActivity(intent);
                    }
                    break;





        }


    }

    }