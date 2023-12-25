package Data;
import User.*;
public class Message extends Data{
	private String receiver;
	
	public Message() {
        super();
    }

    public Message(User author) {
        super(author);
    }

    public Message(User author, String title) {
        super(author, title);
    }

    public Message(User author, String title, String text) {
        super(author, title, text);
    }

    public Message(User author, String title, String text, String receiver) {
        super(author, title, text);
        this.receiver = receiver;
    }

    public void setReceiver(String receiver) {
    	this.receiver = receiver;
    }
    
    public String getReceiver() {
    	return this.receiver;
    }
    @Override
    public String toString() {
        return "Message{" +
                "author='" + getAuthor() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", text='" + getText() + '\'' +
                ", receiver='" + getReceiver() + '\'' +
                '}';
    }
}
