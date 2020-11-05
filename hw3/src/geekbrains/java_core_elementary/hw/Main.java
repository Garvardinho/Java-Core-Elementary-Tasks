package geekbrains.java_core_elementary.hw;

import java.util.Scanner;

public class Main {
    public static final char EMPTY_CELL = '_';
    public static final char HUMAN_DOT = 'X';
    public static final char PC_DOT = 'O';
    public static final int HUMAN = 0;
    public static final int PC = 1;
    public static final int ROW = 4;

    public static final Scanner SCANNER = new Scanner(System.in);

    public static int humanScore = 0;
    public static int pcScore = 0;
    public static int fieldSizeX = 5;
    public static int fieldSizeY = 5;
    public static char[][] field;

    public static void main(String[] args) {
        game();
    }

    public static void initMap() {
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++)
            for (int x = 0; x < fieldSizeX; x++)
                field[y][x] = EMPTY_CELL;

        printMap();
    }

    public static void printMap() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print("|" + field[y][x]);

                if (x == fieldSizeX - 1)
                    System.out.println("|");
            }
        }

        System.out.println();
    }

    public static void humanTurn() {
        int y;
        int x;

        do {
            System.out.println("Введите координаты:");
            y = SCANNER.nextInt();
            x = SCANNER.nextInt();
        } while (!isValid(y, x) || !isEmpty(y, x));

        field[y][x] = HUMAN_DOT;
    }

    public static boolean isValid(int y, int x) {
        return y >= 0 && y < fieldSizeY && x >= 0 && x < fieldSizeX;
    }

    public static boolean isEmpty(int y, int x) {
        return field[y][x] == EMPTY_CELL;
    }

    public static void pcTurn() {
        boolean isFound = false;

        // Цикл проверки возможного выигрыша
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmpty(y, x)) {
                    field[y][x] = PC_DOT;
                    if (isVictory(PC_DOT)) {
                        isFound = true;
                        break;
                    }
                    else
                        field[y][x] = EMPTY_CELL;
                }
            }

            if (isFound)
                break;
        }

        if (isFound)
            return;

        // Цикл проверки возможной блокировки
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmpty(y, x)) {
                    field[y][x] = HUMAN_DOT;
                    if (isVictory(HUMAN_DOT)) {
                        isFound = true;
                        field[y][x] = PC_DOT;
                        break;
                    }
                    else
                        field[y][x] = EMPTY_CELL;
                }
            }

            if (isFound)
                break;
        }

        if (isFound)
            return;

        // Если обе проверки не дали результата - ставим на свободное место
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmpty(y, x)) {
                    isFound = true;
                    field[y][x] = PC_DOT;
                    break;
                }
            }

            if (isFound)
                break;
        }

    }

    public static boolean isVictory(char c) {
        for (int y = 0; y < fieldSizeY; y++)
            for (int x = 0; x < fieldSizeX; x++)
                if (field[y][x] == c && !isEmpty(y, x) && inARow(y, x))
                    return true;

        return false;
    }

    public static boolean inARow(int y, int x) {
        /*
        Ввиду прохода массива справа-налево и сверху-вниз, следует рассматривать только четыре направления проверки:
        направо, направо-вниз, вниз и налево-вниз.
         */
        boolean right = true;
        boolean right_down = true;
        boolean down = true;
        boolean left_down = true;

        // Если хотя бы один элемент не окажется в нужной стороне - false (для переменной этой стороны)
        for (int i = 1; i < ROW; i++) {
            if (isNotInLine(y, x + i, y, x))
                right = false;

            if (isNotInLine(y + i, x + i, y, x))
                right_down = false;

            if (isNotInLine(y + i, x, y, x))
                down = false;

            if (isNotInLine(y + i, x - i, y, x))
                left_down = false;
        }

        return right || right_down || down || left_down;
    }

    public static boolean isNotInLine(int findY, int findX, int initY, int initX) {
        return (!isValid(findY, findX) || field[findY][findX] != field[initY][initX]);
    }

    public static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++)
            for (int x = 0; x < fieldSizeX; x++)
                if (isEmpty(y, x))
                    return false;

        return true;
    }

    public static void showScore() {
        System.out.println("Human " + humanScore + " - " + pcScore + " PC");
    }

    public static void addScore(int who) {
        if (who == HUMAN) ++humanScore;
        else ++pcScore;
    }

    public static void game() {
        int winStreak = 4;
        initMap();

        while (true) {
            humanTurn();
            printMap();
            if (isVictory(HUMAN_DOT)) {
                System.out.println("Победа!");
                addScore(HUMAN);
                showScore();
                if (humanScore == winStreak) {
                    System.out.println("Игра окончена! Вы выиграли!");
                    break;
                }

                initMap();
                continue; // Начинает всегда человек, поэтому цикл следует начать сначала
            }

            if (isDraw()) {
                System.out.println("Ничья!");
                showScore();
                initMap();
                continue;
            }

            pcTurn();
            printMap();
            if (isVictory(PC_DOT)) {
                System.out.println("Проигрыш!");
                addScore(PC);
                showScore();
                if (pcScore == winStreak) {
                    System.out.println("Игра окончена! ПК выиграл!");
                    break;
                }

                initMap();
            }
        }
    }
}