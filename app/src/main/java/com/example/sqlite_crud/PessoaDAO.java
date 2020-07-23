package com.example.sqlite_crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public PessoaDAO(Context context){
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long inserir(Pessoa pessoa){

        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", pessoa.getNome());
        contentValues.put("idade", pessoa.getIdade());

        return db.insert("pessoa", null, contentValues);
    }

    public List<Pessoa>listar(){

        List<Pessoa> lista = new ArrayList<Pessoa>();

        Cursor cursor = db.rawQuery("SELECT * FROM pessoa",null);

        while (cursor.moveToNext()){
            lista.add(new Pessoa(cursor.getString(1),cursor.getInt(2)));
        }
        return lista;
    }

}
