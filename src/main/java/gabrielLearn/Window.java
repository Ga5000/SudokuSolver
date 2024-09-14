package gabrielLearn;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {
    public Window() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setTitle("Sudoku Solver");
        this.setLayout(new BorderLayout());

        MainPanel mainPanel = new MainPanel();
        SolveButton solveButton = new SolveButton(mainPanel);

        mainPanel.setSolveButton(solveButton);

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(solveButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}


