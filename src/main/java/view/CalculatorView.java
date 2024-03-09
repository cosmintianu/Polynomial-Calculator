package view;

import controller.CalculatorController;
import model.Polynomial;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JPanel {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    JLabel labelPolynomial1 = new JLabel("Polynomial 1");
    JTextField textField1 = new JTextField();
    JLabel labelPolynomial2 = new JLabel("Polynomial 2");
    JTextField textField2 = new JTextField();

    JButton plusBtn = new JButton("+");
    JButton minusBtn = new JButton("-");
    JButton mulBtn = new JButton("*");
    JButton divBtn = new JButton("/");
    JButton derivativeBtn = new JButton('\u2202' + "/" + '\u2202' + "x");
    JButton integrateBtn = new JButton("∫");


    JLabel labelParam3 = new JLabel("Result: ");
    JTextField textField3 = new JTextField();

    public CalculatorView(CalculatorController controller) {

        JFrame frame = new JFrame("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        textField1.setPreferredSize(new Dimension(100, 20));
        textField2.setPreferredSize(new Dimension(100, 20));

        panel1.add(labelPolynomial1);
        panel1.add(textField1);
        panel1.add(labelPolynomial2);
        panel1.add(textField2);

        plusBtn.addActionListener(e -> controller.plusButtonClicked());
        minusBtn.addActionListener(e -> controller.minusButtonClicked());
        mulBtn.addActionListener(e -> controller.mulButtonClicked());
        divBtn.addActionListener(e -> controller.divButtonClicked());
        derivativeBtn.addActionListener(e -> controller.derivateButtonClicked());


        panel2.add(plusBtn);
        panel2.add(minusBtn);
        panel2.add(mulBtn);
        panel2.add(divBtn);
        panel2.add(integrateBtn);
        panel2.add(derivativeBtn);

        textField3.setPreferredSize(new Dimension(200, 20));

        panel3.add(labelParam3);
        panel3.add(textField3);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public Polynomial getPolynomial1() {
        return Polynomial.processPolynomial(textField1.getText());
    }

    public Polynomial getPolynomial2() {
        return Polynomial.processPolynomial(textField2.getText());
    }

    public void setResult(Polynomial result) {
        textField3.setText(result.polynomialToString());
    }

    public void setResult(Polynomial[] result){
        textField3.setText(result[0].polynomialToString() + " ; remainder : " + result[1].polynomialToString());
    }
}
