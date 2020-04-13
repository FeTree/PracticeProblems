package IOPractice;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class FindMedianInTxtFile {

    public static void main(String[] args) {
        FindMedianInTxtFile app = new FindMedianInTxtFile();
        app.median();
        app.Quartiles();
    }
    public void median() {
        File file = new File("/Users/davideisenbaum/IdeaProjects/PracticeProblems/src/IOPractice/IncreasingNumbers.txt");
        Scanner scanner;

        double median = 0;

        try {
            scanner = new Scanner(file);
            double lineNumber = 0;
            while (scanner.hasNextLine()) {
                int currentNumber = scanner.nextInt();
                //System.out.println("line " + lineNumber + ": " + currentNumber);
                lineNumber++;
            }

            scanner.close();
            Scanner reScanner = new Scanner(file);

            //for odd numbers
            if (lineNumber % 2 != 0) {
                for (int i = 0; i < lineNumber / 2 && reScanner.hasNextInt(); i++) {
                    median = reScanner.nextInt();
                }
            }
            //even values
            if (lineNumber % 2 == 0) {
                double x = 0;
                double y = 0;

                //get to x
                for (int i = 0; i < lineNumber / 2; i++) {
                    x = reScanner.nextInt();
                }

                reScanner.close();
                Scanner omgReScanner = new Scanner(file);

                //get to y
                for (int i = 0; i < lineNumber / 2 + 1; i++) {
                    y = omgReScanner.nextInt();
                }

                //caluclate average of middle values
                median = (x + y) / 2;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Median: " + median);
    }

    public void Quartiles() {
        File file = new File("/Users/davideisenbaum/IdeaProjects/PracticeProblems/src/IOPractice/IncreasingNumbers.txt");
        Scanner scanner;

        double median = 0;

        double firstQuartile = 0;
        double secondQuartile = 0;
        double thirdQuartile = 0;

        try {
            scanner = new Scanner(file);
            double lineNumber = 0;
            while (scanner.hasNextLine()) {
                int currentNumber = scanner.nextInt();
                //System.out.println("line " + lineNumber + ": " + currentNumber);
                lineNumber++;
            }
            System.out.println("Lines  itch: " + lineNumber);
            if(lineNumber % 2 != 0) {
                lineNumber = lineNumber / 4 ;
            }
            if(lineNumber % 2 == 0){
                lineNumber = lineNumber/ 4;
                System.out.println("Its even so line#:" + lineNumber);
            }
            ArrayList<Double> numbers = new ArrayList<>();

            scanner.reset();
            Scanner rescan = new Scanner(file);

            // print 1st quartile
            int firstQuartileLinesNumber = 0;
            for (int i = 0; rescan.hasNextInt(); i++) {
                double current = rescan.nextInt();
                System.out.print(current + " ");
                numbers.add(current);
                firstQuartileLinesNumber++;
            }

            System.out.println("1/4Lines:" + lineNumber);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public double findAverage(double x, double y) {
        return (x + y) / 2;
    }
}
