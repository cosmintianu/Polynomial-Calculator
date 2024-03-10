import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorController calculatorController = new CalculatorController();
        CalculatorView calculatorView = new CalculatorView(calculatorController);

        calculatorController.setCalculatorModel(calculatorModel);
        calculatorController.setCalculatorView(calculatorView);

    }
}
