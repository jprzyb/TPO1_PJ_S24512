package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiComponents {
    public static int w=495;
    public static int h=495;
    public static JTextField getCountryTextField(){
        JTextField field = new JTextField("Georgia");

        field.setSize(150,30);
        field.setPreferredSize(new Dimension(150,30));

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoFrame(
                        NBPRate.twoTablesCall().toString()
                         ,"NBP PLN exchange for "+MainFrame.city.getText()
                );
            }
        });

        return field;
    }
    public static JTextField getCityTextField(){
        JTextField field = new JTextField("Budapest");

        field.setSize(150,30);
        field.setPreferredSize(new Dimension(150,30));

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoFrame(
                        Weather.callWeather(
                                MainFrame.city.getText().
                                        replace(",",",\n").replace("{","{\n").replace("}","\n}")
                        ), "Weather in "+ MainFrame.city.getText()
                );
            }
        });

        return field;
    }
    public static JTextField getCurrencyCodeTextField(){
        JTextField field = new JTextField("USD");

        field.setSize(150,30);
        field.setPreferredSize(new Dimension(150,30));

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoFrame(
                        ExchangeRate.callExcghangeRate(
                                MainFrame.currency.getText())
                        , "Exchange rate for "+MainFrame.currency.getText()
                );
            }
        });
        return field;
    }

    public static JButton getWebButton(){
        JButton button = new JButton("Wiki City");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    WebFrame browser = new WebFrame(MainFrame.city.getText());
                    browser.setVisible(true);
                });
            }
        });
    return button;
    }

    public static JLabel getlabel(String text){
        JLabel label = new JLabel(text);
        label.setSize(150,30);
        label.setPreferredSize(new Dimension(150,30));

        return label;
    }
}
