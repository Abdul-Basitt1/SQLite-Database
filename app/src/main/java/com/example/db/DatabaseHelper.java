package com.example.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="std_table";
    public static final String Col_1= "ID";
    public static final String Col_2= "NAME";
    public static final String Col_3= "EMAIL";
    public static final String Col_4= "NUMBER";
    public static final String Col_5= "DESCRIPTION";
    public static final String Col_6= "DEGREE";
    public static final String Col_7= "SKILLS";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" ( ID INTEGER PRIMARY KEY , NAME TEXT, EMAIL TEXT,"+"NUMBER INTEGER,DESCRIPTION TEXT,DEGREE TEXT,SKILLS TEXT)");
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData( String id, String name, String email, String number, String description, String degree,String skill)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues con=new ContentValues();
        con.put(Col_1,id);
        con.put(Col_2,name);
        con.put(Col_3,email);
        con.put(Col_4,number);
        con.put(Col_5,description);
        con.put(Col_6,degree);
        con.put(Col_7,skill);
        long result=db.insert(TABLE_NAME,null,con);
        if(result==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+ TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String id,String name, String email, String number, String description, String degree,String skill) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put(Col_1,id);
        con.put(Col_2,name);
        con.put(Col_3,email);
        con.put(Col_4,number);
        con.put(Col_5,description);
        con.put(Col_6,degree);
        con.put(Col_7,skill);
        db.update(TABLE_NAME, con, "ID = ?",new String[] { id });
        return true;
    }

    @SuppressLint("Range")
    public ArrayList <String> getUsers(){
        String[] li= {Col_1,Col_2,Col_3,Col_4,Col_6,Col_7};
        ArrayList<String> list= new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,li,
                null,null,null,null,null);

    while(cursor.moveToNext()){
        list.add(cursor.getString(cursor.getColumnIndex(TABLE_NAME)));
    }
    return list;
    }

}
