package com.example.myapplication;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class DetalhesTarefa extends AppCompatActivity {
    public static final String NOME_TAREFA = "nome_tarefa";
    public static final String DESCRICAO_TAREFA = "descricao_tarefa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_tarefa);

        TextView nomeTarefaTextView = findViewById(R.id.nomeTarefaTextView);
        TextView descricaoTarefaTextView = findViewById(R.id.descricaoTarefaTextView);

        String nomeTarefa = getIntent().getStringExtra(NOME_TAREFA);
        String descricaoTarefa = getIntent().getStringExtra(DESCRICAO_TAREFA);
        nomeTarefaTextView.setText(nomeTarefa);
        descricaoTarefaTextView.setText(descricaoTarefa);
    }
}