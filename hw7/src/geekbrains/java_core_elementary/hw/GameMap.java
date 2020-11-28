package geekbrains.java_core_elementary.hw;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JFrame {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    public static final int WINDOW_POSX = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WINDOW_WIDTH / 2;
    public static final int WINDOW_POSY = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - WINDOW_HEIGHT / 2;
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    GameMap() {
        setBackground(Color.BLACK);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setTitle("Tic-Tac-Toe");
        setResizable(false);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        JPanel field = new JPanel();
        field.setLayout(new GridLayout(fieldSizeY, fieldSizeX));
        field.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        for (int i = 0; i < (fieldSizeX * fieldSizeY); i++) {
            final JLabel label = new JLabel("");
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            field.add(label);
        }

        add(field);
        setVisible(true);
    }
}
