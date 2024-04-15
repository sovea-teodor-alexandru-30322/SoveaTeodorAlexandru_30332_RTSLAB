package Ex5;

public class Main {
    public static void main(String[] args) {

        int[] t1 = {7, 2, 3};
        int[] t2 = {3, 5};
        int[] t3 = {4, 6};

        Integer lock1 = new Integer(1);
        Integer lock2 = new Integer(1);

        // test comment to see that repo is ok
        ExecutionThread1 thread1 = new ExecutionThread1(lock1, lock2, t1);
        ExecutionThread2 thread2 = new ExecutionThread2(lock1, thread1, t2);
        ExecutionThread2 thread3 = new ExecutionThread2(lock2, thread1, t3);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
