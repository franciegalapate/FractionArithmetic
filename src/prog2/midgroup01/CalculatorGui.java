//package prog2.midgroup01;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//    public class CalculatorGui extends JFrame {
//        private JTextField fraction1Field;
//        private JTextField fraction2Field;
//        private JComboBox<String> operationComboBox;
//        private JButton calculateButton;
//        private JLabel resultLabel;
//
//        public CalculatorGui() {
//            setTitle("Fraction Calculator");
//            setSize(300, 200);
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//            setLocationRelativeTo(null);
//
//            JPanel panel = new JPanel();
//            panel.setLayout(new GridLayout(4, 2));
//
//            JLabel fraction1Label = new JLabel("Fraction 1:");
//            fraction1Field = new JTextField();
//            panel.add(fraction1Label);
//            panel.add(fraction1Field);
//
//            JLabel fraction2Label = new JLabel("Fraction 2:");
//            fraction2Field = new JTextField();
//            panel.add(fraction2Label);
//            panel.add(fraction2Field);
//
//            JLabel operationLabel = new JLabel("Operation:");
//            String[] operations = {"Addition", "Subtraction", "Multiplication", "Division"};
//            operationComboBox = new JComboBox<>(operations);
//            panel.add(operationLabel);
//            panel.add(operationComboBox);
//
//            calculateButton = new JButton("Calculate");
//            resultLabel = new JLabel("Result:");
//            panel.add(calculateButton);
//            panel.add(resultLabel);
//
//            calculateButton.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    calculate();
//                }
//            });
//
//            add(panel);
//            setVisible(true);
//        }
//
//        private void calculate() {
//            String fraction1Text = fraction1Field.getText();
//            String fraction2Text = fraction2Field.getText();
//
//            // Parse fractions and operation
//            Fraction fraction1 = parseFraction(fraction1Text);
//            Fraction fraction2 = parseFraction(fraction2Text);
//            String operation = (String) operationComboBox.getSelectedItem();
//
//            // Perform the operation
//            Fraction result;
//            switch (operation) {
//                case "Addition":
//                    result = fraction1.add(fraction2);
//                    break;
//                case "Subtraction":
//                    result = fraction1.subtract(fraction2);
//                    break;
//                case "Multiplication":
//                    result = fraction1.multiply(fraction2);
//                    break;
//                case "Division":
//                    result = fraction1.divide(fraction2);
//                    break;
//                default:
//                    result = new Fraction(0, 1); // Default to 0
//            }
//
//            // Display the result
//            resultLabel.setText("Result: " + result.toString());
//        }
//
//        private Fraction parseFraction(String fractionText) {
//            String[] parts = fractionText.split(" ");
//            if (parts.length != 2) {
//                throw new IllegalArgumentException("Invalid fraction format");
//            }
//            int whole = Integer.parseInt(parts[0]);
//            String[] fractionParts = parts[1].split("/");
//            if (fractionParts.length != 2) {
//                throw new IllegalArgumentException("Invalid fraction format");
//            }
//            int numerator = Integer.parseInt(fractionParts[0]);
//            int denominator = Integer.parseInt(fractionParts[1]);
//            return new Fraction(whole, numerator, denominator);
//        }
//
//        public static void main(String[] args) {
//            new CalculatorGui();
//        }
//    }
//
//    class Fraction {
//        private int whole;
//        private int numerator;
//        private int denominator;
//
//        public Fraction(int whole, int numerator, int denominator) {
//            this.whole = whole;
//            this.numerator = numerator;
//            this.denominator = denominator;
//            simplify();
//        }
//
//        public Fraction(int numerator, int denominator) {
//            this(0, numerator, denominator);
//        }
//
//        public Fraction add(Fraction other) {
//            int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
//            int newDenominator = this.denominator * other.denominator;
//            return new Fraction(this.whole + other.whole, newNumerator, newDenominator);
//        }
//
//        public Fraction subtract(Fraction other) {
//            int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
//            int newDenominator = this.denominator * other.denominator;
//            return new Fraction(this.whole - other.whole, newNumerator, newDenominator);
//        }
//
//        public Fraction multiply(Fraction other) {
//            int newNumerator = (this.whole * this.denominator + this.numerator) * (other.whole * other.denominator + other.numerator);
//            int newDenominator = this.denominator * other.denominator;
//            return new Fraction(newNumerator, newDenominator);
//        }
//
//        public Fraction divide(Fraction other) {
//            int newNumerator = (this.whole * this.denominator + this.numerator) * other.denominator;
//            int newDenominator = (other.whole * other.denominator + other.numerator) * this.denominator;
//            return new Fraction(newNumerator, newDenominator);
//        }
//
//        private int gcd(int a, int b) {
//            if (b == 0)
//                return a;
//            return gcd(b, a % b);
//        }
//
//        private void simplify() {
//            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
//            numerator /= gcd;
//            denominator /= gcd;
//            whole += numerator / denominator;
//            numerator %= denominator;
//        }
//
//        @Override
//        public String toString() {
//            if (numerator == 0) {
//                return String.valueOf(whole);
//            } else if (whole == 0) {
//                return numerator + "/" + denominator;
//            } else {
//                return whole + " " + numerator + "/" + denominator;
//            }
//        }
//    }
//
//
