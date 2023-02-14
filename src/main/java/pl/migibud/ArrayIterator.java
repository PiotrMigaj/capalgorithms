package pl.migibud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ArrayIterator {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();


        list.add("Piotr");
        list.add("Adam");
        list.add("Patryk");
        list.add(null);
        list.add("Marzena");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        boolean p = list.removeIf(s -> s == null ? false : s.startsWith("P"));
        System.out.println(list);


    }
}
