package model;

import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.abs;

public class Polynomial {
    private final Map<Integer, Double> terms;

    public Map<Integer, Double> getTerms() {
        return terms;
    }

    public Polynomial() {
        this.terms = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
    }

    public Map.Entry<Integer, Double> getMaxDegreeEntry() {

        Map.Entry<Integer, Double> maxDegEntry = Map.entry(0, 0D);
        for (Map.Entry<Integer, Double> entry : terms.entrySet()) {
            if (!entry.getValue().equals(0D)) {
                maxDegEntry = entry;
                break;
            }
        }
        return maxDegEntry;
    }

    public void addTerm(int exponent, double coefficient) {
        terms.put(exponent, coefficient);
    }

    public String polynomialToString() {

        int i = 1;  //i is used not for iteration but for checking in case a term is 0 and
                    //it is the only one to add it to the string that will be displayed
        StringBuilder polynomialStr = new StringBuilder();

        for (Map.Entry<Integer, Double> entry : terms.entrySet()) {

            if (entry.getValue() < 0D) {
                String term = " - ";
                terms.put(entry.getKey(), abs(entry.getValue()));
                polynomialStr.append(term);
            } else {
                String term = " + ";
                polynomialStr.append(term);
            }

            if (entry.getValue() == 1D && entry.getKey() == 0) {
                String term = entry.getValue() + "";
                polynomialStr.append(term);
            } else if (entry.getValue() == 1D && entry.getKey() == 1) {
                String term = "x";
                polynomialStr.append(term);
            } else if (entry.getValue() == 0D) {
                if (polynomialStr.length() >= 3) {
                    polynomialStr.delete(polynomialStr.length() - 3, polynomialStr.length());
                }
                if (i == 1) {
                    String term = "0";
                    polynomialStr.append(term);
                }
            } else if (entry.getValue() == 1D) {
                String term = "x^" + entry.getKey();
                polynomialStr.append(term);
            } else if (entry.getKey() == 1) {
                String term = entry.getValue() + "x";
                polynomialStr.append(term);
            } else if (entry.getKey() == 0) {
                String term = entry.getValue() + "";
                polynomialStr.append(term);
            } else {
                String term = entry.getValue() + "x^" + entry.getKey();
                polynomialStr.append(term);
            }
            i++;
        }
        if (polynomialStr.length() >= 3 && polynomialStr.substring(0, 3).contains("+")) {
            polynomialStr.delete(0, 3);
        }

        return polynomialStr.toString();
    }

    private static void extractCoefAndExpFromTermsMinus(Polynomial polynomial, String term) {
        // Split the terms into smaller terms
        String[] termsMinus = term.split("\\s*[-]\\s*");

        int i = 1;
        for (String termMinus : termsMinus) {
            if (!termMinus.isEmpty()) {

                String[] partsMinus = termMinus.split("x\\^?");
                int coefficientMinus = 1;
                int exponentMinus;
                if (termMinus.contains("x")) {
                    exponentMinus = 1;
                } else {
                    exponentMinus = 0;
                }

                // Check if the coefficient part exists and is not empty before parsing
                if (partsMinus.length > 0 && !partsMinus[0].isEmpty()) {
                    //System.out.println("Part 0 " + partsMinus[0]);
                    if (i != 1) {
                        coefficientMinus = -Integer.parseInt(partsMinus[0].trim());
                    } else {
                        coefficientMinus = Integer.parseInt(partsMinus[0].trim());
                    }


                }
                // Check if the exponent part exists and is not empty before parsing
                if (partsMinus.length > 1 && !partsMinus[1].isEmpty()) {
                    //System.out.println("Part 1 " + partsMinus[1]);
                    exponentMinus = Integer.parseInt(partsMinus[1].trim());
                }
                polynomial.addTerm(exponentMinus, coefficientMinus);

            }
            i++;
        }
        //System.out.println(polynomial.getTerms());
    }

    private static void extractCoefAndExpFromTerms(Polynomial polynomial, String term) {
        String[] parts = term.split("x\\^?");
        int coefficient = 1;
        int exponent;
        if (term.contains("x")) {
            exponent = 1;
        } else {
            exponent = 0;
        }

        // Check if the coefficient part exists and is not empty before parsing
        if (parts.length > 0 && !parts[0].isEmpty()) {
            coefficient = Integer.parseInt(parts[0].trim());
        }

        // Check if the exponent part exists and is not empty before parsing
        if (parts.length > 1 && !parts[1].isEmpty()) {
            exponent = Integer.parseInt(parts[1].trim());
        }

        polynomial.addTerm(exponent, coefficient);
    }

    public static Polynomial processPolynomial(String input) {
        Polynomial polynomial = new Polynomial();

        // Split the input into terms
        String[] terms = input.split("\\s*[+]\\s*");

        for (String term : terms) {

            // Skip empty terms
            if (!term.isEmpty()) {

                if (term.contains("-")) {

                    extractCoefAndExpFromTermsMinus(polynomial, term);
                    continue;
                }

                extractCoefAndExpFromTerms(polynomial, term);
            }
        }
        return polynomial;
    }
}
