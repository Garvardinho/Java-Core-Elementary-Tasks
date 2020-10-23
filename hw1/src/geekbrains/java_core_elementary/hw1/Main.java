package geekbrains.java_core_elementary.hw;

public class Main {

    // Task 1
    public static void main(String[] args) {
        // Task 2
        byte byteVal = -128;
        short shortVal = -32768;
        int intVal = -2147483648;
        long longVal = 123123123L;
        float floatVal = 3.57F;
        double doubleVal = 5.1;
        char charVal = 'u';
        boolean boolVal = true;
        String stringVal = new String("string");

        int a = 8, b = 7, c = 6, d = 5;

        // Task 3
        System.out.println("Task 3");
        System.out.println("a = " + a + "\nb = " + b + "\nc = " + c + "\nd = " + d);

        if (d == 0)
            System.out.println("Division by zero!");
        else
            System.out.println("a * (b + (c / d) = " + task3(a, b, c, d));

        // Task 4
        System.out.println("\nTask 4");
        System.out.println("a = " + a + "\nb = " + b + "\n10 <= (a + b) <= 20 is " + task4(a, b));

        // Task 5
        System.out.println("\nTask 5");
        int task5Val = 203;
        task5(task5Val);

        // Task 6
        System.out.println("\nTask 6");
        int year = 1600;
        System.out.println("Year " + year + " is leap: " + task6(year));
    }

    public static double task3 (int a, int b, int c, int d) {
        return (a * (b + ((double)c / d)));
    }

    public static boolean task4 (int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    public static void task5 (int task5Val) {
        int result = 0;
        int rank;

        if (task5Val >= 100 && task5Val <= 999) {
            rank = task5Val / 100; // Get hundreds
            result += rank; // Convert hundreds to units
            rank = (task5Val / 10) % 10; // Get tens
            result += rank * 10; // Tens to tens
            rank = task5Val % 10; // Get units
            result += rank * 100; // Units to hundreds
            System.out.println("Result: " + result);
        } else
            System.out.println("Number is not in the range");

        return;
    }

    public static boolean task6 (int year) {
        return ((year % 4 == 0) && (year % 100 == year % 400));
    }
}
