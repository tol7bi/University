package User;

import java.util.Vector;
import Course.*;
import app.Tools;
public class Teacher extends Employee{

	private TeacherDegree degree;
    private Vector<Course> teachingCourses;
    private Vector<Double> rates;
	private Faculty faculty;
	public Teacher(String first_name, String last_name, String login, String password,
			TeacherDegree degree, Faculty faculty) {
		super(first_name, last_name, login, password);
		this.degree = degree;
		this.faculty = faculty;
		this.teachingCourses = new Vector<Course>();
        this.rates = new Vector<Double>();
	}
	
	public void manageCourse(Course course) {
		
	}

    public void viewCourses(){
        if(teachingCourses.isEmpty()){
            System.out.println("No courses");
            return;
        }
            else{for(Course c: teachingCourses){
            System.out.println(c);
        }
    }
    }

	public void viewStudents() {
        if(teachingCourses.isEmpty()){
            System.out.println("No courses");
            return;
        }
        for(int i = 0; i < teachingCourses.size();i++){
            Course course = teachingCourses.get(i);

        }
        System.out.println("Choose course, 0 to exit");


	}
	
    public void putMarks(Mark mark, Course course, Student student) {
        /*
        1)Match student
        2)

         */
    }
	
	public void checkAttendance() {
		
	}


	
	
	
}
