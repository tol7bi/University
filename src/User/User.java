package User;
import java.util.*;
import Data.*;
import app.Tools;

import java.io.Serializable;
public abstract class User implements Serializable{
	private static final long serialVersionUID = 2L;
	private int id = 1;
	private String email;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private Vector<Message> news = new Vector<Message>();
	//private Vector<ResearchJournal> journals;


	public User(){

	}

	public User(String login, String password, String firstName, String lastName) {
		if(Database.getINSTANCE().getUsers().isEmpty()) {
			this.id = 1;
		}
		else {
			this.id = Database.getINSTANCE().getUsers().size() + 1;
		}
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.news = new Vector<>();

		//this.journals = new Vector<>();
		this.email = login + "@kbtu.kz";
	}

	public void viewNews(){

	}
	public void updateInfo(){
		System.out.println("What do you want to change?\n1 - login\n2-password\n3-first name \n 4- last name");

		System.out.println("Enter 0 to return back");
		int choice = Tools.validateInt(4);
		Scanner in = new Scanner(System.in);

		if(choice == 0) {
			return;
		}
		else if(choice == 1) {
			System.out.println("Enter new username");
			String newLogin = in.nextLine();
			this.setLogin(newLogin);
		}
		else if(choice == 2) {
			System.out.println("Enter new password");
			String newPassword = in.nextLine();
			this.setPassword(newPassword);
		}
		else if(choice == 3) {
			String firstName = Tools.regexValidation( "[a-zA-Z]+");
			this.setFirstName(firstName);
		}
		else if(choice == 4) {
			String lastName = Tools.regexValidation("[a-zA-Z]+");
			this.setLastName(lastName);
		}
	}


	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String name){
		this.firstName = name;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return this.lastName;
	}

	public String getLogin(){
		return this.login;
	}
	public void setLogin(String login){
		this.login = login;
	}

	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public abstract void viewMenu();

	public String toString(){
		return "User: ID " + id + " " + getFullName() + " login " + getLogin();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return login.equals(user.login) && password.equals(user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, login, firstName, lastName);
	}


	public abstract int compareTo(Student o);
}

