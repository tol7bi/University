package app;
import Data.Database;
import User.User;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    public static String regexValidation(String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Matcher matcher = regex.matcher(input);
        while (true) {
            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                matcher = regex.matcher(input);
            }
        }
        scanner.close();
        return input;

    }

    public static int validateInt(int range) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                if (input >= 0 && range >= input) {
                    scanner.close();
                    return input;
                } else {
                    System.out.println("Invalid input!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }

        }

    }

    public static List<User> getListUser() {
        List<User> listUsers = new ArrayList<>(Database.getINSTANCE().getUsers());
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(i + 1 + ": " + listUsers.get(i));
        }
        return listUsers;
    }
}
