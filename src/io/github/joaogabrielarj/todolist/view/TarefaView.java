package io.github.joaogabrielarj.todolist.view;

import io.github.joaogabrielarj.todolist.model.Status;
import io.github.joaogabrielarj.todolist.model.Tarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TarefaView {
    private Scanner scanner;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TarefaView() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Todas as Tarefas");
        System.out.println("3. Deletar Tarefa");
        System.out.println("4. Listar Tarefas por Filtro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public void mostrarListaDeTarefas(List<Tarefa> tarefas) {
        System.out.println("\n--- LISTA DE TAREFAS ---");
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    public int mostrarMenuFiltros() {
        System.out.println("\n--- FILTRAR TAREFAS POR ---");
        System.out.println("1. Categoria");
        System.out.println("2. Prioridade");
        System.out.println("3. Status");
        System.out.print("Escolha um filtro: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha
        return opcao;
    }

    public int solicitarIndiceTarefaParaDeletar() {
        System.out.print("Digite o número da tarefa que deseja deletar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }

    public Tarefa solicitarDadosNovaTarefa() {
        System.out.println("\n--- ADICIONAR NOVA TAREFA ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Data de Término (dd/MM/yyyy): ");
        LocalDate dataTermino = LocalDate.parse(scanner.nextLine(), dateFormatter);

        System.out.print("Prioridade (1-5): ");
        int prioridade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        return new Tarefa(nome, descricao, dataTermino, prioridade, categoria);
    }

    public String solicitarCategoria() {
        System.out.print("Digite a categoria que deseja filtrar: ");
        return scanner.nextLine();
    }

    public int solicitarPrioridade() {
        System.out.print("Digite a prioridade que deseja filtrar (1-5): ");
        int prioridade = scanner.nextInt();
        scanner.nextLine();
        return prioridade;
    }

    public Status solicitarStatus() {
        System.out.print("Digite o status (TODO, DOING, DONE): ");
        String statusStr = scanner.nextLine().toUpperCase();
        return Status.valueOf(statusStr);
    }
    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}