package com.example.myapplication;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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
}