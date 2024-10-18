package org.simplemedium;

import java.util.Set;
import java.util.TreeSet;

/**
 * 22. Create a custom class like Employee/Person with 2 to 3 fields and create the TreeSet and store two objects and display the size of treeset
 */
public class TreeSetClass {
    public static void main(String[] args) {
        Set<Person> personSet = new TreeSet<Person>();
        TreeSetClass selfObj = new TreeSetClass();
        personSet.add(selfObj.new Person(1,"Minesh", 41));
        personSet.add(selfObj.new Person(2, "XYZ", 33));
        personSet.add(selfObj.new Person(3, "PQE", 36));
        System.out.println(personSet.size());

        for(Person p : personSet) {
            System.out.println(p);
        }
    }
    public class Person implements Comparable<Person> {

        private int id;
        private String name;
        private int age;


        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.id, o.id);
        }

        @Override
        public String toString() {
            return "Person[id="+id+", name ="+name+", age="+age+"]";
        }
    }


}
