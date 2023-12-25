package Data;
import User.*;
import java.util.*;
public class Data implements Comparable<Data> {
	private User author;
	private String title;
	private String text;
	
	public Data() {
		
	}
	public Data(User author) {
		this.author = author;
	}
	public Data(User author, String title) {
		this(author);
		this.title = title;
	}
	public Data(User author, String title, String text) {
		this(author,title);
		this.text = text;
	}
	

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Data other = (Data) obj;
        return Objects.equals(author, other.author) &&
               Objects.equals(title, other.title) &&
               Objects.equals(text, other.text);
    }
	
	@Override
	public int compareTo(Data other) {
        int authorComparison = this.author.getFullName().compareTo(other.getAuthor().getFullName());
        if (authorComparison != 0) {
            return authorComparison;
        }
        
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        }
        
        return this.text.compareTo(other.text);
    }
	@Override
	public int hashCode() {
        return Objects.hash(author, title, text);
    }
	
	public String toString() {
		return  "Author='" + getAuthor() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", text='" + getText() + '\'';
	}
}
