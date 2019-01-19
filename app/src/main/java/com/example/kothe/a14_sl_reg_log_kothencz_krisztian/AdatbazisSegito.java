package com.example.kothe.a14_sl_reg_log_kothencz_krisztian;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
        HASZNÁLHATÓ LINKEK:
        http://sqlitebrowser.org/
        https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
        https://developer.android.com/training/data-storage/sqlite.html
        https://developer.android.com/training/data-storage/room/index.html
 */

public class AdatbazisSegito extends SQLiteOpenHelper {

    //ADATBÁZIS FELÉPÍTÉSE

    public static final String DATABASE_NAME = "User.db";    //adatbázis file név
    public static final String TABLE_NAME = "User_table";    //tábla neve

    public static final String COL_1 = "ID";            //első oszlop neve
    public static final String COL_2 = "FELHASZNALONEV";    //második oszlop neve
    public static final String COL_3 = "PASSWORD";   //harmadik oszlop neve
    public static final String COL_4 = "TELJESNEV";          //negyedik oszlop neve
    public static final String COL_5 = "TELEFONSZAM";

    //konstruktor felvétele

    public AdatbazisSegito(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    //LÉTREHOZZUK A TÁBLÁT ÉS A BENNE LÉVŐ OSZLOPOKHOZ TÍPUST ADUNK
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FELHASZNALONEV TEXT, PASSWORD TEXT,TELJESNEV TEXT,TELEFONSZAM TEXT");
    }

    //DOBJA EL A TÁBLÁT HA MÁR ILYEN LÉTEZIK

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //adat felvétel

    public boolean adatRogzites(String felhasznalonev, String password, String teljesnev, String telefonszam) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, felhasznalonev);
        contentValues.put(COL_3,  password);
        contentValues.put(COL_4, teljesnev);
        contentValues.put(COL_5, telefonszam);

        long eredmeny = db.insert(TABLE_NAME, null, contentValues);

        if (eredmeny == -1)
        {
            return false;           //sikertelen adatfelvétel
        }else
            return true;            //sikeres adatfelvétel
    }
    public Cursor adatLekerdezes()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor eredmeny = db.rawQuery("Select * from " + TABLE_NAME,null);
        return eredmeny;
    }
}

