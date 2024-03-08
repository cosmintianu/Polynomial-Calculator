package model;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private Map<Integer, Integer> terms = new HashMap<>();

    public Map<Integer, Integer> getTerms() {
        return terms;
    }

    public Polynomial() {

    }

    public void addTerm(int exponent, int coefficient) {
        terms.put(exponent, coefficient);
    }

    public void printPolynomial() {

        StringBuilder polynomial = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : terms.entrySet()) {
            String term = entry.getValue() + "x^" + entry.getKey() + " + " ;
            polynomial.append(term);

            //System.out.println(entry.getValue() + "x^" + entry.getKey());
        }
        polynomial.delete(polynomial.length() - 3, polynomial.length());
        System.out.println(polynomial);
    }
}
