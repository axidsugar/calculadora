
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author axidsugar
 */
public class Convertir extends javax.swing.JFrame {

    JTextField t1, t2, t3, t4, t5;
    JLabel l1, l2, l3, l4, l5;
    JPanel p, p1, p2;
    JButton b;
    /**
     * Creates new form Convertir
     */
    public Convertir() {
      // initComponents();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Convertir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Convertir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Convertir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Convertir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Convertir().setVisible(true);
            }
        });
       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
