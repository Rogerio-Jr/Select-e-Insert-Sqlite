package com.example.sqlite_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText campoNome, campoIdade;
    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void inserir(View view) {
        inicializarComponentes();

        Pessoa pessoa = new Pessoa(campoNome.getText().toString(), Integer.parseInt(campoIdade.getText().toString()));


        PessoaDAO pessoaDAO = new PessoaDAO(this);
        long id = pessoaDAO.inserir(pessoa);

        Toast.makeText(this, "Salvo, id" + id, Toast.LENGTH_SHORT).show();

    }

    public void listar(View view){
        Intent listar = new Intent(this, ListarPessoas.class);
        startActivity(listar);
    }

    public void inicializarComponentes(){

        campoNome = findViewById(R.id.editTextNome);
        campoIdade = findViewById(R.id.editTextIdade);

    }
}
