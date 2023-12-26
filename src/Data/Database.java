package Data;
import java.util.*;
import User.*;
import java.io.*;
public class Database implements Serializable{
	private static final long serialVersionUID = 1L;
	private static Database INSTANCE;
	private HashSet<Student> Students = new HashSet<Student>();
	private HashSet<Employee> Employees = new HashSet<Employee>();
	private HashSet<Message> Messages = new HashSet<Message>();
	private Vector<Message> News = new Vector<Message>();
	private static Vector<User> Users = new Vector<User>();
	private static HashSet<Admin> Admins = new HashSet<Admin>();
	private HashSet<Research> Researches = new HashSet<Research>();


	static{
		if(new File("university_db.ser").exists()) {
			try {
				INSTANCE = loadDB();
				System.out.println("Loaded");
			}
			catch(Exception serializationError) {
				serializationError.printStackTrace();
			}
		}
		else {
			INSTANCE = new Database();
			Admin defaultAdmin = new Admin("admin", "admin", "Name", "Surname");
			Admins.add(defaultAdmin);
			Users.add(defaultAdmin);
		}
	}
	private Database() {

	}


	public void login(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		User authenticatedUser = null;

		authentication:
		while(true) {
			try {
				for(User u : INSTANCE.getUsers()){
					System.out.println(u);
				}
				System.out.println("Login: ");
				String login = reader.readLine();

				System.out.println("Password: ");
				String password = reader.readLine();

				for(User u : INSTANCE.getUsers()) {
					if(login.equals(u.getLogin()) && password.equals(u.getPassword())) {
						authenticatedUser = u;
						break authentication;
					}
				}

				System.out.println("Invalid input");

			}
			catch (IOException e) {
				e.printStackTrace();

			}

		}

		authenticatedUser.viewMenu();
	}


	public static Database getINSTANCE(){
		return INSTANCE;
	}

	private static Database loadDB() throws IOException, ClassNotFoundException {
		try (ObjectInputStream loadedDb = new ObjectInputStream(new FileInputStream("university_db.ser"))) {
			Database tmp = (Database) loadedDb.readObject();
			System.out.println(tmp);
			return tmp;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		return null;
	}


	public void saveDb() throws IOException {

		ObjectOutputStream outputDb = new ObjectOutputStream(new FileOutputStream("university_db.ser"));
		outputDb.writeObject(this.getINSTANCE());
		outputDb.close();
		System.out.println("Data saved");

	}

	public void addAdmin(Admin a){
		Admins.add(a);
		Users.add(a);
	}
	
	public void addStudent(Student student) {
		Students.add(student);
		Users.add(student);
		
	}
	public HashSet<Student> getStudents() {
		return Students;
	}
	public void setStudents(HashSet<Student> students) {
		Students = students;
	}
	public void addEmployee(Employee employee) {
		Employees.add(employee);
		Users.add(employee);
		
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
	public Vector<User> getUsers(){
		return this.Users;
	}

	public Vector<Message> getNews() {
		return News;
	}

	public void setNews(Vector<Message> news) {
		News = news;
	}
	public void addNews(Message m) {
		News.add(m);
	}
	public String toString(){
		return this.Users.size() + " ";
	}

}
