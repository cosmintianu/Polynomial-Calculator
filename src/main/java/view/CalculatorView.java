package view;

import controller.CalculatorController;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JPanel {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    public CalculatorView(CalculatorController calculatorController) {

        JFrame frame = new JFrame("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        textField1.setPreferredSize(new Dimension(100, 20));
        textField2.setPreferredSize(new Dimension(100, 20));

        panel1.add(labelPolynomial1);
        panel1.add(textField1);
        panel1.add(labelPolynomial2);
        panel1.add(textField2);

        //to do actions

        panel2.add(buttonPlus);
        panel2.add(buttonMinus);
        panel2.add(buttonDiv);
        panel2.add(buttonMul);

        textFieldParam3.setPreferredSize(new Dimension(100, 20));

        panel3.add(labelParam3);
        panel3.add(textFieldParam3);


        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    JPanel panel4 = new JPanel();

    JLabel labelPolynomial1 = new JLabel("Polynomial 1");
    JTextField textField1 = new JTextField();
    JLabel labelPolynomial2 = new JLabel("Polynomial 2");
    JTextField textField2 = new JTextField();

    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonDiv = new JButton("/");
    JButton buttonMul = new JButton("*");

    JLabel labelParam3 = new JLabel("Result: ");
    JTextField textFieldParam3 = new JTextField();

    //to do polynomial processing
}
