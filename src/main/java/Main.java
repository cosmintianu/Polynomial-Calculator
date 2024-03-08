import controller.CalculatorController;
import model.Polynomial;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {

        //CalculatorController calculatorController = new CalculatorController();
        //CalculatorView calculatorView = new CalculatorView(calculatorController);

        Polynomial polynomial = new Polynomial();
        polynomial.addTerm(3,1);
        polynomial.addTerm(2,2);
        System.out.println(polynomial.getTerms());
        polynomial.printPolynomial();
    }
}
