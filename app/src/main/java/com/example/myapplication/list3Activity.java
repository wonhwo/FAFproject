package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class list3Activity extends AppCompatActivity implements View.OnClickListener{
    private static final int PICK_FROM_ALBUM = 1;
    private static final int REQUEST_CODE = 0;
    int b=0;
    ArrayList<FoodData> foodDatalist;
    List<String> s1=new ArrayList<String>(){{add("규동");add("초밥");add("스키야키");}};
    List<String> s2=new ArrayList<String>(){{add("소고기");add("해산물");add("소고기");}};
    List<Integer> s3=new ArrayList<Integer>(){{add(R.drawable.jfp);add(R.drawable.jp);add(R.drawable.jpf3);}};
    String Name="", Allergy,ifAllergy;
    Bitmap Img;
    Uri uri;
    File tempFile;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listko);
        ActionBar ac = getSupportActionBar();


        Intent intent=getIntent();
        ifAllergy=intent.getExtras().getString("1");
        this.InitializeFoodData();
        ac.setTitle("일식");




        ListView listView=(ListView) findViewById(R.id.list);

        final MyAdapter myAdapter=new MyAdapter(this,foodDatalist);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),myAdapter.getItem(position).getFoodA(),Toast.LENGTH_LONG).show();
            }
        });
        Button button=(Button) findViewById(R.id.btn_add);
        Button button2=(Button) findViewById(R.id.btn_delete);
        Button button3=(Button) findViewById(R.id.delete);
        button.setOnClickListener(this);button2.setOnClickListener(this);
        Button button1=(Button) findViewById(R.id.btn_restart);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Name!="") {
                    if(Name.equals(ifAllergy)){OnClickHandler();
                        Name = "";
                        Allergy="";}
                    else{
                        foodDatalist.add(new FoodData(R.drawable.defaultimg, Name,Allergy));
                        myAdapter.notifyDataSetChanged();
                        b++;
                        Name = "";}

                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check, count= myAdapter.getCount();
                if (count>0){
                    check = listView.getCheckedItemPosition();
                    if (check>-1 && check<count){
                        foodDatalist.remove(check);
                        listView.clearChoices();
                        myAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                CustomDialog dialog = new CustomDialog(this);
                dialog.setDialogListener(new CustomDialog.CustomDialogListener() {
                    @Override
                    public void onPositiveClicked(String name, String allergy) {
                        Name=name;
                        Allergy=allergy;
                        s1.add(Name);
                        s2.add(Allergy);

                    }

                    @Override
                    public void onNegativeClicked() {

                    }
                });
                dialog.show();
                break;
            case R.id.btn_delete:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_ALBUM) {

            Uri photoUri = data.getData();

            Cursor cursor = null;

            try {

                /*
                 *  Uri 스키마를
                 *  content:/// 에서 file:/// 로  변경한다.
                 */
                String[] proj = {MediaStore.Images.Media.DATA};

                assert photoUri != null;
                cursor = getContentResolver().query(photoUri, proj, null, null, null);

                assert cursor != null;
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                cursor.moveToFirst();

                tempFile = new File(cursor.getString(column_index));

            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }

        }
    }


    public  void InitializeFoodData(){
        foodDatalist=new ArrayList<FoodData>();
        for (int i=1;i<=s1.size();i++) {
            if(s2.get(b).equals(ifAllergy)){b++;continue;}
            else{foodDatalist.add(new FoodData(s3.get(b), s1.get(b), s2.get(b)));
                b++;}

        }

    }
    public void OnClickHandler() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("경고").setMessage("원하지 않는 성분이 포함 되어 있습니다.");

        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

}
