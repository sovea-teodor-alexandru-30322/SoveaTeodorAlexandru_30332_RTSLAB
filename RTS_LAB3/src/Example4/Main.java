package Example4;

public class Main {
    public static void main(String[] args) {
        DivisorThread thread1 = new DivisorThread("Thread 1", 50001, Integer.MAX_VALUE);
        DivisorThread thread2 = new DivisorThread("Thread 2", 20001, 50000);

        thread1.run(); // Start the thread by calling run() directly
        thread2.run(); // Start the thread by calling run() directly

        // No need to call join() when using run() directly

        System.out.println("Sum of divisors: " + DivisorThread.getSumOfDivisors());
    }
}
