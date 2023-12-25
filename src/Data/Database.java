package Data;
import java.util.*;
import User.*;
import java.io.*;
public class Database implements Serializable{
	private static Database INSTANCE;
	private HashSet<Student> Students = new HashSet<Student>();
	private HashSet<Employee> Employees = new HashSet<Employee>();
	private HashSet<Message> Messages = new HashSet<Message>();
	private HashSet<User> Users = new HashSet<User>();
	private HashSet<Admin> Admins = new HashSet<Admin>();
	private HashSet<Research> Researches = new HashSet<Research>();

	// Load or create database
	static{
		if(new File("university_db.ser").exists()) {
			try {
				INSTANCE = loadDB();
			}
			catch(Exception serializationError) {
				serializationError.printStackTrace();
			}
		}
		else {
			INSTANCE = new Database();
		}
	}


	private Database() {
	}
	public static Database getINSTANCE(){
		return INSTANCE;
	}

	private static Database loadDB() throws IOException, ClassNotFoundException {
		ObjectInputStream dbObject = new ObjectInputStream(new FileInputStream("university_db.ser"));
		return (Database) dbObject.readObject();
	}

	public void saveDatabase() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database.ser"));
		oos.writeObject(INSTANCE);
		oos.close();
	}

	private void initializeDefaultAdmin() {
		Admin defaultAdmin = new Admin("admin", "admin", "AdminName", "AdminSurname");
		addAdmin(defaultAdmin);
	}

	public void addAdmin(Admin a){
		Admins.add(a);
		Users.add(a);
	}
	
	public void addStudent(Student student) {
		Students.add(student);
		
	}
	public HashSet<Student> getStudents() {
		return Students;
	}
	public void setStudents(HashSet<Student> students) {
		Students = students;
	}
	public void addEmployee(Employee employee) {
		Employees.add(employee);
		
	}
	public HashSet <Employee> getEmployees() {
		return Employees;
	}
	public void setEmployees(HashSet <Employee> employees) {
		Employees = employees;
	}
	public void addMessage(Message m) {
		Messages.add(m);
	}
	public HashSet<Message> getMessages() {
		return Messages;
	}
	public void setMessages(HashSet<Message> messages) {
		Messages = messages;
	}
	public void addResearch(Research r) {
		Researches.add(r);
	}
	public HashSet<Research> getResearches() {
		return Researches;
	}
	public void setResearches(HashSet<Research> researches) {
		Researches = researches;
	}
	public HashSet<User> getUsers(){
		return this.Users;
	}
	
}
