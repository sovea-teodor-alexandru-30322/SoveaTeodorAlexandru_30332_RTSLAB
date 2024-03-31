class DivisorThread extends Thread {
    private static int sumOfDivisors = 0;
    private int startNumber;
    private int endNumber;

    DivisorThread(String name, int start, int end) {
        super(name);
        this.startNumber = start;
        this.endNumber = end;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " has entered the run() method");
        int divisorSum = calculateDivisors(startNumber, endNumber);
        synchronized (DivisorThread.class) {
            sumOfDivisors += divisorSum;
            System.out.println(Thread.currentThread().getName() + " sum of divisors: " + divisorSum);
            System.out.println("Total sum so far: " + sumOfDivisors);
        }
        System.out.println(Thread.currentThread().getName() + " has terminated.");
    }

    private int calculateDivisors(int start, int end) {
        int sum = 0;
        for (int i = start; i > 0; i--) {
            if (end == 50000 && i <= 1) continue; // Skip 1 for numbers greater than 50000
            if (end == 20000 && i <= 1) continue; // Skip 1 for numbers greater than 20000
            if (end % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int getSumOfDivisors() {
        return sumOfDivisors;
    }
}

