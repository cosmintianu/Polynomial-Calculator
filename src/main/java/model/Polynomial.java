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

        StringBuilder polynomial = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : terms.entrySet()) {


            if (entry.getValue() == 1) {
                String term = "x^" + entry.getKey() + " + ";
                polynomial.append(term);
            } else if (entry.getKey() == 1) {
                String term = entry.getValue() + "x" + " + ";
                polynomial.append(term);
            } else {
                String term = entry.getValue() + "x^" + entry.getKey() + " + ";
                polynomial.append(term);
            }
        }
        polynomial.delete(polynomial.length() - 3, polynomial.length());
        System.out.println(polynomial);
    }
}
