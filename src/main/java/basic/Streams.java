package basic;

import basic.forStreams.Department;
import basic.forStreams.Employee;
import basic.forStreams.Event;
import basic.forStreams.Position;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) throws IOException {
        List<Employee> emps = List.of(
                new Employee("Michael", "Smith", 243, 43, Position.CHEF),
                new Employee("Jane", "Smith", 523, 40, Position.MANAGER),
                new Employee("Jury", "Gagarin", 6423, 26, Position.MANAGER),
                new Employee("Jack", "London", 5543, 53, Position.WORKER),
                new Employee("Eric", "Jackson", 2534, 22, Position.WORKER),
                new Employee("Andrew", "Bosh", 3456, 44, Position.WORKER),
                new Employee("Joe", "Smith", 723, 30, Position.MANAGER),
                new Employee("Jack", "Gagarin", 7423, 35, Position.MANAGER),
                new Employee("Jane", "London", 7543, 42, Position.WORKER),
                new Employee("Mike", "Jackson", 7534, 31, Position.WORKER),
                new Employee("Jack", "Bosh", 7456, 54, Position.WORKER),
                new Employee("Mark", "Smith", 123, 41, Position.MANAGER),
                new Employee("Jane", "Gagarin", 1423, 28, Position.MANAGER),
                new Employee("Sam", "London", 1543, 52, Position.WORKER),
                new Employee("Jack", "Jackson", 1534, 27, Position.WORKER),
                new Employee("Eric", "Bosh", 1456, 32, Position.WORKER)
        );

        List<Department> deps = List.of(
                new Department(1, 0, "Head"),
                new Department(2, 1, "West"),
                new Department(3, 1, "East"),
                new Department(4, 2, "Germany"),
                new Department(5, 2, "France"),
                new Department(6, 3, "China"),
                new Department(7, 3, "Japan")
        );

//        Stream<String> lines = Files.lines(Paths.get("some.txt"));
//        Stream<Path> list = Files.list(Paths.get("./"));
//        Stream<Path> walk = Files.walk(Paths.get("./"), 3);

        //generate Streams
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        DoubleStream doubleStream = DoubleStream.of(1.2, 3.4);
        IntStream range = IntStream.range(10, 100); // 10 .. 99
        IntStream intStream1 = IntStream.rangeClosed(10, 100); // 10 .. 100

        int[] ints = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(ints);

        Stream<String> stringStream = Stream.of("1", "2", "3");
        Stream<? extends Serializable> stream1 = Stream.of(1, "2", "3");

        Stream<String> build = Stream.<String>builder()
                .add("Mike")
                .add("joe")
                .build();

        Stream<Employee> stream2 = emps.stream();
        Stream<Employee> employeeStream = emps.parallelStream();

        Stream<Event> generate = Stream.generate(() ->
                new Event(UUID.randomUUID(), LocalDateTime.now(), "")
        );

        Stream<Integer> iterate = Stream.iterate(1950, val -> val + 3);

        Stream<String> concat = Stream.concat(stringStream, build);


        //terminate Streams
        Stream<Employee> streamEmps = emps.stream();
        System.out.println("Total number of employees is: " + streamEmps.count());

        emps.stream().forEach(employee -> System.out.println("Age of each employee executed on stream is: " + employee.getAge()));
        emps.forEach(employee -> System.out.println("Age of each employee executed straight on collection is: " + employee.getAge()));

        emps.stream().forEachOrdered(employee -> System.out.println("Age of each employee with guarantee of order in all parallelized streams is: " + employee.getAge()));

        emps.stream().collect(Collectors.toList());
        System.out.println("Printing array elements got from stream in console:");
        Arrays.stream(emps.stream().toArray()).forEach(System.out::println);

        Map<Integer, String> collect = emps.stream().collect(Collectors.toMap(
                Employee::getId,
                emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName())
        ));
        System.out.println("Printing map elements got from stream in console:" + collect);
        System.out.println("Map contains value 'Jack': " + collect.containsValue("Jack"));
        System.out.println("Map contains value 'Bosh Jack': " + collect.containsValue("Bosh Jack"));
        System.out.println("Map contains key '7456': " + collect.containsKey(7456));


        IntStream intStreamForSum = IntStream.of(100, 200, 300, 400);
        System.out.println("Sum of elements in intStreamForSum is " + intStreamForSum.reduce((left, right) -> left + right).orElse(0));


        System.out.println(IntStream.of(100, 200, 300, 400).average());
        System.out.println(IntStream.of(100, 200, 300, 400).max());
        System.out.println(IntStream.of(100, 200, 300, 400).min());
        System.out.println(IntStream.of(100, 200, 300, 400).summaryStatistics());


        System.out.println(emps.stream().max(Comparator.comparingInt(Employee::getAge)));

        System.out.println(emps.stream().findAny());
        System.out.println(emps.stream().findFirst());

        System.out.println(emps.stream().noneMatch(employee -> employee.getAge() > 60)); // true
        System.out.println(emps.stream().anyMatch(employee -> employee.getPosition() == Position.CHEF)); // true
        System.out.println(emps.stream().allMatch(employee -> employee.getAge() > 18)); // true


        //transform not terminating the stream (lazy operations)
        LongStream longStream = IntStream.of(100, 200, 300, 400).mapToLong(Long::valueOf);
        IntStream.of(100, 200, 300, 400).mapToObj(value ->
                new Event(UUID.randomUUID(), LocalDateTime.of(value, 12, 1, 12, 0), "")
        );

        IntStream.of(100, 200, 300, 400, 100, 200).distinct().forEach(System.out::println); // 100, 200, 300, 400

        Stream<Employee> employeeNotChef = emps.stream().filter(employee -> employee.getPosition() != Position.CHEF);

        emps.stream()
                .skip(3)
                .limit(5)
                .forEach(System.out::println);

        emps.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .peek(emp -> emp.setAge(18))
                .map(emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName()))
                .forEach(System.out::println);

        emps.stream().takeWhile(employee -> employee.getAge() > 30).forEach(System.out::println);
        System.out.println();
        emps.stream().dropWhile(employee -> employee.getAge() > 30).forEach(System.out::println);

        System.out.println();

        IntStream.of(100, 200, 300, 400)
                .flatMap(value -> IntStream.of(value - 50, value))
                .forEach(System.out::println);

//    public void real() {
//        Stream<Employee> empl = emps.stream()
//                .filter(employee ->
//                        employee.getAge() <= 30 && employee.getPosition() != Position.WORKER
//                )
//                .sorted(Comparator.comparing(Employee::getLastName));
//
//        print(empl);
//
//        Stream<Employee> sorted = emps.stream()
//                .filter(employee -> employee.getAge() > 40)
//                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
//                .limit(4);
//
//        print(sorted);
//
//        IntSummaryStatistics statistics = emps.stream()
//                .mapToInt(Employee::getAge)
//                .summaryStatistics();
//
//        System.out.println(statistics);
//    }
//        Stream<Employee> empl = emps.stream()
//                .filter(employee ->
//                        employee.getAge() <= 30 && employee.getPosition() != Position.WORKER
//                )
//                .sorted(Comparator.comparing(Employee::getLastName));
//
//        print(empl);
//
//        Stream<Employee> sorted = emps.stream()
//                .filter(employee -> employee.getAge() > 40)
//                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
//                .limit(4);
//
//        print(sorted);
//
//        IntSummaryStatistics statistics = emps.stream()
//                .mapToInt(Employee::getAge)
//                .summaryStatistics();
//
//        System.out.println(statistics);

//        private void print (Stream < Employee > stream) {
//            stream
//                    .map(emp -> String.format(
//                            "%4d | %-15s %-10s age %s %s",
//                            emp.getId(),
//                            emp.getLastName(),
//                            emp.getFirstName(),
//                            emp.getAge(),
//                            emp.getPosition()
//                    ))
//                    .forEach(System.out::println);
//
//            System.out.println();
//        }
//
//        public Department reducer (Department parent, Department child){
//            if (child.getParent() == parent.getId()) {
//                parent.getChild().add(child);
//            } else {
//                parent.getChild().forEach(subParent -> reducer(subParent, child));
//            }
//
//            return parent;
        }
    }


