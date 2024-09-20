package BinarySearchAndLinearSearch;

import java.util.ArrayList;
import java.util.List;

class BinaryLinearSearchExample {
    public static void binarySearch(List<Person> personList, int first, int last, int key) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (personList.get(mid).getAge() < key) {
                first = mid + 1;
            } else if (personList.get(mid).getAge() == key) {
                System.out.println("Element is found at index: " + mid + "and person details is : " + personList.get(mid).toString());
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Element is not found!");
        }
    }

    public static void linearSearch(List<Person> personList, int key) {
        for (int i = 0; i < personList.size(); i++) {
            Person current = personList.get(i);
            if (current.getAge() == key) {
                System.out.println("Element is found at index: " + i + "and person details is : " + current.toString());
                break;
            }
        }
    }

    private static List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setName("person" + i + 1);
            person.setAge(10 + i);
            personList.add(person);
        }
        return personList;
    }

    public static void main(String args[]) {
        List<Person> personList = getPersonList();
        int key = 12;
        int last = personList.size() - 1;
        binarySearch(personList, 0, last, key);

        System.out.println("Now going to find element using linearSearch ::: ");
        linearSearch(personList, key);
    }
}
