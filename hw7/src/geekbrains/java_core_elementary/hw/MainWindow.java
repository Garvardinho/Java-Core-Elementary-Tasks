package geekbrains.java_core_elementary.hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
    public static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 4;
    public static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height / 4;
    public static final int WINDOW_POSX = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WINDOW_WIDTH / 2;
    public static final int WINDOW_POSY = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - WINDOW_HEIGHT / 2;

    private Settings settingsWindow;
    private GameMap gameMap;

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setTitle("Tic-Tac-Toe");

        settingsWindow = new Settings(this);
        gameMap = new GameMap();

        JButton btnStart = new JButton("Create new game");
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        c.gridx = 1;
        c.gridy = 1;
        menuPanel.add(btnStart, c);
        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 0, 0, 0);
        menuPanel.add(btnExit, c);

        add(menuPanel, BorderLayout.CENTER);

        setResizable(false);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }
}
