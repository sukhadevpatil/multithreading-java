package io.section15;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Main1 {

    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(5);
        queue.add(10);
        queue.add(5);
        queue.add(1);
        queue.add(8);

        //By default it get sorted
        queue.forEach(System.out::println);

         PriorityBlockingQueue<Student> queue2 = new PriorityBlockingQueue<>(5, new StudentComparator());

         queue2.add(new Student("A", 8));
         queue2.add(new Student("X", 10));
         queue2.add(new Student("Y", 2));
         queue2.add(new Student("B", 1));

         queue2.forEach(System.out::println);

    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getRank() - o2.getRank();
    }
}

class Student {
    private  String name;
    private int rank;

    public Student(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("Name : %s, Rank : %d", getName(), getRank());
    }
}
