package com.vitorotto;

import com.vitorotto.controllers.ListaTarefasController;
import com.vitorotto.models.ListaTarefasModel;
import com.vitorotto.views.ListaTarefasView;

public class Main {

    public static void main(String[] args) {
        ListaTarefasModel model = new ListaTarefasModel();
        ListaTarefasView view = new ListaTarefasView();
        ListaTarefasController controller = new ListaTarefasController(model, view);
        controller.iniciar();
    }
}