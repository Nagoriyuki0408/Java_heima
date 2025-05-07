package com.itshiokou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private final JTextField display;
    private String currentInput = "";
    private double result = 0;
    private String lastOperation = "=";

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            currentInput += command;
            display.setText(currentInput);
        } else if ("+-*/=".contains(command)) {
            calculate(Double.parseDouble(currentInput));
            lastOperation = command;
            currentInput = "";
            display.setText(String.valueOf(result));
        }
    }

    private void calculate(double number) {
        switch (lastOperation) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "*":
                result *= number;
                break;
            case "/":
                if (number != 0) {
                    result /= number;
                } else {
                    display.setText("Error");
                    result = 0;
                    return;
                }
                break;
            case "=":
                result = number;
                break;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}