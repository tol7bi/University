package Course;

import java.sql.Time;
import java.util.Vector;

public class Lesson {
    private Time time;
    private Course course;
    private LessonType lessonType;
    private Vector<Mark> marksList;

    public Lesson() {
    	
    }
    
    public Lesson(Time time, Course course, LessonType lessonType) {
        this.time = time;
        this.course = course;
        this.lessonType = lessonType;
        this.marksList = new Vector<>();
    }

    public void addMark(Mark mark) {
        marksList.add(mark);
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public Course getCourse() {
        return course;
    }

    public Vector<Mark> getMarksList() {
        return marksList;
    }
}
