import java.util.Arrays;

public class Student extends Person{
    private double GPA;
    private String[][] subjects;
    private String major;
    private String college;
    private int hours;

    public Student(String name, String id, String address, double GPA, String[][] subjects, String college, String major, int hours) {
        super(name, id, address);
        this.GPA = GPA;
        this.subjects = subjects;
        this.major = major;
        this.college = college;
        this.hours = hours;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setSubjects(String[][] subjects) {
        this.subjects = subjects;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    public String getCollege() {
        return college;
    }

    public String getMajor() {
        return major;
    }

    public int getHours() {
        return hours;
    }

    public String[][] getSubjects() {
        return subjects;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + getName() + '\'' +
                "Id='" + getId() + '\'' +
                "Address='" + getAddress() + '\'' +
                "GPA='" + GPA + '\'' +
                ", subjects='" + Arrays.deepToString(subjects) + '\'' +
                ", major='" + major + '\'' +
                ", college='" + college + '\'' +
                ", hours=" + hours +
                '}';
    }
}
