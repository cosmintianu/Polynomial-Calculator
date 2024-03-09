package model;

import java.util.Map;

public class CalculatorModel {
    public Polynomial add(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynomial1.getTerms().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();
            result.addTerm(exponent, coefficient);
        }

        for (Map.Entry<Integer, Double> entry : polynomial2.getTerms().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();
            result.addTerm(exponent, result.getTerms().getOrDefault(exponent, 0D) + coefficient);
        }

        return result;
    }

    public Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynomial1.getTerms().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();
            result.addTerm(exponent, coefficient);
        }

        for (Map.Entry<Integer, Double> entry : polynomial2.getTerms().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();
            result.addTerm(exponent, result.getTerms().getOrDefault(exponent, 0D) - coefficient);
        }

        return result;
    }

    public Polynomial multiply(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry1 : polynomial1.getTerms().entrySet()) {
            int exponent1 = entry1.getKey();
            double coefficient1 = entry1.getValue();

            for (Map.Entry<Integer, Double> entry2 : polynomial2.getTerms().entrySet()) {
                int exponent2 = entry2.getKey();
                double coefficient2 = entry2.getValue();

                int newExponent = exponent1 + exponent2;
                double newCoefficient = coefficient1 * coefficient2;
                result.addTerm(newExponent, result.getTerms().getOrDefault(newExponent, 0D) + newCoefficient);
            }
        }
        return result;
    }

    public Polynomial[] division(Polynomial dividend, Polynomial divisor) {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = dividend;

        while (remainder.getMaxDegreeEntry().getKey() >= divisor.getMaxDegreeEntry().getKey()
                && remainder.getMaxDegreeEntry().getValue() != 0) {

            int leadingExponentRemainder = remainder.getMaxDegreeEntry().getKey();
            double leadingCoefficientRemainder = remainder.getMaxDegreeEntry().getValue();

            int leadingExponentDivisor = divisor.getMaxDegreeEntry().getKey();
            double leadingCoefficientDivisor = divisor.getMaxDegreeEntry().getValue();

            int newExponent = leadingExponentRemainder - leadingExponentDivisor;
            double newCoefficient = leadingCoefficientRemainder / leadingCoefficientDivisor;

            Polynomial newMonomial = new Polynomial();
            newMonomial.addTerm(newExponent, newCoefficient);

            quotient.addTerm(newExponent, newCoefficient);

            Polynomial product = multiply(divisor, newMonomial);
            remainder = subtract(remainder, product);
        }

        Polynomial[] result = new Polynomial[2];
        result[0] = quotient;
        result[1] = remainder;

        return result;
    }

    public Polynomial derivate(Polynomial polynomial1) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynomial1.getTerms().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();
            if (exponent == 0 && coefficient == 1) {
                result.addTerm(1, 0);
            } else {
                result.addTerm(exponent - 1, coefficient * exponent);
            }
        }

        return result;
    }

    public Polynomial integrate(Polynomial polynomial1) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynomial1.getTerms().entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();
            result.addTerm(exponent + 1, coefficient * (1.0 / (exponent + 1)));
        }

        return result;
    }
}
