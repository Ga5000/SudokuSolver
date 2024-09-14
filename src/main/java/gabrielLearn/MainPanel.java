package gabrielLearn;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class MainPanel extends JPanel {
    private JTextField[][] cells;
    private SolveButton solveButton;

    public JTextField[][] getCells() {
        return cells;
    }

    public MainPanel() {
        this.setLayout(new GridLayout(3, 3, 5, 5));
        cells = new JTextField[9][9];

        for (int i = 0; i < 9; i++) {
            JPanel subgridPanel = new JPanel();
            subgridPanel.setLayout(new GridLayout(3, 3));
            subgridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            for (int j = 0; j < 9; j++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(new Font("SansSerif", Font.BOLD, 20));
                cells[i][j] = cell;
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

            this.add(subgridPanel);
        }
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
}
