package com.example.iscg7424_mobileapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SupDBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "SUPRegister.db";

    public SupDBHelper(Context context) {
        super(context, "SUPRegister.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(email TEXT primary key, fname TEXT ,lname TEXT ,compname TEXT , password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String email, String fname, String lname, String compname,  String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email", email);
        contentValues.put("fname", fname);
        contentValues.put("lname", lname);
        contentValues.put("compname", compname);
        contentValues.put("password", password);
        long result = MyDB.insert("users",null,contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean checkemail(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ?", new String[]{email});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkemailnrest(String email, String compname, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ? and password = ? and compname = ?", new String[]{email,compname,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}