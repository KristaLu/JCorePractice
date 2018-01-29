package lesson180126;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExample {
    public static void main(String[] args) {
        Consumer<String> c = (String s) -> System.out.println(s);

        List<Cat> cats = Arrays.asList(
                new Cat("A", LocalDate.of(2005,3,3)),
                new Cat("B", LocalDate.of(2016,7,8)),
                new Cat("C", LocalDate.of(2015,12,17)),
                new Cat("D", LocalDate.of(2003,1,6)),
                new Cat("E", LocalDate.of(2014,5,21))
        );

        LocalDate now = LocalDate.now();
        List<Cat> some = new ArrayList<>();

        for (Cat cat : cats) {
            Period age = Period.between(cat.dtr,now);
            if (age.getYears()<=10)
                some.add(cat);
        }
        System.out.println(some);

        // с использованием java8:
        List<Cat> newCats = new ArrayList<>(cats);
        newCats.removeIf(cat -> Period.between(cat.dtr,now).getYears() > 10);
        newCats.forEach(cat -> System.out.println(cat));

        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7);
        List<String> str = convert(ints, a -> String.valueOf(a));
    }

    static List<String> convert(List<Integer> list, Function<Integer, String> func){
        List<String> res = new ArrayList<>(list.size());

        for (Integer i : list) {
            res.add(func.apply(i));
        }
        return res;
    }
}

class CatAgeTester{

    private int years;

    public CatAgeTester(int years) {
        this.years = years;
    }

    public boolean test(Cat cat){
        final LocalDate now = LocalDate.now();
        Period age = Period.between(cat.dtr,now);
        return age.getYears()<=years;
    }
}

class Cat implements Serializable {
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