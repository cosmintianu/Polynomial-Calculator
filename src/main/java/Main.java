import controller.CalculatorController;
import model.Polynomial;
import view.CalculatorView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //CalculatorController calculatorController = new CalculatorController();
        //CalculatorView calculatorView = new CalculatorView(calculatorController);

        Polynomial polynomial = new Polynomial();
        polynomial.addTerm(3,1);
        polynomial.addTerm(2,2);
        polynomial.addTerm(1,7);
//        System.out.println(polynomial.getTerms());

        Scanner scanner = new Scanner(System.in);
        Polynomial polynomial1 = new Polynomial();

        String polynomialStr = scanner.nextLine();

        polynomial1 = Polynomial.processPolynomial(polynomialStr);

        System.out.println(polynomial1.getTerms());
        polynomial1.printPolynomial();

        //polynomial.printPolynomial();
    }
}
