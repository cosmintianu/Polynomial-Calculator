package model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private Map<Integer, Integer> terms;

    public Map<Integer, Integer> getTerms() {
        return terms;
    }

    public Polynomial() {
        this.terms = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
    }

    public void addTerm(int exponent, int coefficient) {
        terms.put(exponent, coefficient);
    }

    public void printPolynomial() {

        StringBuilder polynomialStr = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : terms.entrySet()) {


            if (entry.getValue() == 1) {
                String term = "x^" + entry.getKey() + " + ";
                polynomialStr.append(term);
            } else if (entry.getKey() == 1) {
                String term = entry.getValue() + "x" + " + ";
                polynomialStr.append(term);
            } else {
                String term = entry.getValue() + "x^" + entry.getKey() + " + ";
                polynomialStr.append(term);
            }
        }
        polynomialStr.delete(polynomialStr.length() - 3, polynomialStr.length());
        System.out.println(polynomialStr);
    }

    public static Polynomial processPolynomial(String input) {
        Polynomial polynomial = new Polynomial();

        // Split the input into terms
        String[] terms = input.split("\\s*\\+\\s*");

        for (String term : terms) {

            // Skip empty terms
            if (!term.isEmpty()) {
                String[] parts = term.split("x\\^?");
                int coefficient = 1;
                int exponent = 1;

                // Check if the coefficient part is not empty before parsing
                if (!parts[0].isEmpty()) {
                    coefficient = Integer.parseInt(parts[0].trim());
                }

                // Check if the exponent part exists and is not empty before parsing
                if (parts.length > 1 && !parts[1].isEmpty()) {
                    exponent = Integer.parseInt(parts[1].trim());
                }

                polynomial.addTerm(exponent, coefficient);
            }
        }

        return polynomial;
    }

}
