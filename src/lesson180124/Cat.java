package lesson180124;

import java.io.Serializable;
import java.time.LocalDate;

public class Cat implements Serializable {
    String name;
    LocalDate dtr;

    public Cat(String name, LocalDate dtr) {
        this.name = name;
        this.dtr = dtr;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", dtr=" + dtr +
                '}';
    }
}
