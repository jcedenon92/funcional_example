package com.jcedenon.streams;

import com.jcedenon.model.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class AppStream {

    private void m1getDevelopers(List<Employee> list){
        list.stream()
                .filter(e -> e.getJob().toLowerCase().contains("developer"))
                .forEach(System.out::println);
    }

    private void m2getInverse(List<Employee> list){
        Comparator<Employee> inverse = (x1,x2) -> x2.getIdEmployee() - x1.getIdEmployee();

        list.stream()
                .sorted(inverse)
                .forEach(System.out::println);
    }

    private void m3getAdults(List<Employee> list){
        Predicate<Employee> isAdult = e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears() >= 18;

        list.stream()
                .filter(isAdult)
                .forEach(System.out::println);
    }

    private void m4getOldestAdult(List<Employee> list){
        Predicate<Employee> isAdult = e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears() >= 18;
//        Predicate<Employee> salary = e -> e.getSalary() > 5000;

        list.stream()
//                .filter(salary)
                .sorted(Comparator.comparing(Employee::getBirthDate))
                .limit(1)
                .forEach(System.out::println);
    }

    private void m5getMaxMinSalary(List<Employee> list){
        double max = list.stream()
                        .mapToDouble(Employee::getSalary)
                        .max()
                        .orElse(0);

        double min = list.stream()
                        .mapToDouble(Employee::getSalary)
                        .min()
                        .orElse(0);

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    private void m6getAverage(List<Employee> list){
        double average = list.stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .orElse(0);

        System.out.println("Average: " + average);
    }

    private void m7getSummary(List<Employee> list){
        DoubleSummaryStatistics stats = list.stream()
                                                .mapToDouble(Employee::getSalary)
                                                .summaryStatistics();

//        System.out.println("Stats: \n" + stats);
        System.out.println("Count: " + stats.getCount());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());
    }

    private void m8getDistinct(List<Employee> list){
        list.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private void m9getCount(List<Employee> list){
        Predicate<Employee> isAdult = e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears() >= 18;


        long count = list.stream()
                .filter(isAdult)
                .count();

        System.out.println("Count: " + count);
    }

    private void m10skip(List<Employee> list){
        list.stream()
                .skip(3)
                .forEach(System.out::println);
    }

    private void m11getAnyYounger(List<Employee> list){
        boolean rpta = list.stream()
                                .anyMatch(e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears() < 18);

        System.out.println("Any younger: " + rpta);
    }

    private void m12getYoungest(List<Employee> list){
        list.stream()
                .filter(e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears() < 18)
                .sorted(Comparator.comparing(Employee::getBirthDate))
                .limit(1)
                .forEach(System.out::println);
    }

    private void m13map(List<Employee> list){
        list.stream()
                .map(e -> {
                    e.setSalary(e.getSalary() * 1.10);
                    return e;
                })
                .forEach(System.out::println);
    }

    private void m14flatMap(List<Employee> list){
        list.stream()
                .flatMap(e -> {
                    e.setSalary(e.getSalary() * 1.10);
                    return Stream.of("Name: " + e.getName(), "Salary: " + Math.round(e.getSalary()));
                })
                .forEach(System.out::println);
    }

    private void m15peek(List<Employee> list){
        list.stream()
                .filter(e -> e.getSalary() > 1000)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private void m16GroupBy(List<Employee> list){
        Map<String, List<Employee>> byDepartment = list.stream()
                                                            .collect(groupingBy(Employee::getDepartment));
        System.out.println("********TI*********");
        byDepartment.get("TI").forEach(System.out::println);
        System.out.println("****COMMERCIAL*****");
        byDepartment.get("Commercial").forEach(System.out::println);
    }

    private void m17toMapToSet(List<Employee> list){
        Map<Integer, String> map = list.stream()
                                        .collect(toMap(Employee::getIdEmployee, Employee::getName));
        System.out.println("Map: " + map);

        Set<Employee> set = new HashSet<>(list);
        System.out.println("Set: " + set);
    }

    public static void main(String[] args) {
        AppStream app = new AppStream();

        Employee e1 = new Employee(1, "Mito1", "Developer", LocalDate.of(1991,1,1), 1000.00, "TI");
        Employee e2 = new Employee(2, "Mito2", "QA", LocalDate.of(1993,2,1), 2000.00, "TI");
        Employee e3 = new Employee(3, "Mito3", "Architect", LocalDate.of(1995,3,1), 3000.00, "TI");
        Employee e4 = new Employee(4, "Mito4", "Cloud Engineer", LocalDate.of(1987,4,1), 4000.00, "TI");
        Employee e5 = new Employee(5, "Mito5", "DevOps Engineer", LocalDate.of(1956,1,1), 5000.00, "TI");
        Employee e6 = new Employee(6, "Mito6", "Scrum Master", LocalDate.of(2002,11,1), 4500.00, "TI");
        Employee e7 = new Employee(7, "Mito7", "Leader Project", LocalDate.of(1998,12,1), 10000.00, "TI");
        Employee e8 = new Employee(8, "Mito8", "Senior Developer", LocalDate.of(1996,7,1), 7000.00, "TI");
        Employee e9 = new Employee(9, "Mito9", "Junior Developer", LocalDate.of(2005,8,1), 500.00, "TI");
        Employee e10 = new Employee(10, "Mito10", "Mobile Developer", LocalDate.of(1975,9,1), 3000.00, "TI");
        Employee e11 = new Employee(11, "Mito11", "Salesman", LocalDate.of(1994,9,1), 2000.00, "Commercial");

        List<Employee> list = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);

//        app.m1getDevelopers(list);
//        app.m2getInverse(list);
//        app.m3getAdults(list);
//        app.m4getOldestAdult(list);
//        app.m5getMaxMinSalary(list);
//        app.m6getAverage(list);
//        app.m7getSummary(list);
//        app.m8getDistinct(list);
//        app.m9getCount(list);
//        app.m10skip(list);
//        app.m11getAnyYounger(list);
//        app.m12getYoungest(list);
//        app.m13map(list);
//        app.m14flatMap(list);
//        app.m15peek(list);
//        app.m16GroupBy(list);
        app.m17toMapToSet(list);
    }
}
