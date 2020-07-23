package com.example.sqlite_crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    private static String NOME_BANCO = "banco.db";
    private static int VERSAO = 1;

    public DbHelper(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE pessoa(id integer PRIMARY KEY AUTOINCREMENT, nome varchar(50), idade interger)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

