/*
   *************************************************************************************************
   Program: RotaryFormClient.java
   Repository Name: Olalekan AKala
   Date Created: 15-Jul-19
   Program Description: This is the program the user would interact with to create the pdf forms
   using the software
   *************************************************************************************************
*/
import java.util.*;

public class RotaryFormClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getValidMenuChoice(scanner, displayMainMenu()));
    }

    public static int displayMainMenu() {
        System.out.println("\nROTARY FORM MENU\n");
        System.out.println("N - New Form");
        System.out.println("O - Open Form");
        System.out.println("Q - Quit");
        return 0;
    }

    public static char getValidMenuChoice(Scanner scnr, int menu) throws Exception {
        switch (menu) {
            case 0:
                // the loop runs until the user enters a valid menu option
                while (true) {
                    System.out.print("\nChoose an option: ");

                    String userChoice = scnr.next();
                    switch (userChoice.toLowerCase()) {
                        case "n":
                            return 'n';
                        case "o":
                            return 'o';
                        case "q":
                            return 'q';
                    }
                    System.out.println("Please choose a valid option");
                }
            case 1:
                while (true) {
                    System.out.print("\nChoose an option: ");

                    String userChoice = scnr.next();
                    switch (userChoice.toLowerCase()) {
                        case "a":
                            return 'a';
                        case "f":
                            return 'f';
                        case "e":
                            return 'e';
                        case "c":
                            return 'c';
                        case "d":
                            return 'd';
                        case "r":
                            return 'r';
                        case "s":
                            return 's';
                        case "q":
                            return 'q';
                    }
                    System.out.println("Please choose a valid option");
                }
        }
        throw new Exception("Invalid Menu Number");
    }

    public static int displaySubMenu() {
        System.out.println("\nPLEASE CHOOSE AN OPERATION\n");
        System.out.println("A - Add a new record");
        System.out.println("F - Fill record");
        System.out.println("E - Edit record");
        System.out.println("C - Clear record");
        System.out.println("D - Delete record");
        System.out.println("R - Reset form");
        System.out.println("S - Submit form");
        System.out.println("Q - Quit");
        return 0;
    }
}
