package models;

public class Employee {
    public Integer id;
    public String name;
    public String city;
    public Double salary;
    
    public Employee(String name, String city, double salary) {
        this.name = name;
        this.city = city;
        this.salary = salary;
    }

}
