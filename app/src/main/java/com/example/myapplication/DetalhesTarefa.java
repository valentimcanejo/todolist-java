package com.example.myapplication;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.widget.TextView;

public class DetalhesTarefa extends AppCompatActivity {
    public static final String NOME_TAREFA = "nome_tarefa";
    public static final String DESCRICAO_TAREFA = "descricao_tarefa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_tarefa);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView nomeTarefaTextView = findViewById(R.id.nomeTarefaTextView);
        TextView descricaoTarefaTextView = findViewById(R.id.descricaoTarefaTextView);

        String nomeTarefa = getIntent().getStringExtra(NOME_TAREFA);
        String descricaoTarefa = getIntent().getStringExtra(DESCRICAO_TAREFA);
        nomeTarefaTextView.setText(nomeTarefa);
        descricaoTarefaTextView.setText(descricaoTarefa);
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