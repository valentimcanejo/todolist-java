package com.example.myapplication;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CriarTarefa extends AppCompatActivity {
    private EditText nomeEditText;
    private EditText descricaoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criar_tarefa);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nomeEditText = findViewById(R.id.nomeTarefaText);
        descricaoEditText = findViewById(R.id.descricaoTarefaText);


        Button criarButton = findViewById(R.id.criarTarefaButton);
        criarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeEditText.getText().toString();
                String descricao = descricaoEditText.getText().toString();

                GerenciadorDeTarefas.getInstance().adicionarTarefa(nome, descricao);

                finish();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}