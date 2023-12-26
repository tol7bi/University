package User;

import java.util.Scanner;

import Data.Database;
import app.Tools;


public class UserFactory {

    public Student getNewUser(int choice) {
        if(choice == 1) {
            return addStudent();
        }
        if(choice == 2) {
            return addGraduateStudent();
        }
        return null;
    }

    public Student addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter Name:");
        String FirstName = Tools.regexValidation("[a-zA-Z]+");
        System.out.println("Enter Last name:");
        String lastName = Tools.regexValidation("[a-zA-Z]+");
        System.out.println("Choose faculty:");
        Faculty[] faculties = Faculty.values();
        for(int i = 0; i < faculties.length; i++) {
            System.out.println(i+1 + ": " + faculties[i]);
        }
        Faculty faculty = faculties[Tools.validateInt(faculties.length) - 1];
        Student s = new Student(username, password, FirstName, lastName, faculty);
        Database.getINSTANCE().addStudent(s);
        System.out.println("Student added " + s);
        return s;

    }

    public Student addGraduateStudent() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = in.nextLine();

        System.out.println("Enter password:");
        String password = in.nextLine();

        System.out.println("Enter Name:");
        String FirstName = Tools.regexValidation("[a-zA-Z]+");

        System.out.println("Enter Last name:");
        String lastName = Tools.regexValidation("[a-zA-Z]+");
        System.out.println("Choose faculty:");


        Faculty[] faculties = Faculty.values();
        for(int i = 0; i < faculties.length; i++){
            System.out.println(i + 1 +  " " + faculties[i]);
        }
        Faculty faculty = faculties[Tools.validateInt(faculties.length) - 1];


        Degree[] degrees = Degree.values();
        for(int i = 0; i < degrees.length; i++){
            System.out.println(i + 1 +  " " + degrees[i]);
        }
        Degree degree = degrees[Tools.validateInt(degrees.length) - 1];

        Student newGraduateStudent = new GraduateStudent(username, password, FirstName, lastName, faculty, degree);

        Database.getINSTANCE().addStudent(newGraduateStudent);
        System.out.println("Student added " + newGraduateStudent);


        return newGraduateStudent;

    }
}
