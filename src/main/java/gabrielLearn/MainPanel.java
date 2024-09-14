package gabrielLearn;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private JTextField[][] board;
    private SolveButton solveButton;

    public JTextField[][] getBoard() {
        return board;
    }

    public void setCells(JTextField[][] board) {
        this.board = board;
    }

    public MainPanel() {
        this.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        board = new JTextField[9][9];

        for (int i = 0; i < 9; i++) {
            JPanel subgridPanel = new JPanel();
            subgridPanel.setLayout(new GridLayout(3, 3));
            subgridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            for (int j = 0; j < 9; j++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(new Font("SansSerif", Font.BOLD, 20));
                board[i][j] = cell;
                subgridPanel.add(cell);

                cell.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateButtonState();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateButtonState();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateButtonState();
                    }
                });
            }

            boardPanel.add(subgridPanel);
        }

        this.add(boardPanel, BorderLayout.CENTER);


        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("SansSerif", Font.BOLD, 18));


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearBoard();
            }
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setSolveButton(SolveButton solveButton) {
        this.solveButton = solveButton;
        updateButtonState();
    }

    public void updateButtonState() {
        if (solveButton != null) {
            solveButton.updateButtonState();
        }
    }

    private void clearBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j].setText("");
            }
        }
    }
}
