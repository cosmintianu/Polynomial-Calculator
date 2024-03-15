package controller;

import model.Operations;
import model.Polynomial;
import view.CalculatorView;

public class CalculatorController {
    Operations operations;
    CalculatorView calculatorView;

    public Operations getCalculatorModel() {
        return operations;
    }

    public CalculatorView getCalculatorView() {
        return calculatorView;
    }

    public void setCalculatorModel(Operations operations) {
        this.operations = operations;
    }

    public void setCalculatorView(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public void plusButtonClicked() {
        Polynomial polynomial1 = calculatorView.getPolynomial1();
        Polynomial polynomial2 = calculatorView.getPolynomial2();
        Polynomial result = operations.add(polynomial1, polynomial2);
        calculatorView.setResult(result);
    }

    public void minusButtonClicked() {
        Polynomial polynomial1 = calculatorView.getPolynomial1();
        Polynomial polynomial2 = calculatorView.getPolynomial2();
        Polynomial result = operations.subtract(polynomial1, polynomial2);
        calculatorView.setResult(result);
    }

    public void mulButtonClicked() {
        Polynomial polynomial1 = calculatorView.getPolynomial1();
        Polynomial polynomial2 = calculatorView.getPolynomial2();
        Polynomial result = operations.multiply(polynomial1, polynomial2);
        calculatorView.setResult(result);
    }

    public void divButtonClicked() {
        Polynomial polynomial1 = calculatorView.getPolynomial1();
        Polynomial polynomial2 = calculatorView.getPolynomial2();

        if (polynomial2.getMaxDegreeEntry().getValue().equals(0D) && polynomial2.getMaxDegreeEntry().getKey() == 0) {
            calculatorView.setResultZero();
        } else {
            Polynomial[] result = operations.division(polynomial1, polynomial2);
            calculatorView.setResult(result);
        }
    }

    public void derivativeButtonClicked() {
        Polynomial polynomial1 = calculatorView.getPolynomial1();
        Polynomial result = operations.derivative(polynomial1);
        calculatorView.setResult(result);
    }

    public void integrateButtonClicked() {
        Polynomial polynomial1 = calculatorView.getPolynomial1();
        Polynomial result = operations.integrate(polynomial1);
        calculatorView.setResult(result);
    }

}
