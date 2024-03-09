package model;

import java.util.Map;

public class CalculatorModel {
    public Polynomial add(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Integer> entry : polynomial1.getTerms().entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, coefficient);
        }

        for (Map.Entry<Integer, Integer> entry : polynomial2.getTerms().entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, result.getTerms().getOrDefault(exponent, 0) + coefficient);
        }

        return result;
    }

    public Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Integer> entry : polynomial1.getTerms().entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, coefficient);
        }

        for (Map.Entry<Integer, Integer> entry : polynomial2.getTerms().entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, result.getTerms().getOrDefault(exponent, 0) - coefficient);
        }

        return result;
    }

    public Polynomial multiply(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Integer> entry1 : polynomial1.getTerms().entrySet()) {
            int exponent1 = entry1.getKey();
            int coefficient1 = entry1.getValue();

            for (Map.Entry<Integer, Integer> entry2 : polynomial2.getTerms().entrySet()) {
                int exponent2 = entry2.getKey();
                int coefficient2 = entry2.getValue();

                int newExponent = exponent1 + exponent2;
                int newCoefficient = coefficient1 * coefficient2;
                result.addTerm(newExponent, result.getTerms().getOrDefault(newExponent, 0) + newCoefficient);
            }
        }


        return result;
    }
}
