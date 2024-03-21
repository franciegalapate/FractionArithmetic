package prog2.midgroup01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MixedFractionCalculator implements ActionListener {

    private JFrame frame;
    private JPanel panel;
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
    private JButton answer;
    private JLabel result;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    MixedFractionCalculator() {
        frame = new JFrame("Mixed Fractions Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        //1st numerator
        textField1 = new JTextField();
        textField1.setBounds(150, 50, 75, 100);
        textField1.setFont(myFont);

        //1st denominator
        textField2 = new JTextField();
        textField2.setBounds(150, 250, 75, 100);
        textField2.setFont(myFont);

        //1st whole number
        textField3 = new JTextField();
        textField3.setBounds(50, 150, 75, 100);
        textField3.setFont(myFont);

        //2nd numerator
        textField4 = new JTextField();
        textField4.setBounds(550, 50, 75, 100);
        textField4.setFont(myFont);

        //2nd denominator
        textField5 = new JTextField();
        textField5.setBounds(550, 250, 75, 100);
        textField5.setFont(myFont);

        //2nd whole number
        textField6 = new JTextField();
        textField6.setBounds(450, 150, 75, 100);
        textField6.setFont(myFont);

        answer = new JButton("Calculate");
        answer.setBounds(250, 375, 250, 50);
        answer.setFont(myFont);
        answer.addActionListener(this);

        result = new JLabel();
        result.setBounds(250, 425, 250, 50);
        result.setFont(myFont);

        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(textField4);
        frame.add(textField5);
        frame.add(textField6);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(mulButton);
        frame.add(divButton);
        frame.add(answer);
        frame.add(result);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MixedFractionCalculator calculator = new MixedFractionCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            fractionInner f1 = new fractionInner(Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText()));
            fractionInner f2 = new fractionInner(Integer.parseInt(textField3.getText()), Integer.parseInt(textField4.getText()));
            fractionInner res;
            if (e.getSource() == addButton) {
                res = f1.add(f2);
            } else if (e.getSource() == subButton) {
                res = f1.sub(f2);
            } else if (e.getSource() == mulButton) {
                res = f1.mul(f2);
            } else if (e.getSource() == divButton) {
                res = f1.div(f2);
            } else {
                res = new fractionInner(1, 1);
            }
            result.setText(res.toString());
        } catch (Exception excep) {
            System.out.println(excep.getMessage());
        }
    }
}

class ZeroDenominatorException extends Exception {
    ZeroDenominatorException() {
        super("Fraction denominator cannot be 0.");
    }
}
