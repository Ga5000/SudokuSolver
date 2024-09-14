package gabrielLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveButton extends JButton {
    private final MainPanel mainPanel;

    public SolveButton(MainPanel mainPanel) {
        this.mainPanel = mainPanel; // Placeholder
        this.setSize(new Dimension(100, 100));
        this.setText("Solve Sudoku");
        this.setFont(new Font("SansSerif", Font.BOLD, 20));
        this.setHorizontalTextPosition(SwingConstants.CENTER);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement solve Sudoku logic here
            }
        });
    }

    public void updateButtonState() {
        this.setEnabled(areAllCellsFilled(mainPanel.getCells()));
    }

    private boolean areAllCellsFilled(JTextField[][] cells) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField currentCell = cells[row][col];
                if (currentCell.getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
