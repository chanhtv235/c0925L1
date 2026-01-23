package entity;

public class Student extends Person{
    private String address;

    public Student() {
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()+","+this.getName()+","+this.getAddress();
    }

    public Student(int id, String name, String address) {
        super(id, name);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString()+
                ", address= " + address + '\'' +
                '}';
    }
}
