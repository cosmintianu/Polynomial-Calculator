import controller.CalculatorController;
import model.Operations;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        CalculatorController calculatorController = new CalculatorController();
        CalculatorView calculatorView = new CalculatorView(calculatorController);

        calculatorController.setCalculatorModel(operations);
        calculatorController.setCalculatorView(calculatorView);

    }
}
