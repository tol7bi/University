package User;
import app.Tools;
import Course.*;
import java.io.Serializable;
import java.util.*;

public class Student extends User implements Serializable, Comparable<Student>{

	// fields of Student
	private String fullName;
	private Faculty faculty;
	private double gpa;
	private Organization organization;
	private Vector<Course> courses = new Vector<Course>();
	private HashMap<Course, Mark> transcript = new HashMap<>();


	public Student(){

	}



	public Student(String username, String password, String firstName, String lastName, Faculty faculty) {
		super(username,password,firstName,lastName);
		this.faculty = faculty;
		this.organization = null;
	}

	@Override
	public void updateInfo() {
		System.out.println("What do you want to change?");


		System.out.println("What do you want to change?");
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

	@Override
	public void viewMenu() {

	}

	public Faculty getFaculty() {
		return faculty;
	}


	public double getGpa() {
		calculateGpa();
		return gpa;
	}
	public void calculateGpa() {
		int totalCredits = 0;
		int tmp = 0;
		for (Course course : transcript.keySet()) {
			Mark mark = transcript.get(course);
			tmp += course.getCredits() * mark.getNumericMark();
			totalCredits += course.getCredits();

		}
		gpa = tmp/totalCredits;
	}

	public Organization getOrganization() {
		return organization;
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	//register for some course
	public void registerCourse(Course course) {
		courses.add(course);
		System.out.println(getFullName() + " has registered for course : " +  course.getCourseName());
	}

	public HashMap<Course, Mark> getTranscript() {
		return transcript;
	}

	


	public void viewMarks() {
		for (Course course : transcript.keySet()) {
			Mark mark = transcript.get(course);
			System.out.println("Course: " + course.getCourseName() + ", Mark: " + mark.getMarkPercentage() + " - " + mark.getAlphabeticalMark());
		}
		System.out.println("Total gpa - " + getGpa());
		}

	


    //drop some course
    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            System.out.println(getFullName() + " has dropped " + course.getCourseName());
        } else {
            System.out.println(getFullName() + " is not enrolled in " + course.getCourseName());
        }
    }

	@Override
	public String toString() {
		return "Student " + getFullName() + " gpa - " + gpa ;
	}

	//join some organization
    public void joinOrganization(Organization organization) {
        this.organization = organization;
    }
    
    // leave organization if you contain in 
    public void leaveOrganization(Organization organization) {
        if (organization.getMembers().contains(this)) {
            organization.getMembers().remove(this);
            System.out.println(getFullName() + " has left " + organization.getOrganizationName());
        } else {
            System.out.println(getFullName() + " is not a member of " + organization.getOrganizationName());
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(getFullName(), faculty, gpa, organization);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return faculty == other.faculty && Double.doubleToLongBits(gpa) == Double.doubleToLongBits(other.gpa)
				&& Objects.equals(organization, other.organization);
	}


	@Override
	public int compareTo(Student o) {
		return 0;
	}
}
