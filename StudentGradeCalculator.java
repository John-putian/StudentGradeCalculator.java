import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentGradeCalculator {

    // Method to calculate the average grade from file
    public static double calculateAverageGrade(String filename) {
        double total = 0;
        int count = 0;

        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNext()) {
                String name = fileScanner.next();
                if (fileScanner.hasNextDouble()) {
                    double grade = fileScanner.nextDouble();
                    total += grade;
                    count++;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return 0;
        }

        if (count == 0) return 0;
        return total / count;
    }

    // Method to print each student's name and grade
    public static void printStudentGrades(String filename) {
        System.out.println("Student Grades:");

        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNext()) {
                String name = fileScanner.next();
                if (fileScanner.hasNextDouble()) {
                    double grade = fileScanner.nextDouble();
                    System.out.println(name + ": " + (int) grade);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        String filename = "grades.txt";
        printStudentGrades(filename);
        double average = calculateAverageGrade(filename);
        System.out.printf("Average Grade: %.2f\n", average);
    }
}
