package christmas.factory;

import christmas.controller.ChrisMasController;

public class ApplicationFactory {

    public ChrisMasController controller() {
        return new ChrisMasController();
    }
}
