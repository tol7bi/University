package Data;
import java.util.*;
public class Research {
	private int pages;
	private int publishingYear;
	private Vector<Research> citations;
	
	public Research() {
		
	}
	
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}
	public Vector<Research> getCitations() {
		return citations;
	}
	public void setCitations(Vector<Research> citations) {
		this.citations = citations;
	}
}
