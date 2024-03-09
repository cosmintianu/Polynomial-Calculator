package controller;

import model.CalculatorModel;
import model.Polynomial;
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

    public void plusButtonClicked() {
        Polynomial polynomial1 = calculatorView.getPolynomial1();
        Polynomial polynomial2 = calculatorView.getPolynomial2();
        Polynomial result = calculatorModel.add(polynomial1, polynomial2);
        System.out.println(result.getTerms());
        calculatorView.setResult(result);
    }

    public void minusButtonClicked() {
        Polynomial polynomial1 = calculatorView.getPolynomial1();
        Polynomial polynomial2 = calculatorView.getPolynomial2();
        Polynomial result = calculatorModel.subtract(polynomial1, polynomial2);
        System.out.println(result.getTerms());
        calculatorView.setResult(result);
    }

    public void mulButtonClicked() {
        Polynomial polynomial1 = calculatorView.getPolynomial1();
        Polynomial polynomial2 = calculatorView.getPolynomial2();
        Polynomial result = calculatorModel.multiply(polynomial1, polynomial2);
        System.out.println(result.getTerms());
        calculatorView.setResult(result);
    }
}
