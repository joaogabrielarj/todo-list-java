package io.github.joaogabrielarj.todolist;

import io.github.joaogabrielarj.todolist.controller.TarefaController;

public class Main {
    public static void main(String[] args) {
        TarefaController controller = new TarefaController();
        controller.iniciar();
    }
}