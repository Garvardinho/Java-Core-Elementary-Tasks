package geekbrains.java_core_elementary.hw;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileInputStream fis1;
        FileInputStream fis2;
        FileOutputStream fos;

        // Task 2
        try
        {
            int symbol;
            fis1 = new FileInputStream("file1.txt");
            fis2 = new FileInputStream("file2.txt");
            fos = new FileOutputStream("result.txt");

            while ((symbol = fis1.read()) != -1)
                fos.write(symbol);

            while ((symbol = fis2.read()) != -1)
                fos.write(symbol);

            fis1.close();
            fis2.close();
            fos.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        // Task 3
        System.out.println("Task 3");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word to find in result.txt: ");
        String word = scanner.nextLine();

        try {
            fis1 = new FileInputStream("result.txt");

            if (findInFile(word, fis1))
                System.out.println("Word '" + word + "' was found");
            else
                System.out.println("There is no word '" + word + "'");

            fis1.close();
        } catch (IOException e) {
            System.out.println("Error while opening the file");
        }

        // Task 4
        System.out.println("\nTask 4");
        String pathname = "D:";
        File dir = new File(pathname);
        System.out.print("Enter the word to find in \"" + dir + "\": ");
        word = scanner.nextLine();
        try {
            File[] files = findInDirectory(word, dir);

            if (files.length == 0)
                System.out.println("There is no word '" + word + "' in \"" + dir + "\"");
            else
                for (int i = 0; i < files.length; i++)
                    System.out.println(files[i].getName() + " contains '" + word + "'");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static boolean findInFile(String word, FileInputStream file) throws IOException {
        int symbol;
        StringBuilder tmp = new StringBuilder();

        /*
        * This function finds word 'line' in 'file'.
        * There is no difference between lower and upper case,
        * so it can be possible to find the word when its characters case is unknown
         */
        while ((symbol = file.read()) != -1) {
            if ((symbol == (int)' ' ||
                    symbol == (int)'.' ||
                    symbol == (int)',' ||
                    symbol == (int)'\n' ||
                    symbol == (int)'\r') &&
                    !tmp.toString().isEmpty()) {
                if (tmp.toString().equals(word))
                    return true;
                else
                    tmp.delete(0, tmp.toString().length());
            }
            else
                tmp.append(Character.toLowerCase((char) symbol));

        }

        return false;
    }

    private static File[] findInDirectory (String word, File dir) throws Exception {
        FileInputStream fis;
        File[] result = new File[0];

        // This code below puts only 'txt' files from 'pathname' into matchingFiles array
        File[] matchingFiles = dir.listFiles(path -> path.getAbsolutePath().contains(".txt"));
        if (matchingFiles == null)
            throw new Exception("Directory path error");

        if (matchingFiles.length == 0)
            throw new Exception("There is no 'txt' files in \"" + dir + "\"");

        for (int i = 0; i < matchingFiles.length; i++) {
            try {
                fis = new FileInputStream(matchingFiles[i].getAbsolutePath());

                if (findInFile(word, fis)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = matchingFiles[i];
                }
            } catch (IOException e) {
                System.out.println("Error while opening " + matchingFiles[i].getName());
            }
        }

        return result;
    }
}
