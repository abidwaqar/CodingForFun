import java.util.List;

public class Program {
    public static void main(String[] args) {
        try {
            int[] a = new int[] { 1, 2, 3, 4, 5, 6 };
            int[] b = new int[] { 4 };
            int[] c = new int[] { 2, 3 };
            int[] d = new int[] { 1, 2 };
            int budget = 10;
            System.out.println(ShoppingOptions.solveNaive(a, a, a, a, budget));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printArray(int[] array) {
        System.out.print("[ ");
        for (int i : array) {
            System.out.print("" + i + " ");
        }
        System.out.println("]");
    }

    private static void printArray(List<Integer> array) {
        System.out.print("[ ");
        for (int i : array) {
            System.out.print("" + i + " ");
        }
        System.out.println("]");
    }
}
