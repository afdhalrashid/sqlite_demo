package com.example.tir_afdhal.sqlite_app1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by afdhal on 23/4/2017.
 */

public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    public static final String TABLE_NAME = "products";
    public static final String COLUMN_ID = "product_id";
    public static final String COLUMN_PRODUCTNAME = "product_name";
    public static final String COLUMN_PRODUCTCOLOR = "product_colour";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PRODUCTNAME + " TEXT, "
                + COLUMN_PRODUCTCOLOR + " INTEGER);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

    //Youtube (https://www.youtube.com/watch?v=GAyvtK4cWLA)
    //Add new row
    public void addProduct(Products prod){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME , prod.getProduct_name());
        values.put(COLUMN_PRODUCTCOLOR , prod.getProduct_colour());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //Youtube (https://www.youtube.com/watch?v=GAyvtK4cWLA)
    //delete row
    public void deleteProduct(String prodName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_PRODUCTNAME + " =\"" + prodName + "\"");//escape with \
    }

    //Print out database as string
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + "" ;

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();

        while (c.moveToNext()){//means the cursor loop for all row
            if(c.getString(c.getColumnIndex(COLUMN_ID)) != null){
                dbString += c.getString(1);
                dbString += "-";
            }
        }
        db.close();
        return dbString;
    }
}
