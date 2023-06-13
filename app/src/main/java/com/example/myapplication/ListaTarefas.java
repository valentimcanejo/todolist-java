package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;
import android.widget.AdapterView;

public class ListaTarefas extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private GerenciadorDeTarefas taskManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tarefas);

        ListView listView = findViewById(R.id.taskListView);
        taskManager = GerenciadorDeTarefas.getInstance();
        List<String> taskList = taskManager.getNomesTarefas();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String taskName = adapter.getItem(position);
                String taskDescription = taskManager.getListaTarefas().get(position).getDescricao();

                Intent intent = new Intent(ListaTarefas.this, DetalhesTarefa.class);
                intent.putExtra(DetalhesTarefa.NOME_TAREFA, taskName);
                intent.putExtra(DetalhesTarefa.DESCRICAO_TAREFA, taskDescription);
                startActivity(intent);
            }
        });

        adapter.notifyDataSetChanged();

        View addTaskButton = findViewById(R.id.adicionarTarefaButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaTarefas.this, CriarTarefa.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<String> taskList = taskManager.getNomesTarefas();
        adapter.clear();
        adapter.addAll(taskList);
        adapter.notifyDataSetChanged();
    }


}