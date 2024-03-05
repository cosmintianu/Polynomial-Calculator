import controller.CalculatorController;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        CalculatorController calculatorController = new CalculatorController();
        CalculatorView calculatorView = new CalculatorView(calculatorController);

    }
}
