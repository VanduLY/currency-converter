import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class CurrencyConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        // Components
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();
        JLabel fromLabel = new JLabel("From Currency:");
        JComboBox<String> fromCurrency = new JComboBox<>(new String[]{"USD", "EUR", "INR"});
        JLabel toLabel = new JLabel("To Currency:");
        JComboBox<String> toCurrency = new JComboBox<>(new String[]{"USD", "EUR", "INR"});
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result: ");

        // Action listener for convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String from = (String) fromCurrency.getSelectedItem();
                    String to = (String) toCurrency.getSelectedItem();
                    double conversionRate = getConversionRate(from, to);
                    double result = amount * conversionRate;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        // Adding components to panel
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(fromLabel);
        panel.add(fromCurrency);
        panel.add(toLabel);
        panel.add(toCurrency);
        panel.add(convertButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Method to simulate conversion rate lookup (for demonstration purposes)
    public static double getConversionRate(String from, String to) {
        if (from.equals("USD") && to.equals("EUR")) return 0.85;
        if (from.equals("USD") && to.equals("INR")) return 74.5;
        if (from.equals("EUR") && to.equals("USD")) return 1.18;
        if (from.equals("EUR") && to.equals("INR")) return 87.6;
        if (from.equals("INR") && to.equals("USD")) return 0.013;
        if (from.equals("INR") && to.equals("EUR")) return 0.011;
        return 1; // Same currency
    }
}
