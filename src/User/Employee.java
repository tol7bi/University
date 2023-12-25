package User;

public class Employee extends User{

	public Employee(String first_name, String last_name, String login, String password) {
		super(first_name, last_name, login, password);
	}
	
    public void sendMessage(String message, Employee recipient) {
        if (true) {
            System.out.println(getFullName() + " sent a message to " + recipient.getFullName() + ": " + message);
        } else {
            System.out.println("Cannot send a message. User is not currently logged in.");
        }
    }

    public void checkMessage() {
        if (true) {
            System.out.println(getFullName() + " is checking messages.");
        } else {
            System.out.println("Cannot check messages. User is not currently logged in.");
        }
    }

    public void receiveMessage(String message, User sender) {
        System.out.println("Manager " + getFullName() + " received a message from " + sender.getFullName() + ": " + message);
    }

    @Override
    public void updateInfo() {

    }

    @Override
    public void viewMenu() {

    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
