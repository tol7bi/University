package Data;

import User.User;

import java.io.Serializable;
import java.util.*;
import User.*;
import app.Tools;

public class Admin extends User implements Serializable {



	public Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}

	@Override
	public void updateInfo() {

	}


	public void createUser() {
		System.out.println("Which user do you want to create?");
		Vector<String> choices = new Vector<String>(
				Arrays.asList("Student", "Graduate Student", "Researcher", "Employee", "Teacher", "Manager", "Tech Support Specialist", "Dean"));

		for (int i = 0; i < choices.size(); i++) {
			System.out.println(i+1 + ": " + choices.get(i));
		}

		System.out.println("Enter 0 to return back.");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		if(choice == 0) {
			return;
		}
		else if(choice>=1 && choice<=2) {
			StudentFactory studentFactory = new StudentFactory();
			studentFactory.getStudent(choice+1);
		}
		else if(choice == 3) {
			addResearcher();
		}
		else if(choice >= 4) {
			EmployeeFactory employeeFactory = new EmployeeFactory();
			employeeFactory.getEmployee(choice+1);
		}
	}

	private void seeAllUsers() {

		for (User element : Database.getINSTANCE().getUsers()) {
			System.out.println(element);
		}
	}

	public void updateUser() {
		List<User> listUsers = Tools.getListUser();
		System.out.println("Which user do you want to change? 0 for return back");

		int input = Tools.validateInt(listUsers.size());

		if(input == 0) {
			return;
		}

		listUsers.get(input-1).updateInfo();
	}


	public void removeUser() {
		List<User> listUsers = Tools.getListUser();

		System.out.println("Enter 0 to return back");

		int input = Tools.validateInt(listUsers.size());

		if(input == 0) {
			return;
		}

		System.out.println(listUsers.get(input-1) + " was deleted");

		listUsers.remove(input-1);


	}

	public void seeLogFiles() {
		System.out.println("Enter 0 to return back");
		System.out.println("Choose user to see logs:");

		Vector<User> users = Database.getInstance().getUsers();

		StaticMethods.printList(users);

		int choice = StaticMethods.validate(users.size());

		if(choice==0) {
			return;
		}

		User u = users.get(choice-1);

		Vector<Log> logs = Database.getInstance().seeLogs(u);

		if(logs==null) {
			System.out.println("No logs for this user.");
			return;
		}

		StaticMethods.printList(logs);
	}

	@Override
	public void viewMenu() {

		String[] options = new String[] {
				"Create new user", "See all users", "Update info of user", "Remove user", "See log files","View one news", "Exit"
		};

		while(true) {
			System.out.println();
			System.out.println("----Admin Menu----");
			StaticMethods.printList(List.of(options));
			int choice = StaticMethods.validate(options.length);

			if(choice == 1) {
				createUser();
			}

			else if(choice == 2) {
				seeAllUsers();
			}

			else if(choice == 3) {
				updateUser();
			}

			else if(choice == 4) {
				removeUser();
			}
			else if (choice == 5) {
				seeLogFiles();
			}
			else if (choice == 6) {
				viewOneNews();
			}
			else if(choice == 7) {
				try {
					Database.getInstance().saveDatabase();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		}

	}


	public String toString() {
		return "Admin " + getFullName();
	}

	@Override
	public int compareTo(Student o) {
		return 0;
	}


	@Override
	public void changeInfo() {

	}


}

