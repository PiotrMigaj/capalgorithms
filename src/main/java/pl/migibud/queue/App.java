package pl.migibud.queue;

import java.util.ArrayList;
import java.util.List;

class App {
    public static void main(String[] args) {
        Queue<String> queue = new QueueImpl<>();
        queue.add("Piotr");
        queue.add("Anna");
        queue.add("Marcin");
        queue.add("Wojtek");
        queue.traverse();
        System.out.println("*************");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        List<String> list = new ArrayList<>();

    }
}
