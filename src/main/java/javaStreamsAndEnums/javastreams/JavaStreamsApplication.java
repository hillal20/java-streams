package javaStreamsAndEnums.javastreams;

import javaStreamsAndEnums.javastreams.Enums.Gender;
import javaStreamsAndEnums.javastreams.Person.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class JavaStreamsApplication {


    private static List<Person> getAllPeople (){
        List<Person> people =  new ArrayList<>() ;
        people.add(new Person("Hill", 13, Gender.MALE));
        people.add(new Person("Bill", 10, Gender.MALE));
        people.add(new Person("Fill", 11, Gender.MALE));
        people.add(new Person("gill", 12, Gender.MALE));
        people.add(new Person("Lilli", 20, Gender.FEMALE));
        people.add(new Person("Cacti", 22, Gender.FEMALE));
        people.add(new Person("FiFFi", 21, Gender.FEMALE));
        people.add(new Person("YiLi", 37, Gender.FEMALE));
        return people;
    }


    public static void main(String[] args) {
        SpringApplication.run(JavaStreamsApplication.class, args);



      //  imperative approach
        List<Person> allPeople = getAllPeople();

        List<Person> females = new ArrayList<>();
        List<Person> males = new ArrayList<>();
        for(Person p : allPeople){
            if(p.getGender().equals(Gender.FEMALE)){
                females.add(p);
            }
            else{
                males.add(p);
            }
        }

//       females.forEach(System.out:: println);
//        males.forEach(System.out:: println);


        // declarative approach
        // 1- filter
        List<Person> filteredFemales = allPeople.stream()
                .filter(person ->
                person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

//        filteredFemales.forEach(System.out:: println);

       // 2- sort
        List<Person> sortedFemales = filteredFemales.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        sortedFemales.forEach(System.out:: println);

        // 3- allMatch
      boolean biggerThen23 = allPeople.stream()
              .allMatch(p -> p.getAge() < 23);
        System.out.println(" b>23 ===> "+ biggerThen23);

      // anyMatch
        boolean match20 = allPeople.stream()
                .anyMatch(p -> p.getAge() == 28 );
        System.out.println(" ==28  ===> "+ match20);

        // anyMatch
        boolean nonMatch29 = allPeople.stream()
                .noneMatch(p -> p.getAge() == 29 );
        System.out.println(" ==29  ===> "+ nonMatch29);

        // max
        Optional max = allPeople.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(" max   ===> "+ max);

        // Group
        // we need to create a map oh people grouped by gender
        Map<Gender, List<Person>> peopleGroupedByGender = allPeople.stream()
                .collect(Collectors.groupingBy(Person::getGender));


        peopleGroupedByGender.forEach(((gender, p) -> {
            System.out.println("gender ===> "+ gender);
            p.forEach(x -> System.out.println("x ===> "+ x));
        }));
        System.out.println(" == java streams is running ===");
    }



}
