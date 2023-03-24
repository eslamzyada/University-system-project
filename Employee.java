public class Employee extends Person{
    private int workHours;
    private double salary;
    private String workShift;

    public Employee(String name, String id, String address, double salary, int workHours, String workShift) {
        super(name, id, address);
        this.workHours = workHours;
        this.salary = salary;
        this.workShift = workShift;
    }

    public void setWorkHours(int workHours){
        this.workHours = workHours;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setWorkShift(String workShift){
        this.workShift = workShift;
    }
    @Override
    public void setName(String name) {
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
    public int getWorkHours(){
        return workHours;
    }
    public double getSalary(){
        return salary;
    }
    public String getWorkShift(){
        return workShift;
    }

    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public String getId(){
        return super.getId();
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "workHours=" + workHours +
                ", salary=" + salary +
                ", workShift='" + workShift + '\'' +
                '}';
    }
}
