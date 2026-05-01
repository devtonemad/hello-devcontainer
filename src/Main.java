import de.gnubis.BMI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your weight (in kg): ");
        double weight = scanner.nextDouble();

        System.out.println("Enter your height (in meters): ");
        double height = scanner.nextDouble();

        BMI bmiCalculator = new BMI();
        double bmi = bmiCalculator.calculateBMI(weight, height);

        System.out.printf("Your BMI is: %.2f\n", bmi);
        showAdiposityAndMore(bmi);
        printWeightRanges(height);
    }

    private static void showAdiposityAndMore(double bmi) {
        String adiposity;
        if (bmi < 18.5) {
            adiposity = "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            adiposity = "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            adiposity = "Overweight";
        } else {
            adiposity = "Obesity";
        }
        System.out.printf("Your adiposity is: %s\n", adiposity);
    }

    private static void printWeightRanges(double height) {
        double h2 = Math.pow(height, 2);
        System.out.println("\nWeight ranges for your height:");
        System.out.printf("  Underweight:   up to %.2f kg  (BMI < 18.5)\n", 18.5 * h2);
        System.out.printf("  Normal weight: %.2f – %.2f kg  (BMI 18.5 – 24.9)\n", 18.5 * h2, 24.9 * h2);
        System.out.printf("  Overweight:    %.2f – %.2f kg  (BMI 25 – 29.9)\n", 25.0 * h2, 29.9 * h2);
        System.out.printf("  Obesity:       %.2f kg and above  (BMI ≥ 30)\n", 30.0 * h2);
    }
}

