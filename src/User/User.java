package User;
import java.util.*;
import Data.*;
import java.io.Serializable;
public abstract class User implements Serializable{
	private int id = 1;
	private String email;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private Vector<String> messages;
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
		this.messages = new Vector<>();

		//this.journals = new Vector<>();
		this.email = login + "@kbtu.kz";
	}

	public void viewNews(){

	}
	public abstract void updateInfo();


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
		return id == user.id && login.equals(user.login) && password.equals(user.password) && firstName.equals(user.firstName) && lastName.equals(user.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, login, firstName, lastName);
	}


	public abstract int compareTo(Student o);
}

