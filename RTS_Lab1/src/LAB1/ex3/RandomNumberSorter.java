package LAB1.ex3;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberSorter {

    public static void main(String[] args) {
        int[] numbers = new int[10];

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Original Array:");
        displayArray(numbers);

        Arrays.sort(numbers);

        System.out.println("\nSorted Array:");
        displayArray(numbers);
    }

    private static void displayArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
