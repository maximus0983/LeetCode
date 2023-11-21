package leet;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class mainmethod {
    public static void main(String[] args) {
//        Map<Long, String> employees = Map.of(
//                123L, "Alice",
//                124L, "Bob",
//                125L, "Charlie"
//        );
//        Long any = employees.entrySet().stream()
//                .filter(map -> "Charlie".equals(map.getValue()))
//                .map(Map.Entry::getKey)
//                .findAny().orElse(null);
//        List<Employee> employees = Arrays.asList(
//                new Employee("Alice", "HR"),
//                new Employee("Bob", "HR"),
//                new Employee("Charlie", "Sales"),
//                new Employee("Eve", "Sales")
//        );
//
//        employees.stream()
//                .filter(employee -> "HR".equals(employee.getDepartment()))
//                .count();
//        Integer int1 = 10;
//        Integer int2 = 10;
//        Integer int3 = 1000;
//        Integer int4 = 1000;
//        Integer int5 = 127;
//        Integer int6 = 127;
//        System.err.println(int1 == int2);
//        System.err.println(int3 == int4);
//        System.err.println(int5 == int6);
        int sum = IntStream.range(1, 101).sum();
        Optional<Integer> reduce = Stream.iterate(1, x -> x + 1).limit(100).reduce((s, x) -> s + x);
        Integer collect = IntStream.range(1, 101).boxed().collect(Collectors.summingInt(r -> r.intValue()));
        System.out.println(sum);
        System.out.println(reduce.get());
        System.out.println(collect);
    }

}

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //getters, setters
}


