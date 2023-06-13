package com.example.myapplication;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {
    private static GerenciadorDeTarefas instance;
    private List<Tarefa> listaTarefas;

    private GerenciadorDeTarefas() {
        listaTarefas = new ArrayList<>();
    }

    public static GerenciadorDeTarefas getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeTarefas();
        }
        return instance;
    }

    public void adicionarTarefa(String name, String description) {
        Tarefa task = new Tarefa(name, description);
        listaTarefas.add(task);
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public List<String> getNomesTarefas() {
        List<String> nomesTarefas = new ArrayList<>();
        for (Tarefa task : listaTarefas) {
            nomesTarefas.add(task.getNome());
        }
        return nomesTarefas;
    }
}