package geekbrains.java_core_elementary.hw;

import javax.swing.*;
import java.awt.*;


public class Settings extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    public static final int WINDOW_POSX = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WINDOW_WIDTH / 2;
    public static final int WINDOW_POSY = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - WINDOW_HEIGHT / 2;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";

    private MainWindow mainWindow;

    private JRadioButton humVSAI;
    private JRadioButton humVSHum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    Settings(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setResizable(false);
        setTitle("Settings");
        setLayout(new GridLayout(10, 1));

        addGameModeSetup();
        addFieldMapControl();

        JButton btnPlay = new JButton("Play");
        // Используются ли лямбды в таком виде как внизу, или все равно полностью пишется, как у Вас?
        // Если пишется полностью - обусловлено ли это стилем написания подобного кода?
        btnPlay.addActionListener(e -> btnPlayGameClick());

        add(btnPlay);
        setVisible(false);
    }

    private void addGameModeSetup() {
        add(new JLabel("Choose game mode:"));
        humVSAI = new JRadioButton("Human vs AI", true);
        humVSHum = new JRadioButton("Human vs Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVSHum);
        add(humVSAI);
        add(humVSHum);
    }

    private void addFieldMapControl() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideFieldSize.addChangeListener(e -> {
            int currentValue = slideFieldSize.getValue();
            lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
            slideWinLen.setMaximum(currentValue);
        });

        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen.addChangeListener(e -> lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue()));

        add(new JLabel("Choose field size"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLen);
    }

    private void btnPlayGameClick() {
        int gameMode;

        if (humVSAI.isSelected()) {
            gameMode = GameMap.MODE_HVA;
        } else if (humVSHum.isSelected()) {
            gameMode = GameMap.MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode!");
        }

        int fieldSize = slideFieldSize.getValue();
        int winLength = slideWinLen.getValue();

        mainWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
        setVisible(false);
    }
}
