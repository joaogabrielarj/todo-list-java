package io.github.joaogabrielarj.todolist.controller;

import io.github.joaogabrielarj.todolist.model.Status;
import io.github.joaogabrielarj.todolist.model.Tarefa;
import io.github.joaogabrielarj.todolist.model.TarefaService;
import io.github.joaogabrielarj.todolist.view.TarefaView;

import java.util.List;

public class TarefaController {
    private TarefaService tarefaService;
    private TarefaView tarefaView;

    public TarefaController() {
        this.tarefaService = new TarefaService();
        this.tarefaView = new TarefaView();
    }

    public void iniciar() {
        while (true) {
            int opcao = tarefaView.mostrarMenu();

            switch (opcao) {
                case 1:
                    Tarefa novaTarefa = tarefaView.solicitarDadosNovaTarefa();
                    tarefaService.adicionarTarefa(novaTarefa);
                    tarefaView.mostrarMensagem("Tarefa adicionada com sucesso!");
                    break;
                case 2:
                    List<Tarefa> tarefas = tarefaService.listarTodasTarefas();
                    tarefaView.mostrarListaDeTarefas(tarefas);
                    break;
                case 3:
                    List<Tarefa> tarefasParaDeletar = tarefaService.listarTodasTarefas();
                    tarefaView.mostrarListaDeTarefas(tarefasParaDeletar);

                    if (!tarefasParaDeletar.isEmpty()) {
                        int numeroTarefa = tarefaView.solicitarIndiceTarefaParaDeletar();
                        int indice = numeroTarefa - 1;

                        boolean sucesso = tarefaService.deletarTarefa(indice);

                        if (sucesso) {
                            tarefaView.mostrarMensagem("Tarefa deletada com sucesso!");
                        } else {
                            tarefaView.mostrarMensagem("Erro: Número da tarefa inválido.");
                        }
                    }
                    break;
                case 4:
                    lidarComFiltros();
                    break;
                case 0:
                    tarefaView.mostrarMensagem("Saindo do programa...");
                    return;
                default:
                    tarefaView.mostrarMensagem("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void lidarComFiltros() {
        int tipoFiltro = tarefaView.mostrarMenuFiltros();
        List<Tarefa> tarefasFiltradas;

        switch (tipoFiltro) {
            case 1:
                String categoria = tarefaView.solicitarCategoria();
                tarefasFiltradas = tarefaService.listarPorCategoria(categoria);
                tarefaView.mostrarListaDeTarefas(tarefasFiltradas);
                break;
            case 2:
                int prioridade = tarefaView.solicitarPrioridade();
                tarefasFiltradas = tarefaService.listarPorPrioridade(prioridade);
                tarefaView.mostrarListaDeTarefas(tarefasFiltradas);
                break;
            case 3:
                try {
                    Status status = tarefaView.solicitarStatus();
                    tarefasFiltradas = tarefaService.listarPorStatus(status);
                    tarefaView.mostrarListaDeTarefas(tarefasFiltradas);
                } catch (IllegalArgumentException e) {
                    tarefaView.mostrarMensagem("Erro: Status inválido. Use TODO, DOING ou DONE.");
                }
                break;
            default:
                tarefaView.mostrarMensagem("Opção de filtro inválida.");
                break;
        }
    }
}

