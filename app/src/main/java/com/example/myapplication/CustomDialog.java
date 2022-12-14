package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;



public class CustomDialog extends Dialog  implements  View.OnClickListener {

    private Button Button2;
    private Button Button3;
    private EditText fname;
    private EditText aname;
    private Context context;


    private CustomDialogListener customDialogListener;

    public CustomDialog(Context context) {
        super(context);
        this.context = context;
    }
    interface CustomDialogListener{
        void onPositiveClicked( String fname, String aname);
        void onNegativeClicked();
    }
    public void setDialogListener(CustomDialogListener customDialogListener){
        this.customDialogListener = customDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_custom);

        Button2=(Button) findViewById(R.id.button2);
        Button3=(Button) findViewById(R.id.button3);
        fname=(EditText) findViewById(R.id.ED1);
        aname=(EditText) findViewById(R.id.ED2);
        Button2.setOnClickListener(this);
        Button3.setOnClickListener(this);
        
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                String name=fname.getText().toString();
                String allergy=aname.getText().toString();

                customDialogListener.onPositiveClicked(name,allergy);
                dismiss();
                break;
            case R.id.button3:
                cancel();
                break;
        }
    }
}
