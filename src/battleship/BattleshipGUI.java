package battleship;

import javax.swing.*;
import java.awt.*;

public class BattleshipGUI extends JFrame {

    private JButton[][] buttons = new JButton[10][10];
    private Game game;
    private GameController controller;

    private JLabel statsLabel;

    public BattleshipGUI() {
        setupGame();
        buildUI();
    }

    private void setupGame() {
        game = new Game();
        controller = new GameController(game);
    }

    private void buildUI() {
        setTitle("Battleship");
        setSize(600, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(10,10));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                JButton btn = new JButton("~");
                int r = i, c = j;

                btn.addActionListener(e -> handleMove(btn, r, c));

                buttons[i][j] = btn;
                gridPanel.add(btn);
            }
        }

        statsLabel = new JLabel();
        updateStats();

        // 🔥 BUTTON PANEL
        JPanel bottomPanel = new JPanel(new GridLayout(3,1));

        bottomPanel.add(statsLabel);

        JButton playAgain = new JButton("Play Again");
        playAgain.addActionListener(e -> resetGame());

        JButton quit = new JButton("Quit");
        quit.addActionListener(e -> quitGame());

        bottomPanel.add(playAgain);
        bottomPanel.add(quit);

        add(gridPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void handleMove(JButton btn, int r, int c) {
        String result = controller.handleClick(r,c);

        if (result.equals("Hit")) {
            btn.setText("X");
            btn.setBackground(Color.RED);
        }
        else if (result.equals("Miss")) {
            btn.setText("M");
            btn.setBackground(Color.YELLOW);
        }
        else if (result.equals("Sunk")) {
            btn.setText("X");
            btn.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Ship Sunk!");
        }

        btn.setEnabled(false);
        updateStats();

        if (game.checkWin()) {
            JOptionPane.showMessageDialog(this, "YOU WIN!");
            disableBoard();
        }

        if (game.checkLoss()) {
            JOptionPane.showMessageDialog(this, "YOU LOSE!");
            disableBoard();
        }
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

    private void disableBoard() {
        for (JButton[] row : buttons)
            for (JButton b : row)
                b.setEnabled(false);
    }

    private void resetGame() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to start a new game?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            getContentPane().removeAll();
            setupGame();
            buildUI();
            revalidate();
            repaint();
        }
    }

    private void quitGame() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to quit?",
                "Quit",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}