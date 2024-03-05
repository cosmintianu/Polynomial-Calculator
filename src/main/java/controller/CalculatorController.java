package controller;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    CalculatorModel calculatorModel;
    CalculatorView calculatorView;

    public CalculatorModel getCalculatorModel() {
        return calculatorModel;
    }

    public CalculatorView getCalculatorView() {
        return calculatorView;
    }

    public void setCalculatorModel(CalculatorModel calculatorModel) {
        this.calculatorModel = calculatorModel;
    }

    public void setCalculatorView(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    //to do op's when button clicked
}
