package mainpkg;

public class RegisteredCourse {
    private int Courseid, studentId,  year,  section;
    private String semester ;

    public RegisteredCourse() {
    }

    public RegisteredCourse(int Courseid, int studentId, String semester, int year, int section) {
        this.Courseid = Courseid;
        this.studentId = studentId;
        this.year = year;
        this.section = section;
        this.semester = semester;
    }

//    RegisteredCourse(String toString) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    int getStudID() { return studentId;}

    @Override
    public String toString() {
        return ("Courseid: "+Courseid+", studentId: "+studentId+", Year: "+year+", semester: "+semester+", section: "+section);
    }
    
    
}
