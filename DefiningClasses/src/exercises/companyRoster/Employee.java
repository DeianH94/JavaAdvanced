package exercises.companyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    public Employee(String name, double salary, String position) {
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setEmail("n/a");
        this.setAge(-1);
    }

    public Employee(String name, double salary, String position, String email) {
        this(name, salary, position);
        this.setEmail(email);
        this.setAge(-1);
    }

    public Employee(String name, double salary, String position, int age) {
        this(name, salary, position);
        this.setEmail("n/a");
        this.setAge(age);
    }

    public Employee(String name, double salary, String position, String email, int age) {
        this(name, salary, position);
        this.setEmail(email);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}
