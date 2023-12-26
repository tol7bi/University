package Course;

public class Mark {
    private Course course;
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private double markPercentage;


    public Mark(Course course, double mark) {
        this.course = course;
        this.markPercentage = mark;
    }

    public double getNumericMark() {

        if (markPercentage >= 90 && markPercentage <= 100) {
            return 4.0;
        } else if (markPercentage >= 80 && markPercentage <= 89) {
            return 3.0;
        } else if (markPercentage >= 70 && markPercentage <= 79) {
            return 2.0;
        } else if (markPercentage >= 60 && markPercentage <= 69) {
            return 1.0;
        } else {
            return 0;
        }
    }

    public double getMarkPercentage(){
        return markPercentage;
    }


    public char getAlphabeticalMark(){

        if (markPercentage >= 90 && markPercentage <= 100) {
            return 'A';
        } else if (markPercentage >= 80 && markPercentage <= 89) {
            return 'B';
        } else if (markPercentage >= 70 && markPercentage <= 79) {
            return 'C';
        } else if (markPercentage >= 60 && markPercentage <= 69) {
            return 'D';
        } else {
            return 'F';
        }
    }


    public Course getCourse() {
        return course;
    }
}
