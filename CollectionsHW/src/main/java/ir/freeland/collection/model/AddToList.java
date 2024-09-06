package ir.freeland.collection.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class AddToList {
    Person iman = new Person("imans", "dev", 123, new Address("rom", "itly", "good"));
    Person hasan = new Person("hasan", "hasani", 13, new Address("rom", "itly", "bad"));
    Person moji = new Person("mojtaba", "mojtabaee", 12, new Address("rom", "itly", "ugly"));
    Person ali = new Person("ali", "rabie", 12, new Address("tehran", "iran", "mirdamad"));
    List<Person> persons = new ArrayList<>();

    public List<Person> addPerson() {
        persons.add(iman);
        persons.add(hasan);
        persons.add(moji);
        persons.add(ali);
        return persons;
    }

    public void printPerson(List<Person> p) {
        p.forEach(System.out::println);
    }

    public List<Person> removePerson() {
        addPerson();
        Iterator<Person> personIterator = persons.iterator();
        while (personIterator.hasNext()) {
            Person p = personIterator.next();
            if (p.getFname().contains("ali")) {
                personIterator.remove();
            }
        }
        return persons;
    }

    public List<Person> sortPersonsByStreetLength() {
        addPerson();
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                String street1 = p1.getAddress().getStreet();
                String street2 = p2.getAddress().getStreet();
                return street1.compareTo(street2);
            }
        });
        return persons;
    }
}
