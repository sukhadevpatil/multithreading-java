public class Main {

    public static void main(String[] args) {

        Task task = new Task();
        task.start();

        MyTask myTask = new MyTask();
        Thread task2 = new Thread(myTask);
        task2.start();

        for(int i = 0; i <= 100; i++) {
            System.out.print("M");
        }

    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        doTask();
    }

    private void doTask() {
        for(int i = 0; i <= 100; i++) {
            System.out.print("R");
        }
    }
}

class Task extends Thread {
    @Override
    public void run() {
        doTask();
    }

    private void doTask() {
        for(int i = 0; i <= 100; i++) {
            System.out.print("T");
        }
    }
}