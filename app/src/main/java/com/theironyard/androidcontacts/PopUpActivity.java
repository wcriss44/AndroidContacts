package com.theironyard.androidcontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PopUpActivity extends AppCompatActivity implements View.OnClickListener{

    TextView contact;
    Button remove;
    Button cancel;

    public PopUpActivity(String contact){

    }
    public PopUpActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.6), (int)(height*.6));

        contact = (TextView) findViewById(R.id.contactPopup);
        remove = (Button) findViewById(R.id.removeButton);
        cancel = (Button) findViewById(R.id.cancelButton);
        contact.setText(getIntent().getStringExtra("contact"));
        remove.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v == remove ){
            Intent intent = new Intent();
            intent.putExtra("contact", contact.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        } else if ( v == cancel){
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }

}
