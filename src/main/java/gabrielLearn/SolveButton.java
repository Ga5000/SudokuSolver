package gabrielLearn;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class SolveButton extends JButton {
    private final MainPanel mainPanel;

    public SolveButton(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        this.setSize(new Dimension(100, 100));
        this.setText("Solve Sudoku");
        this.setFont(new Font("SansSerif", Font.BOLD, 20));
        this.setHorizontalTextPosition(SwingConstants.CENTER);

        this.addActionListener(e -> Solution.solveSudoku(mainPanel.getBoard()));
    }

    public void updateButtonState() {
        this.setEnabled(isValidSudoku(mainPanel.getBoard()));

    }

    private boolean isValidSudoku(JTextField[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                Set<String> subgridSet = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        String currentValue = board[i][j].getText().trim();


                        if (!currentValue.isEmpty()) {

                            if (!currentValue.matches("[1-9]")) {
                                return false;
                            }


                            if (!subgridSet.add(currentValue)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }





}
