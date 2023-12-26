package Data;

import User.User;

import java.io.IOException;
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
		super.updateInfo();
	}


	public void createUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which user do you want to create?");
		String userChoice = "1-Student\n2-Graduate Student\n3-Researcher\n4-Employee\n5-Teacher\n6-Manager\n7-Tech Support\n8-Dean";
		System.out.println(userChoice);
		System.out.println("Enter 0 to return back.");

		int input = Tools.validateInt(8);


		if(input == 0) {
			return;
		}
		else if(input>=1 && input<=2) {
			UserFactory studentFactory = new UserFactory();
			studentFactory.getNewUser(input);

		}
		else if(input == 3) {
			//addResearcher();
		}
		else if(input >= 4) {
			UserFactory employeeFactory = new UserFactory();
			employeeFactory.getNewUser(input+1);
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



	@Override
	public void viewMenu() {


		String menu = "1-Create new user\n2-See all users\n3-Update user info\n4-Remove user\n5-See log files\n7-View news\n8-Exit";


		while(true) {
			System.out.println();
			System.out.println("Admin Menu");
			System.out.println(menu);
			int input  = Tools.validateInt(8);

			if(input == 1) {
				createUser();
			}

			else if(input == 2) {
				seeAllUsers();
			}

			else if(input == 3) {
				updateUser();
			}

			else if(input == 4) {
				removeUser();
			}
			else if (input == 5) {

			}
			else if (input == 6) {
				super.viewNews();
			}
			else if(input == 8) {
				try {
					Database.getINSTANCE().saveDb();
					System.out.println("Good Luck!");
				} catch (IOException e) {
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




}

