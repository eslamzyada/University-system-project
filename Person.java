public class Person
{
    private String name;
    private String id;
    private String address;

    public Person(String name, String id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public String getId(){
        return id;
    }
    public String getAddress(){
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
