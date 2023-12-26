package Course;

import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private int credits;

    public Course() {

    }
    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    public String getCourseName() {
        return name;
    }

    public String toString(){
        return name + " "  + credits;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return credits == course.credits && name.equals(course.name);
    }
}
