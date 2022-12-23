package com.java.program;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDB {

    public static void main(String[] args) {
        List<Employee> employeeList = getEmployeeList();

        // method reference this will be passed as Functional Interface implementation
                //Employee::getID;
        // Constructor Reference
                //Employee::new;
        //employeeList.forEach(System.out::println);

        // Stream
        employeeList.stream().collect(Collectors.toMap(Employee::getId,Employee::getName));

        // Filter
        //employeeList.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList()).forEach(System.out::println);
        //employeeList.stream().filter(e -> e.getAge() > 30 && e.getGender().equalsIgnoreCase("FeMale")).collect(Collectors.toList()).forEach(System.out::println);
        //employeeList.stream().filter(e -> e.getAge() > 30 && e.getGender().equalsIgnoreCase("FeMale")).
        //        map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);

        // Group by
        Map<String, Long> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        Set<String> keys = collect.keySet();
        keys.forEach(key-> System.out.println(key+" "+collect.get(key)));

        List l = new ArrayList();
        l.add("Pratik");
        l.add("Yuvraj");
        l.add("Rakesh");
        l.add("Pratik");
        l.add("Yuvraj");


        // duplicate elements
        Object collect1 = l.stream().filter(company -> Collections.frequency(l, company) > 1)
                .collect(Collectors.toSet());

        System.out.println(collect1);

        // ParallelStream

        // FlatMap

        List<String> l1 = new ArrayList<>();
        l1.add("Pratik");
        l1.add("Yuvraj");
        l1.add("Rakesh");
        l1.add("Pratik");
        l1.add("Yuvraj");

        List<List<String>> al = new ArrayList<>();
        al.add(l);
        al.add(l1);

        al.stream().flatMap(al1 -> al1.stream().map(String::toUpperCase)).collect(Collectors.toList()).forEach(System.out::println);

        // Comparator

        Comparator<Employee> comp = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // if Int the -
                // If String compareTO
                // If double
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(employeeList,comp);
        employeeList.forEach(s-> System.out.println(s.getAge()+" "+s.getName()));
        // Java 8

        Comparator<Employee> emp = Comparator.comparing(Employee::getAge).thenComparing(Employee::getName);
        Collections.sort(employeeList,emp);
        employeeList.forEach(s-> System.out.println(s.getAge()+" "+s.getName()));

        //If Employee name are null in that case all null employee printed first then sorting done based on non nullable name

        Comparator<Employee> empNameComparator = Comparator.comparing(Employee::getName, Comparator.nullsFirst(String::compareTo));
        Collections.sort(employeeList, empNameComparator);

        //If Salary is double then use comparingDouble same if Int comparingInt

        Comparator<Employee> empNameComparator1 = Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getId);
        Collections.sort(employeeList, empNameComparator1);
        employeeList.forEach(System.out::println);

        //Reverse
        Comparator<Employee> comparing1 = Comparator.comparing(Employee::getAge,Comparator.reverseOrder());
        Collections.sort(employeeList,comparing1);




    }

    public static List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        return employeeList;
    }
}
