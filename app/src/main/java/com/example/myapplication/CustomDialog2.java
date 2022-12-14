package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CustomDialog2 extends Dialog  implements  View.OnClickListener {

    private Button Button1;
    private Button Button2;
    private EditText mesgase;
    private Context context;


    private CustomDialogListener customDialogListener;

    public CustomDialog2(Context context) {
        super(context);
        this.context = context;
    }
    interface CustomDialogListener{
        void onPositiveClicked( String name);
        void onNegativeClicked();
    }
    public void setDialogListener(CustomDialogListener customDialogListener){
        this.customDialogListener = customDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        Button1=(Button) findViewById(R.id.cb1);
        Button2=(Button) findViewById(R.id.cb2);
        mesgase=(EditText) findViewById(R.id.mesgase);
        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cb1: //확인 버튼을 눌렀을 때
                //각각의 변수에 EidtText에서 가져온 값을 저장
                String name = mesgase.getText().toString();
                //인터페이스의 함수를 호출하여 변수에 저장된 값들을 Activity로 전달
                customDialogListener.onPositiveClicked(name);
                dismiss();

                break;
            case R.id.cb2: //취소 버튼을 눌렀을 때
                cancel();
                break;
        }
    }
}
