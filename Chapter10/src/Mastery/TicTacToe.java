package Mastery;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class TicTacToe {
	
	/*

	Program: TicTacToe.java          

	Purpose: Update BreakAPlate to show prize images instead of text. 
	Use tiger_plush.gif and sticker.gif for prizes, and display placeholder.gif at the start of each game.

	Author: Usman Elmi, 
	School: CHHS
	Course: Computer Programming 30
	 

	*/
    static int moveCount = 0;
    static String[] cells = new String[9];

    private JFrame frame;
    private JLabel statusLabel;

    // winning index combinations
    private static final int[][] WIN_LINES = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    public static String checkWinner() {
        for (int[] line : WIN_LINES) {
            String a = cells[line[0]];
            String b = cells[line[1]];
            String c = cells[line[2]];

            if (a == null || b == null || c == null) continue;

            if (a.equals(b) && b.equals(c)) {
                return "The winner is " + a;
            }
        }

        if (moveCount == 9) {
            return "Tie";
        }

        return null;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TicTacToe window = new TicTacToe();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TicTacToe() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 459, 356);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(64, 128, 128));
        panel.setBounds(0, 0, 450, 307);
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        statusLabel = new JLabel("The winner is ");
        statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        statusLabel.setBounds(24, 249, 200, 14);
        panel.add(statusLabel);

        int x = 10, y = 11;
        int index = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton btn = createButton(index);
                btn.setBounds(x + col * 146, y + row * 73, 136, 62);
                panel.add(btn);
                index++;
            }
        }
    }

    private JButton createButton(int position) {
        JButton button = new JButton("");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!button.getText().equals("")) return;

                moveCount++;
                String mark = (moveCount % 2 == 1) ? "X" : "O";

                button.setText(mark);
                cells[position] = mark;

                String result = checkWinner();
                if (result != null) {
                    statusLabel.setText(result);
                }
            }
        });

        return button;
    }
}