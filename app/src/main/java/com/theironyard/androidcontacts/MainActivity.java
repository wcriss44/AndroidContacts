package com.theironyard.androidcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    ArrayAdapter<String> contacts;

    EditText name;
    EditText phone;
    Button add;
    ListView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nameText);
        phone = (EditText) findViewById(R.id.phoneText);
        add = (Button) findViewById(R.id.addButton);
        contactList = (ListView) findViewById(R.id.listView) ;

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        contactList.setAdapter(contacts);

        add.setOnClickListener(this);
        contactList.setOnItemLongClickListener(this);

    }

    @Override
    public void onClick(View v){
        String contact = String.format("Name: %s \t Phone: %s", name.getText().toString(), phone.getText().toString());
        contacts.add(contact);
        name.setText("");
        phone.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parents, View view, int position, long id){
        String contact = contacts.getItem(position);
        contacts.remove(contact);
        return true;
    }
}
