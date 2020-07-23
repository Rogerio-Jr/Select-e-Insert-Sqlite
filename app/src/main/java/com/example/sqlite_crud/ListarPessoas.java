package com.example.sqlite_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListarPessoas extends AppCompatActivity {

    List<Pessoa> listpessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pessoas);

        ListView lvPessoas = findViewById(R.id.listViewPessoa);
        PessoaDAO pessoaDAO = new PessoaDAO(this);
        listpessoa = pessoaDAO.listar();

        ArrayAdapter<Pessoa>adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listpessoa);
        lvPessoas.setAdapter(adapter);
    }
}
