package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView list;
    DatabaseHelper db;
    SQLiteDatabase sql;
    Cursor cu;
    adapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list=findViewById(R.id.list);
        db=new DatabaseHelper(this);
        sql=db.getReadableDatabase();
        cu=db.getData();
        adapt=new adapter(getApplicationContext(),R.layout.list);
        list.setAdapter(adapt);
        if(cu.moveToFirst())
        {
            do{
                String id,name,email,number,deg,skill;
                id=cu.getString(0);
                name=cu.getString(1);
                email=cu.getString(2);
                number=cu.getString(3);
                deg=cu.getString(4);
                skill=cu.getString(5);

                data da=new data(id,name,email,number,deg,skill);
                adapt.add(da);

            }while(cu.moveToNext());
        }

    }
}