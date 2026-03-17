package battleship;

import javax.swing.*;
import java.awt.*;

public class BattleshipGUI extends JFrame {

    private JButton[][] buttons = new JButton[10][10];
    private Game game;
    private GameController controller;

    private JLabel statsLabel;

    public BattleshipGUI() {
        game = new Game();
        controller = new GameController(game);

        setTitle("Battleship");
        setSize(600, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(10,10));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton btn = new JButton("~");
                int r = i, c = j;

                btn.addActionListener(e -> {
                    String result = controller.handleClick(r,c);

                    if (result.equals("Hit")) {
                        btn.setText("X");
                        btn.setBackground(Color.RED);
                    } else if (result.equals("Miss")) {
                        btn.setText("M");
                        btn.setBackground(Color.YELLOW);
                    }

                    btn.setEnabled(false);
                    updateStats();

                    if (game.checkWin()) {
                        JOptionPane.showMessageDialog(this, "YOU WIN!");
                    }

                    if (game.checkLoss()) {
                        JOptionPane.showMessageDialog(this, "YOU LOSE!");
                    }
                });

                buttons[i][j] = btn;
                gridPanel.add(btn);
            }
        }

        statsLabel = new JLabel("Stats");
        updateStats();

        add(gridPanel, BorderLayout.CENTER);
        add(statsLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateStats() {
        Statistics s = game.getStats();

        statsLabel.setText(
                "Miss Streak: " + s.getMissStreak() +
                        " | Strikes: " + s.getStrikeCount() +
                        " | Hits: " + s.getTotalHits() +
                        " | Misses: " + s.getTotalMisses()
        );
    }
}