package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class appHelper extends SQLiteOpenHelper
{
    public static final String DBNAME="Soothe.db";

    public appHelper(Context context) {
        super(context, "Soothe.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table appointment(name TEXT , phno TEXT , slot TEXT , date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists appointment");
    }

    public Boolean checkSlotDate(String slot, String date)
    {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * from appointment where slot=? and date=?",
                new String[] {slot, date});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean insertData(String name, String phno, String slot, String date)
    {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phno", phno);
        contentValues.put("slot", slot);
        contentValues.put("date", date);
        long result=MyDB.insert("appointment", null, contentValues);
        if(result==-1)
            return false;
        return true;
    }
}