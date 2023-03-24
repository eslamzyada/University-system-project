import java.util.List;
public class Professor extends Employee{
    private List<Subject> subjects;
    private String department;
    private String degree;
    public Professor(String name, String id, String address, double salary, List<Subject> subjects, String department, String degree) {
        super(name, id, address, salary, 0, null);
        this.subjects = subjects;
        this.department = department;
        this.degree = degree;
    }
    @Override
    public void setName(String name){
        super.setName(name);
    }
    @Override
    public void setId(String id){
        super.setId(id);
    }
    @Override
    public void setAddress(String address){
        super.setAddress(address);
    }
    @Override
    public void setSalary(double salary){
        super.setSalary(salary);
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setSubjects(List<Subject> subjects){
        this.subjects = subjects;
    }
    public void setDegree(String degree){
        this.degree = degree;
    }
    public String getDepartment() {
        return department;
    }
    public String getDegree(){
        return degree;
    }
    public List<Subject> getSubjects(){
        return subjects;
    }
    @Override
    public String toString() {
        return "Professor{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", salary='" + getSalary() + '\'' +
                ", degree='" + degree + '\'' +
                ", subjects='" + subjects + '\'' +
                ", department='" + department +
                '}';
    }
}
