package com.example.tir_afdhal.sqlite_app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
//    EditText editText = (EditText) findViewById(R.id.editText);
//    TextView textView = (TextView) findViewById(R.id.textView);
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        dbHandler = new DBHandler(this, null, null, 1);

        final Button addButt = (Button) findViewById(R.id.button_add);
        final Button delButt = (Button) findViewById(R.id.button_delete);
        printDB();

        addButt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Products prod = new Products(editText.getText().toString(),1);
                dbHandler.addProduct(prod);
                printDB();
            }
        });

        delButt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String prodName = editText.getText().toString();
                dbHandler.deleteProduct(prodName);
                printDB();
            }
        });

    }

//    public void addButton_Click(){
//        Products prod = new Products(textView.getText().toString(),1);
//        dbHandler.addProduct(prod);
//        printDB();
//    }
//
//    public void deleteButton_Click(){
//        String prodName = editText.getText().toString();
//        dbHandler.deleteProduct(prodName);
//        printDB();
//    }

    public void printDB(){
        String dbString = dbHandler.databaseToString();
        textView.setText(dbString);
        editText.setText("");
    }



}
