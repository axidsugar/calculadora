import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;
import java.text.*;


class Calculadora extends JFrame {

    JTextField t1, t2, t3, t4, t5;
    JLabel l1, l2, l3, l4, l5;
    JPanel p, p1, p2;
    JButton b;

    Calculadora() {
        p = new JPanel(new GridLayout(6, 2));
        p1 = new JPanel(new GridLayout(2, 2));
        p2 = new JPanel(new GridLayout(4, 2));
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        l1 = new JLabel("Enter distance( in Miles)");
        l2 = new JLabel("In KM");
        l3 = new JLabel("In M");
        l4 = new JLabel("In Inches");
        l5 = new JLabel("In CM");
        b = new JButton("Convert");
        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String input = t1.getText();
                Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
                Matcher m = p.matcher(input);
                if (m.find()) {
                    JOptionPane.showMessageDialog(null, "Please enter only numbers");
                }
            }
        });
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String value = t1.getText();
                double distance = Double.parseDouble(value);
                if (distance <= 0) {
                    JOptionPane.showMessageDialog(null, "The value must be greater than zero");
                } else {
                    double km = distance * 1.609344;
                    double m = km * 1000;
                    double cm = m * 100;
                    double inch = m * 39.3700787;
                    DecimalFormat f = new DecimalFormat("##.### ");
                    t2.setText(f.format(km) + " KM");
                    t3.setText(f.format(m) + " M");
                    t4.setText(f.format(inch) + " Inches");
                    t5.setText(f.format(cm) + " CM");

                }
            }
        });
        p1.add(l1);
        p1.add(t1);
        p1.add(b);

        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p2.add(l4);
        p2.add(t4);
        p2.add(l5);
        p2.add(t5);
        p.add(p1);
        p.add(p2);
        add(p);
        setVisible(true);
        pack();
    }

    
}
