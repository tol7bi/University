package User;

import java.util.Vector;

public class Organization {
	private String organizationName;
	Vector<Student> members;
	
	public Organization(String organizationName) {
		this.organizationName = organizationName;
	}

	@Override
	public String toString() {
		return "Organization [organizationName=" + organizationName + ", members=" + members + "]";
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public Vector<Student> getMembers() {
		return members;
	}

    public void addStudent(Student student) {
        members.add(student);
        student.joinOrganization(this);
        System.out.println(student.getFullName() + " has joined " + organizationName);
    }
    
    
    public void deleteStudent(Student student) {
        if (members.contains(student)) {
            members.remove(student);
            student.leaveOrganization(this);
            System.out.println(student.getFullName() + " has been removed from " + organizationName);
        } else {
            System.out.println(student.getFullName() + " is not a member of " + organizationName);
        }
    }
    
    public void displayMembers() {
        System.out.println("Members of " + organizationName + ":");
        for (Student member : members) {
            System.out.println("- " + member.getFullName());
        }
    }
    
    public void countMembers() {
    	System.out.println(members.size());
    }
    
    
	
	
}
