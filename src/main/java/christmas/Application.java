package christmas;

import christmas.controller.ChrisMasController;
import christmas.factory.ApplicationFactory;

public class Application {
    public static void main(String[] args) {
        ApplicationFactory config = new ApplicationFactory();
        ChrisMasController controller = config.controller();

        controller.run();
    }
}
