import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a positive number X. Find the largest Jumping Number smaller than or
 * equal to X.
 * Jumping Number: A number is called Jumping Number if all adjacent digits in
 * it differ by only 1.
 * All single digit numbers are considered as Jumping Numbers.
 * For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are
 * not.
 */
public class JumpingNumbers {
    static void dfs(long startingNumber, long X, ArrayList<Long> jumpingNumbers) {
        if (startingNumber <= X) {
            jumpingNumbers.add(startingNumber);
            long lastNumber = startingNumber % 10;

            if (lastNumber == 9) {
                dfs((startingNumber * 10) + 8, X, jumpingNumbers);
            } else if (lastNumber == 0) {
                dfs((startingNumber * 10) + 1, X, jumpingNumbers);
            } else {
                dfs((startingNumber * 10) + (lastNumber - 1), X, jumpingNumbers);
                dfs((startingNumber * 10) + (lastNumber + 1), X, jumpingNumbers);
            }
        }
    }

    static void bfs(int startingNumber, long X, ArrayList<Long> jumpingNumbers) {
        LinkedList<Long> queue = new LinkedList<>();

        queue.add((long) startingNumber);

        while (!queue.isEmpty()) {
            long number = queue.remove();
            if (number <= X) {
                jumpingNumbers.add(number);
                long lastNumber = number % 10;

                if (lastNumber == 9) {
                    queue.add((number * 10) + (lastNumber - 1));
                } else if (lastNumber == 0) {
                    queue.add((number * 10) + (lastNumber + 1));
                } else {
                    queue.add((number * 10) + (lastNumber - 1));
                    queue.add((number * 10) + (lastNumber + 1));
                }
            }
        }
    }

    static long jumpingNums(long X) {
        ArrayList<Long> jumpingNumbers = new ArrayList<>();
        for (int i = 0; i <= 9 && i <= X; ++i) {
            dfs((long) i, X, jumpingNumbers);
        }

        jumpingNumbers.sort(null);
        return jumpingNumbers.get(jumpingNumbers.size() - 1);
    }
}
