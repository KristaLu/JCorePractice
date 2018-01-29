package lesson180122;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample {
    public static void main(String[] args) throws Exception {

        File file = new File("out/serial.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            List<Employee> empList = new ArrayList<>();
            empList.add(new Employee("A", "2", 34, LocalDate.of(1984,1,15)));
            empList.add(new Employee("B", "1", 32, LocalDate.of(1986,1,15)));

            oos.writeObject(empList);
        }
        System.out.println("Saved");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            List<Employee> empList = (ArrayList<Employee>) ois.readObject();

            System.out.println(empList);
        }
    }
}

class Employee implements Serializable {
    private static long serialVersionUID = 1L;

    private String name;
    private String department;
    private int age;
    private transient LocalDate dtr;

    public Employee(String name, String department, int age, LocalDate dtr) {
        System.out.println("Create "+name);
        this.name = name;
        this.department = department;
        this.age = age;
        this.dtr = dtr;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", dtr=" + dtr +
                '}';
    }
}
