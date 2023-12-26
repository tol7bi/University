package User;
import Data.*;
import app.Tools;

import java.io.Serializable;
import java.util.*;
public class Employee extends User implements Serializable {
    private Vector<Message> employeeMessages = new Vector<Message>();
	public Employee(String first_name, String last_name, String login, String password) {
		super(first_name, last_name, login, password);
	}
	
    public void sendMessage(String title, String message, String recipient) {
        Employee receiver = null;
        for(User u: Database.getINSTANCE().getEmployees()){
            if(u.getFullName().equals(recipient)){
                receiver = (Employee) u;
                break;
            }
            System.out.println("Not found such user");
            return;
        }
        assert receiver != null;
        Message messageToSend = new Message(this, title, message, receiver);

        receiver.receiveMessage(messageToSend);


    }


    public void checkMessage() {
        for(Message m: employeeMessages){
            System.out.println("Sender - " + m.getAuthor().getFullName());
            System.out.println(m.getTitle() + "\n" + m.getText());
            System.out.println();
        }
    }

    public void receiveMessage(Message m) {
        employeeMessages.add(m);
    }

    public void addNews(String title, String text){
        Database.getINSTANCE().addNews(new Message(this, title,text));
        System.out.println("News Added");
    }


    @Override
    public void updateInfo() {
        super.updateInfo();
    }

    @Override
    public void viewMenu() {
        String menu = "1 - update info\2 - add news\n3 - send message\n4 - check messages\n5 - exit";


        while(true) {
            System.out.println();
            System.out.println("Employee Menu");
            System.out.println(menu);
            int input  = Tools.validateInt(8);

            if(input == 1) {
                updateInfo();
            }

            else if(input == 2) {
                updateInfo();
            }

            else if(input == 3) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Write a name of recipient");
                String recipientName = scanner.nextLine();
                System.out.println("Write a title");
                String title = scanner.nextLine();
                System.out.println("Write a text");
                String text = scanner.nextLine();

                sendMessage(title, text,recipientName);

            }

            else if(input == 4) {
                checkMessage();
            }
            else if (input == 5) {

            }

        }


    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
