package prog2.prelimgroup;
import java.lang.*;
import java.util.*;

public class FractionArithmetic {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String inputF1, inputF2;
        String[] parts1, parts2;
        int choice = 0, n1, d1, n2, d2;
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();

        System.out.print("""
                +------------------------------------------------------------------+
                |   Welcome to our Fraction Arithmetic Program Collection!   |
                +------------------------------------------------------------------+
                This Java program allows you to perform various operations on fractions,
                providing a handy tool for fraction arithmetic. Feel free to explore and
                use the functionalities offered by our talented team of developers!
                +------------------------------------------------------------------+
                Created by GROUP 4:
                    Calub, Jon Delvic
                    Cube, Robert Sej
                    Ferrer, Jhon Michael L.
                    Galapate, Francie Gabrielle
                    Manuntag, Wilian
                    Mendoza, Prince Ashrin Yxie
                +------------------------------------------------------------------+
                """);
        do {
            System.out.println("Please input the values of fraction 1 (e.g., 1/5):");
            System.out.print("Input fraction: ");
            inputF1 = kbd.nextLine();
            parts1 = inputF1.split("/");
            if (parts1.length != 2) {
                System.out.println("Invalid input. Please use the format 'numerator/denominator'.");
                continue; // Restart the loop
            }
            try {
                n1 = Integer.parseInt(parts1[0]);
                d1 = Integer.parseInt(parts1[1]);
                if (n1 == 0 || d1 == 0) {
                    System.out.println("Invalid input. Numerator and denominator cannot be zero.");
                    continue; // Restart the loop
                }
                f1 = new Fraction(n1, d1);
                break; // Exit the loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Numerator and denominator must be integers.");
            }
        } while (true);

        do {
            System.out.println("Please input the values of fraction 2 (e.g., 3/4):");
            System.out.print("Input fraction: ");
            inputF2 = kbd.nextLine();
            parts2 = inputF2.split("/");
            if (parts2.length != 2) {
                System.out.println("Invalid input. Please use the format 'numerator/denominator'.");
                continue; // Restart the loop
            }
            try {
                n2 = Integer.parseInt(parts2[0]);
                d2 = Integer.parseInt(parts2[1]);
                if (n2 == 0 || d2 == 0) {
                    System.out.println("Invalid input. Numerator and denominator cannot be zero.");
                    continue; // Restart the loop
                }
                f2 = new Fraction(n2, d2);
                break; // Exit the loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Numerator and denominator must be integers.");
            }
        } while (true);

        while (true) {
            System.out.println("Press [ENTER] to see the Main Menu"); // Display menu
            if (kbd.hasNextLine()) {
                System.out.println(kbd.nextLine());
                System.out.print("""
                +------ What do you want to do? ------+
                | ==================================== |
                | 1. Enter value of fraction 1         |
                | 2. Enter value of fraction 2         |
                | 3. Add Fractions                     |
                | 4. Subtract Fractions                |
                | 5. Multiply Fractions                |
                | 6. Divide Fractions                  |
                | 7. Reduce Fractions                  |
                | 8. Quit                              |
                +------------------------------------+
                """);
                System.out.print("Input the number corresponding to your choice: "); // Input for chosen Java Program
                try {
                    choice = Integer.parseInt(kbd.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Try again");
                    // Handle the exception or ask the user to input again.
                }
                System.out.println();
                switch (choice) {
                    case 1:
                        do {
                            System.out.println("Please input the values of fraction 1 (e.g., 1/5):");
                            System.out.print("Input fraction: ");
                            inputF1 = kbd.nextLine();
                            parts1 = inputF1.split("/");
                            if (parts1.length != 2) {
                                System.out.println("Invalid input. Please use the format 'numerator/denominator'.");
                                continue; // Restart the loop
                            }
                            try {
                                n1 = Integer.parseInt(parts1[0]);
                                d1 = Integer.parseInt(parts1[1]);
                                if (n1 == 0 || d1 == 0) {
                                    System.out.println("Invalid input. Numerator and denominator cannot be zero.");
                                    continue; // Restart the loop
                                }
                                f1 = new Fraction(n1, d1);
                                break; // Exit the loop if input is valid
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Numerator and denominator must be integers.");
                            }
                        } while (true);
                        break;
                    case 2:
                        do {
                            System.out.println("Please input the values of fraction 2 (e.g., 3/4):");
                            System.out.print("Input fraction: ");
                            inputF2 = kbd.nextLine();
                            parts2 = inputF2.split("/");
                            if (parts2.length != 2) {
                                System.out.println("Invalid input. Please use the format 'numerator/denominator'.");
                                continue; // Restart the loop
                            }
                            try {
                                n2 = Integer.parseInt(parts2[0]);
                                d2 = Integer.parseInt(parts2[1]);
                                if (n2 == 0 || d2 == 0) {
                                    System.out.println("Invalid input. Numerator and denominator cannot be zero.");
                                    continue; // Restart the loop
                                }
                                f2 = new Fraction(n2, d2);
                                break; // Exit the loop if input is valid
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Numerator and denominator must be integers.");
                            }
                        } while (true);
                        break;
                    case 3:
                        System.out.printf("""
                    +------------------------------------+
                    |      Program: Add Fractions        |
                    +------------------------------------+
                    %s
                    +------------------------------------+
                    """, f1.add(f2));
                        break;

                    case 4:
                        System.out.printf("""
                    +---------------------------------------+
                    |   Program: Subtract Fractions         |
                    +---------------------------------------+
                    %s
                    +---------------------------------------+
                    """, f1.subtract(f2));
                        break;

                    case 5:
                        System.out.printf("""
                    +---------------------------------------+
                    |  Program: Multiply Fractions          |
                    +---------------------------------------+
                    %s
                    +---------------------------------------+
                    """, f1.multiply(f2));

                        break;
                    case 6:
                        System.out.printf("""
                    +-------------------------------------+
                    |   Program: Divide Fractions         |
                    +-------------------------------------+
                    %s
                    +-------------------------------------+
                    """, f1.divide(f2));

                        break;
                    case 7:
                        System.out.print("""
                    +-------------------------------------+
                    |   Program: Reduce Fractions         |
                    +-------------------------------------+
                    | Output for Fraction 1:""");
                        f1.reducingFraction(f1.getNumerator(), f1.getDenominator());
                        System.out.println();
                        System.out.print("""
                    +-------------------------------------+
                    | Output for Fraction 2:""");
                        f2.reducingFraction(f2.getNumerator(), f2.getDenominator());
                        System.out.println();
                        System.out.print("""
                    +-------------------------------------+
                    """);

                        break;
                    case 8:
                        System.out.print("""
                    +------------------------------------+
                    |        Program: Quit               |
                    +------------------------------------+
                    | Program Terminated... Good bye     |
                    +------------------------------------+
                    """);
                        System.exit(0); // Ending the program
                        break;
                    default:
                        System.out.println("Invalid input. Try again");
                } // End of switch cases
            } // End of if-else
        } // End of while loop
    } // End of main method
} // End of main class

