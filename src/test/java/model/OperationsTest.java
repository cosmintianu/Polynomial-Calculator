package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationsTest {
    Operations operations = new Operations();
    @Test
    public void testAdd() {
        Polynomial polynomial1 = new Polynomial(1,1);
        Polynomial polynomial2 = new Polynomial(1,1);
        Polynomial result = new Polynomial(1,2);
        assertEquals(result.getTerms(),operations.add(polynomial1,polynomial2).getTerms());
    }
    @Test
    public void testSubtract() {
        Polynomial polynomial1 = new Polynomial(1,1);
        Polynomial polynomial2 = new Polynomial(1,1);
        Polynomial result = new Polynomial(1,0);
        assertEquals(result.getTerms(),operations.subtract(polynomial1,polynomial2).getTerms());
    }
    @Test
    public void testMultiply() {
        Polynomial polynomial1 = new Polynomial(1,1);
        Polynomial polynomial2 = new Polynomial(1,1);
        Polynomial result = new Polynomial(2,1);
        assertEquals(result.getTerms(),operations.multiply(polynomial1,polynomial2).getTerms());
    }
    @Test
    public void testDivision() {
        Polynomial polynomial1 = new Polynomial(1,1);
        Polynomial polynomial2 = new Polynomial(1,1);
        Polynomial quotient = new Polynomial(0,1);
        Polynomial remainder = new Polynomial(1,0);
        Polynomial[] result = new Polynomial[2];
        result[0] = quotient;
        result[1] = remainder;
        assertEquals(result[0].getTerms(),operations.division(polynomial1,polynomial2)[0].getTerms());
        assertEquals(result[1].getTerms(),operations.division(polynomial1,polynomial2)[1].getTerms());
    }
    @Test
    public void testDerivative() {
        Polynomial polynomial1 = new Polynomial(2,1);
        Polynomial result = new Polynomial(1,2);
        assertEquals(result.getTerms(),operations.derivative(polynomial1).getTerms());
    }
    @Test
    public void testIntegrate() {
        Polynomial polynomial1 = new Polynomial(2,1);
        Polynomial result = new Polynomial(3,(double) 1/3);
        assertEquals(result.getTerms(),operations.integrate(polynomial1).getTerms());
    }
}