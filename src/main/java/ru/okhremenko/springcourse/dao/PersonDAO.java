package ru.okhremenko.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.okhremenko.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Bobius", 21, "bobius@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Dima", 28, "Dimas@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Vaka", 1500, "Vaka@ya.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Toma", 33, "Toma@gmail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id) {
        for (Person person : people) {
            if (person.getId() == id) return person;
        }
        return null;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
