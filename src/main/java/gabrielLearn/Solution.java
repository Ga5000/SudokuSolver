package gabrielLearn;

import javax.swing.*;
import java.awt.*;

public class Solution {
    public static void solveSudoku(JTextField[][] board){

        int[][] sudokuBoard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String text = board[i][j].getText();
                if (!text.isEmpty()) {
                    sudokuBoard[i][j] = Integer.parseInt(text);
                } else {
                    sudokuBoard[i][j] = 0;
                }
            }
        }


        if (solveSudokuLogic(sudokuBoard, 9)) {

            MainPanel solvedPanel = createSolvedPanel(sudokuBoard);
            createSolutionWindow(solvedPanel);
        } else {
            JOptionPane.showMessageDialog(null, "No solution found.");
        }
    }


    public static boolean solveSudokuLogic(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudokuLogic(board, n)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }


    public static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < 9; d++) {
            if (board[row][d] == num || board[d][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(9);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void createSolutionWindow(MainPanel mainPanel){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(new Dimension(500, 500));
        window.setTitle("Sudoku Solver");

        window.add(mainPanel);
        window.setVisible(true);
    }


    public static MainPanel createSolvedPanel(int[][] solvedBoard) {
        MainPanel panel = new MainPanel();
        JTextField[][] board = panel.getBoard();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j].setText(String.valueOf(solvedBoard[i][j]));
            }
        }

        return panel;
    }
}
