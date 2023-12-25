package User;

public class GraduateStudent extends Student{
    Degree degree;
    public GraduateStudent(String login, String password,String firstName, String lastName, Faculty faculty, Degree degree){
        super(login, password,firstName,lastName, faculty);
        this.degree = degree;
    }

    @Override
    public void updateInfo() {
        super.updateInfo();
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
