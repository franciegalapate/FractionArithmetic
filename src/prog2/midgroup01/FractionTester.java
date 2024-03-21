package prog2.midgroup01;

import prelimgroup.Fraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractionTester extends JFrame implements ActionListener {
    public static void main(String[] args) {
        FractionTester use = new FractionTester();
    }

    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton improperButton;
    private JButton mixedButton;

    Font titleFont = new Font("Montserrat", Font.BOLD, 36);
    Font myFont = new Font("Montserrat", Font.BOLD, 30);

    FractionTester() {
        frame = new JFrame("Fraction Class Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLocationRelativeTo(null);

        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Fraction Class Calculator");
        titleLabel.setFont(titleFont);
        titlePanel.add(titleLabel);

        // Buttons
        JPanel userButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        improperButton = new JButton("Improper Fraction");
        mixedButton = new JButton("Mixed Fraction");
        userButtons.setPreferredSize(new Dimension(600, 400));
        userButtons.add(improperButton);
        userButtons.add(mixedButton);

        // First prelimgroup.Fraction Inputs
        JPanel leftPanel = new JPanel(new GridLayout(3, 2));
        leftPanel.setPreferredSize(new Dimension(200, 300));
        leftPanel.setBorder(BorderFactory.createTitledBorder("First Fraction"));

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();

        leftPanel.add(new JLabel("Whole Number:"));
        leftPanel.add(textField1);
        leftPanel.add(new JLabel("Numerator:"));
        leftPanel.add(textField2);
        leftPanel.add(new JLabel("Denominator:"));
        leftPanel.add(textField3);

        // Operation Buttons
        JPanel centerPanel = new JPanel(new GridLayout(5, 1));
        centerPanel.setPreferredSize(new Dimension(150, 300));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Operations"));

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        addButton.setFont(myFont);
        subButton.setFont(myFont);
        mulButton.setFont(myFont);
        divButton.setFont(myFont);
        improperButton.setFont(myFont);
        mixedButton.setFont(myFont);

        centerPanel.add(addButton);
        centerPanel.add(subButton);
        centerPanel.add(mulButton);
        centerPanel.add(divButton);

        // Second prelimgroup.Fraction Inputs
        JPanel rightPanel = new JPanel(new GridLayout(3, 2));
        rightPanel.setPreferredSize(new Dimension(200, 300));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Second prelimgroup.Fraction"));

        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();

        rightPanel.add(new JLabel("Whole Number:"));
        rightPanel.add(textField4);
        rightPanel.add(new JLabel("Numerator:"));
        rightPanel.add(textField5);
        rightPanel.add(new JLabel("Denominator:"));
        rightPanel.add(textField6);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(userButtons, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        // Action Listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        improperButton.addActionListener(this);
        mixedButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == improperButton) {
            // Hide whole number fields
            textField1.setVisible(false);
            textField4.setVisible(false);
        } else if (e.getSource() == mixedButton) {
            // Show whole number fields
            textField1.setVisible(true);
            textField4.setVisible(true);
        } else {
            // Show whole number fields
            textField1.setVisible(true);
            textField4.setVisible(true);

            try {
                // Check if whole number fields should be visible based on the selected button
                boolean showWholeNumberFields = mixedButton.isSelected();

                // Set visibility of whole number fields accordingly
                textField1.setVisible(showWholeNumberFields);
                textField4.setVisible(showWholeNumberFields);

                int whole1 = parseField(textField1.getText());
                int num1 = parseField(textField2.getText());
                int den1 = parseField(textField3.getText());
                int whole2 = parseField(textField4.getText());
                int num2 = parseField(textField5.getText());
                int den2 = parseField(textField6.getText());

                // Check if whole number is zero for mixed fraction
                if (whole1 == 0 && whole2 == 0) {
                    throw new NumberFormatException("Whole number cannot be zero for mixed fraction.");
                }

                // Create prelimgroup.Fraction or prog2.midgroup01.MixedFraction objects based on input
                Fraction fraction1 = new Fraction(num1, den1);
                if (whole1 != 0) {
                    fraction1 = new MixedFraction(whole1, num1, den1);
                }
                Fraction fraction2 = new Fraction(num2, den2);
                if (whole2 != 0) {
                    fraction2 = new MixedFraction(whole2, num2, den2);
                }

                // Perform operation based on button clicked
                Fraction result = null;
                if (e.getSource() == addButton) {
                    result = fraction1.add(fraction2);
                } else if (e.getSource() == subButton) {
                    result = fraction1.subtract(fraction2);
                } else if (e.getSource() == mulButton) {
                    result = fraction1.multiply(fraction2);
                } else if (e.getSource() == divButton) {
                    result = fraction1.divide(fraction2);
                }

                // Display the result
                JOptionPane.showMessageDialog(frame, result.toString(), "Result", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter integers.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(frame, "Cannot divide by zero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private int parseField(String text) throws NumberFormatException {
        if (text.trim().isEmpty()) {
            throw new NumberFormatException("Input field cannot be empty.");
        }
        return Integer.parseInt(text);
    }

} // End of Main Class
