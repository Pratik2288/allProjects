package com.java.program;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTest {
    public static void main(String[] args) {

            List<String> list = new ArrayList<>();
            list.add("Hello");
            list.add("Hello");
            list.add("Yuvraj");
            list.add("Kumar");

            List<String> stringList = list.stream().filter(x -> Collections.frequency(list, x) > 1).collect(Collectors.toList());
            stringList.forEach(System.out::println);

            EmployeeTest emp = new EmployeeTest();
            List<Employee> empList =emp.getEmployeeList();

            empList.forEach(s -> System.out.println(s.getName()));
            //empList.forEach(System.out::println);

            List<String> empNames =empList.stream().map(Employee::getName).collect(Collectors.toList());
            //empNames.forEach(System.out::println);

            // Map

            Map<Integer,String> empss =empList.stream().collect(Collectors.toMap(emp1 -> emp1.getId() , emp2 ->emp2.getName()));

            Map<Integer,String> emps =empList.stream().collect(Collectors.toMap(Employee::getId,Employee::getName));

            Map<Integer,String> emps1 =empList.stream().collect(Collectors.toMap(Employee::getId,Employee::getName,(o1,o2)->o1,LinkedHashMap::new));

            Set<Integer> keys =emps.keySet();
     //       keys.forEach(s->System.out.println(emps.get(s)));
            Set<Integer> keys1 =emps1.keySet();
//            keys1.forEach(s->System.out.println(emps1.get(s)));

//        Comparator<Employee> comparing = Comparator.comparing(Employee::getAge,Comparator.reverseOrder()).thenComparing(Employee::getName);
//        Collections.sort(empList,comparing);
        Comparator<Employee> empNameComparator = Comparator.comparing(Employee::getName, Comparator.nullsFirst(String::compareTo));
        Collections.sort(empList, empNameComparator);
        empList.forEach(System.out::println);

        Comparator<Employee> empNameComparator1 = Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getId);
        Collections.sort(empList, empNameComparator);
        empList.forEach(System.out::println);


        Map<String, Long> noOfEmployeesInEachDepartment=empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                    Collectors.counting()));
            //System.out.println(noOfEmployeesInEachDepartment);

            Map<String, Long> noOfMaleAndFemaleEmployees=   empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
            System.out.println(noOfMaleAndFemaleEmployees);

            Optional<Employee> optional =empList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));

            empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

            Map<Integer, Long> values = empList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
            Set<Integer> integers = values.keySet();
            integers.forEach(v1 -> System.out.println("Key "+v1+" "+values.get(v1)));

            Optional<Employee> optional1 =empList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
            Employee em =optional1.get();
            System.out.println(em);

        Optional<Employee> optional2 =empList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getSalary)));
        Employee em2 =optional2.get();
        System.out.println(em2);

    }
    public List<Employee> getEmployeeList(){
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
