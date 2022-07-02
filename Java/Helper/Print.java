package Helper;

import java.util.List;

/**
 * Helper functions for printing output.
 */
public class Print {
    public static void printArray(int[] array) {
        System.out.print("[ ");
        for (int i : array) {
            System.out.print("" + i + " ");
        }
        System.out.println("]");
    }

    public static void printArray(long[] array) {
        System.out.print("[ ");
        for (long i : array) {
            System.out.print("" + i + " ");
        }
        System.out.println("]");
    }

    public static <T> void printArray(T[] array) {
        System.out.print("[ ");
        for (T i : array) {
            System.out.print("" + i + " ");
        }
        System.out.println("]");
    }

    public static <T> void printArray(List<T> array) {
        System.out.print("[ ");
        for (T i : array) {
            System.out.print("" + i + " ");
        }
        System.out.println("]");
    }
}
