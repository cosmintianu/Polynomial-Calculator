package model;

import java.util.Map;

public class CalculatorModel {
    public Polynomial add(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Integer> entry : polynomial1.getTerms().entrySet()){
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, coefficient);
        }

        for(Map.Entry<Integer, Integer> entry : polynomial2.getTerms().entrySet()){
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, result.getTerms().getOrDefault(exponent,0) + coefficient);
        }

        return result;
    }

    public Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Integer> entry : polynomial1.getTerms().entrySet()){
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, coefficient);
        }

        for(Map.Entry<Integer, Integer> entry : polynomial2.getTerms().entrySet()){
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, result.getTerms().getOrDefault(exponent,0) - coefficient);
        }

        return result;
    }
}
