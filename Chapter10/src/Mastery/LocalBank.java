package Mastery;

import java.awt.*;
import javax.swing.*;

public class LocalBank {
	/*

	Program: LocalBank.java          

	Purpose: Customers can create an account where they can input their Account ID and be able to insert their money and withdraw money.
	
	Author: Usman Elmi, 
	School: CHHS
	Course: Computer Programming 30
	 

	*/
    private Bank lbank = new Bank();

    private JFrame frame;
    private JTextField anum, adepowith, fn, ln, beginbal;
    private JComboBox<String> action;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LocalBank window = new LocalBank();
            window.frame.setVisible(true);
        });
    }

    public LocalBank() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame("Local Bank System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        frame.add(mainPanel);

        // ===== TOP PANEL =====
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        JLabel title = new JLabel("Select an Action:");
        title.setFont(new Font("Tahoma", Font.BOLD, 16));
        topPanel.add(title, BorderLayout.NORTH);

        action = new JComboBox<>(new String[]{
                "Add account",
                "Remove account",
                "Check balance",
                "Deposit",
                "Withdrawal"
        });

        topPanel.add(action, BorderLayout.CENTER);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // ===== CENTER PANEL =====
        JPanel formPanel = new JPanel(new GridLayout(10, 1, 5, 5));

        formPanel.add(new JLabel("Account ID:"));
        anum = new JTextField();
        formPanel.add(anum);

        formPanel.add(new JLabel("Amount:"));
        adepowith = new JTextField();
        formPanel.add(adepowith);

        formPanel.add(new JLabel("First Name:"));
        fn = new JTextField();
        formPanel.add(fn);

        formPanel.add(new JLabel("Last Name:"));
        ln = new JTextField();
        formPanel.add(ln);

        formPanel.add(new JLabel("Beginning Balance:"));
        beginbal = new JTextField();
        formPanel.add(beginbal);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // ===== BUTTON =====
        JButton processButton = new JButton("Process");
        mainPanel.add(processButton, BorderLayout.SOUTH);

        // Action selection behavior
        action.addActionListener(e -> updateFields());

        // Button behavior
        processButton.addActionListener(e -> processAction());

        updateFields(); // initialize correct field state
    }

    private void updateFields() {

        String selected = action.getSelectedItem().toString();

        // Disable everything first
        anum.setEnabled(false);
        adepowith.setEnabled(false);
        fn.setEnabled(false);
        ln.setEnabled(false);
        beginbal.setEnabled(false);

        switch (selected) {

            case "Add account":
                fn.setEnabled(true);
                ln.setEnabled(true);
                beginbal.setEnabled(true);
                break;

            case "Remove account":
            case "Check balance":
                anum.setEnabled(true);
                break;

            case "Deposit":
            case "Withdrawal":
                anum.setEnabled(true);
                adepowith.setEnabled(true);
                break;
        }

        clearFields();
    }

    private void processAction() {

        try {

            String selected = action.getSelectedItem().toString();
            String result = "";

            switch (selected) {

                case "Add account":
                    double balance = Double.parseDouble(beginbal.getText());
                    result = lbank.addAccount(fn.getText(), ln.getText(), balance);
                    break;

                case "Remove account":
                    result = lbank.deleteAccount(anum.getText());
                    break;

                case "Check balance":
                    result = lbank.checkBalance(anum.getText());
                    break;

                case "Deposit":
                    double deposit = Double.parseDouble(adepowith.getText());
                    result = lbank.transaction(1, anum.getText(), deposit);
                    break;

                case "Withdrawal":
                    double withdraw = Double.parseDouble(adepowith.getText());
                    result = lbank.transaction(2, anum.getText(), withdraw);
                    break;
            }

            JOptionPane.showMessageDialog(frame, result);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame,
                    "Please enter valid numeric values.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        anum.setText("");
        adepowith.setText("");
        fn.setText("");
        ln.setText("");
        beginbal.setText("");
    }
}

