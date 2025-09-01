package io.github.joaogabrielarj.todolist.model;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> tarefas;

    public TarefaService() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa novaTarefa) {
        int indexParaInserir = 0;
        for (Tarefa tarefaExistente : tarefas) {
            if (novaTarefa.getPrioridade() > tarefaExistente.getPrioridade()) {
                break;
            }
            indexParaInserir++;
        }
        this.tarefas.add(indexParaInserir, novaTarefa);
    }

    public List<Tarefa> listarTodasTarefas() {
        return this.tarefas;
    }

    public boolean deletarTarefa(int indice) {
        if (indice >= 0 && indice < this.tarefas.size()) {
            this.tarefas.remove(indice);
            return true;
        }
        return false;
    }

    public List<Tarefa> listarPorCategoria(String categoria) {
        List<Tarefa> tarefasFiltradas = new ArrayList<>();
        for (Tarefa tarefa : this.tarefas) {
            if (tarefa.getCategoria().equalsIgnoreCase(categoria)) {
                tarefasFiltradas.add(tarefa);
            }
        }
        return tarefasFiltradas;
    }

    public List<Tarefa> listarPorPrioridade(int prioridade) {
        List<Tarefa> tarefasFiltradas = new ArrayList<>();
        for (Tarefa tarefa : this.tarefas) {
            if (tarefa.getPrioridade() == prioridade) {
                tarefasFiltradas.add(tarefa);
            }
        }
        return tarefasFiltradas;
    }

    public List<Tarefa> listarPorStatus(Status status) {
        List<Tarefa> tarefasFiltradas = new ArrayList<>();
        for (Tarefa tarefa : this.tarefas) {
            if (tarefa.getStatus() == status) {
                tarefasFiltradas.add(tarefa);
            }
        }
        return tarefasFiltradas;
    }
}

