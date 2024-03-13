package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterKeyActionExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Enter Key Action Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20);

        // Dodanie ActionListener do pola tekstowego
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Wywołanie określonej akcji po naciśnięciu Enter
                String text = textField.getText();
                System.out.println("Wprowadzono: " + text);
                // Tutaj możesz wykonać dowolną akcję w zależności od wprowadzonego tekstu
            }
        });

        panel.add(textField);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
