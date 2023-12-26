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
                scanner.nextLine();
                matcher = regex.matcher(input);
            }

        }

        return input;

    }

    public static int validateInt(int range) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while(true) {
            try {
                input = scanner.nextInt();
                if (0 <= input && input <= range) {
                    break;
                }
                else {
                    System.out.println("Out of range");
                }

            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.nextLine();
            }

        }
        return input;


    }

    public static List<User> getListUser() {
        List<User> listUsers = new ArrayList<>(Database.getINSTANCE().getUsers());
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(i + 1 + ": " + listUsers.get(i));
        }
        return listUsers;
    }
}
