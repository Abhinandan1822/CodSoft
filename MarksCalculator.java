import java.util.Scanner;

public class MarksCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Subjects list
        String[] subjects = {"Accounts", "Business Studies", "Economics", "English", "Maths"};
        int totalMarks = 0;
        int numOfSubjects = subjects.length;

        // Start the conversation with the user
        System.out.println("\nHey there! Welcome to the Marks Calculator. Let's see how you did in your subjects today!");

        // Loop to take marks input for each subject
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("\nHow many marks did you score in " + subjects[i] + "? (Out of 100): ");
            int marks = scanner.nextInt();
            totalMarks += marks;  // Add the marks to the total
        }

        // Calculate the average percentage
        double averagePercentage = (double) totalMarks / numOfSubjects;

        // Determine the grade based on the percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 75) {
            grade = "B";
        } else if (averagePercentage >= 50) {
            grade = "C";
        } else {
            grade = "D";
        }

        // Display the results in a more personalized way
        System.out.println("\n--- Your Results Are In ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numOfSubjects * 100));
        System.out.println("Your Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Based on your performance, your grade is: " + grade);

        System.out.println("\nThanks for sharing your marks with me! Keep up the great work, and remember, each day is a new opportunity to shine!");

        scanner.close();
    }
}
