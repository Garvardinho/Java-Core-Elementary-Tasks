package geekbrains.java_core_elementary.hw;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1");
        int[] task1Arr = {1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0};
        System.out.println("Before:\t" + Arrays.toString(task1Arr));
        task1(task1Arr);
        System.out.println("After:\t" + Arrays.toString(task1Arr));

        // Task 2
        System.out.println("\nTask 2");
        int[] task2Arr = new int[8];
        task2(task2Arr);
        System.out.println("Array: " + Arrays.toString(task2Arr));

        // Task 3
        System.out.println("\nTask 3");
        int[] task3Arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Before:\t" + Arrays.toString(task3Arr));
        task3(task3Arr);
        System.out.println("After:\t" + Arrays.toString(task3Arr));

        // Task 4
        System.out.println("\nTask 4");
        int[] task4Arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < task4Arr.length; ++i)
            task4Arr[i] = rand.nextInt(15);

        int min = getMin(task4Arr);
        int max = getMax(task4Arr);
        System.out.println("Array: " + Arrays.toString(task4Arr));
        System.out.println("Min: " + min + "; Max: " + max);

        // Task 5
        System.out.println("\nTask 5");
        int[][] task5Arr = new int[5][5];
        task5(task5Arr);
        System.out.println("Array: ");
        for (int[] rows : task5Arr)
            System.out.println(Arrays.toString(rows));

        // Task 6
        System.out.println("\nTask 6");
        System.out.println("checkBalance([1, 1, 1, 2, 1]) --> " + checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println("checkBalance([2, 1, 1, 2, 1]) --> " + checkBalance(new int[]{2, 1, 1, 2, 1}));
        System.out.println("checkBalance([10, 1, 2, 3, 4]) --> " + checkBalance(new int[]{10, 1, 2, 3, 4}));

        // Task 7
        System.out.println("\nTask 7");
        int[] task7Arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Array:\t\t" + Arrays.toString(task7Arr));
        task7(task7Arr, 9);
        System.out.println("After +9:\t" + Arrays.toString(task7Arr));
        task7(task7Arr, -4);
        System.out.println("After -4:\t" + Arrays.toString(task7Arr));

        // Task 8
        System.out.println("\nTask 8");
        int[] task8Arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Array:\t\t" + Arrays.toString(task8Arr));
        task8(task8Arr, 10);
        System.out.println("After +10:\t" + Arrays.toString(task8Arr));
        task8(task8Arr, -2);
        System.out.println("After -2:\t" + Arrays.toString(task8Arr));

        // Hardcore task
        System.out.println("\nHardcore task");
        int[] hardArr1 = new int[15];
        int[] hardArr2 = new int[10];

        for (int i = 0; i < hardArr1.length; ++i)
            hardArr1[i] = rand.nextInt(15);

        for (int i = 0; i < hardArr2.length; ++i)
            hardArr2[i] = rand.nextInt(15);

        System.out.println("Array 1: " + Arrays.toString(hardArr1));
        System.out.println("Array 2: " + Arrays.toString(hardArr2));
        System.out.println("Result: " + Arrays.toString(hardcoreTask(hardArr1, hardArr2)));

        // Combo-Hardcore task
        System.out.println("\nHardcore task");

        // You can modify this arrays as you wish
        int[][] comboHardArr1 = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8}
        };

        int[][] comboHardArr2 = {
                {5, 6, 7},
                {6, 7, 8}
        };

        System.out.println("Array:");
        for (int[] rows : comboHardArr1)
            System.out.println(Arrays.toString(rows));

        System.out.println("\nArray to find:");
        for (int[] rows : comboHardArr2)
            System.out.println(Arrays.toString(rows));

        System.out.println("\nResult: " + comboHardcoreTask(comboHardArr1, comboHardArr2));
    }

    public static void task1(int []arr) {
        for (int i = 0; i < arr.length; ++i)
            arr[i] = (arr[i] == 0) ? 1 : 0;
    }

    public static void task2(int []arr) {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = 3 * i + 1;
        }
    }

    public static void task3(int []arr) {
        for (int i = 0; i < arr.length; ++i)
            if (arr[i] < 6)
                arr[i] *= 2;
    }

    public static int getMin (int []arr) {
        int min = arr[0];

        for (int el : arr)
            if (el < min) min = el;

        return min;
    }

    public static int getMax (int []arr) {
        int max = arr[0];

        for (int el : arr)
            if (el > max) max = el;

        return max;
    }

    public static void task5(int [][]arr) {
        for (int i  = 0; i < arr.length; ++i)
            for (int j = 0; j < arr.length; ++j)
                if (i == j) arr[i][j] = 1;
    }

    public static boolean checkBalance(int []arr) {
        int left;
        int right;

        for (int i = 0; i < arr.length; ++i) {
            left = 0;
            right = 0;

            for (int j = 0; j < arr.length; ++j) {
                if (j < i)
                    left += arr[j];
                else
                    right += arr[j];
            }

            if (left == right)
                return true;
        }

        return false;
    }

    public static void task7 (int []arr, int shift) {
        int[] tmp = new int[arr.length];

        shift %= arr.length; // To protect from shift > arr.length

        for (int i = 0; i < arr.length; ++i)
            tmp[i] = arr[(shift >= 0) ? (i + arr.length - shift) % arr.length : (i - shift) % arr.length];

        System.arraycopy(tmp, 0, arr, 0, arr.length);
    }

    public static void task8 (int []arr, int shift) {
        int tmp1;
        int tmp2 = arr[0];
        int changePos;
        int pos = 0;

        shift %= arr.length;

        for (int i = 0; i < arr.length; ++i) {
            tmp1 = tmp2;

            if (shift >= 0)
                changePos = (pos + shift) % arr.length;
            else
                changePos = (arr.length + pos + shift) % arr.length;

            tmp2 = arr[changePos];
            arr[changePos] = tmp1;
            pos = changePos;
        }
    }

    public static int[] hardcoreTask(int []arr1, int []arr2) {
        int[] tmp = new int[arr1.length];
        int index = 0;
        boolean isAlreadyInResult = false;
        boolean isInTheSecond = false;

        for (int i : arr1) {
            for (int j : arr2) {
                if (i == j) {
                    isInTheSecond = true;
                    break;
                }
            }

            if (!isInTheSecond) {
                // Checking for duplicate items
                for (int k = 0; k < index; ++k) {
                    if (tmp[k] == i) {
                        isAlreadyInResult = true;
                        break;
                    }
                }

                if (!isAlreadyInResult) {
                    tmp[index] = i;
                    ++index;
                }

                isAlreadyInResult = false;
            }

            isInTheSecond = false;
        }

        return Arrays.copyOf(tmp, index);
    }

    public static boolean comboHardcoreTask(int [][]arr1, int [][]arr2) {
        int tmpRow;
        int tmpCol;
        boolean result;

        for (int i = 0; i < arr1.length; ++i) {
            for (int j = 0; j < arr1[i].length; ++j) {
                if (arr1[i][j] == arr2[0][0]) {
                    tmpRow = i;
                    tmpCol = j;
                    result = true;

                    for (int k = 0; k < arr2.length; ++k, ++i) {
                        for (int z = 0; z < arr2[k].length; ++z, ++j) {
                            if (i == arr1.length || j == arr1[i].length || arr1[i][j] != arr2[k][z]) {
                                result = false;
                                break;
                            }
                        }

                        if (!result)
                            break;

                        j = tmpCol;
                    }

                    if (result)
                        return true;

                    i = tmpRow;
                    j = tmpCol;
                }
            }
        }

        return false;
    }
}
