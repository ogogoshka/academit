import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {

        Person p1 = new Person("Alex", 11);
        Person p2 = new Person("Alex", 23);
        Person p3 = new Person("Max", 17);
        Person p4 = new Person("Mike", 33);
        Person p5 = new Person("John", 22);
        Person p6 = new Person("Julia", 11);

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);

        personList.stream()
                .map(person -> person.getName())
                .distinct()
                .forEach(System.out::println);

        String str = personList.stream()
                .map(person -> person.getName())
                .distinct()
                .collect(Collectors.joining(", ", "Имена: ", ""));
        System.out.println(str + "\n");

        System.out.println("Средний возраст людей < 18");
        personList.stream()
                .filter(person -> person.getAge() < 18)
                .mapToInt(person -> person.getAge())
                .average()
                .ifPresent(averageAge -> System.out.println(averageAge + "\n"));

        System.out.println("Имена в порядке убывания возраста");
        personList.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 45)
                .sorted((person1, person2) -> Integer.compare(person1.getAge(),
                        person2.getAge()))
                .map(person -> person.getName())
                .forEach(person -> System.out.println(person));

        //Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст

        Map<Integer, List<Person>> personsByAge = personList.stream().collect(Collectors.groupingBy(p -> p.getAge()));
        System.out.println(personsByAge.toString());


    }
}