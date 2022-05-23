import java.util.Arrays;
import java.util.Scanner;

public class AntsOnAStick {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                int L = sc.nextInt();

                int[][] idPositionArr = new int[N][];
                int[][] fallDirectionArr = new int[N][];
                for (int j = 0; j < N; j++) {
                    int position = sc.nextInt();
                    int direction = sc.nextInt();

                    idPositionArr[j] = new int[] { j + 1, position };
                    fallDirectionArr[j] = new int[] { direction == 0 ? position : L - position, direction };
                }

                solve(i, idPositionArr, fallDirectionArr);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void solve(int testNumber, int[][] idPositionArr, int[][] fallDirectionArr) throws Exception {
        Arrays.sort(idPositionArr, (x, y) -> x[1] - y[1]);
        Arrays.sort(fallDirectionArr, (x, y) -> x[0] - y[0]);

        int leftPointer = 0, rightPointer = idPositionArr.length - 1;

        int[][] idFallArr = new int[idPositionArr.length][];
        for (int i = 0; i < idPositionArr.length; i++) {
            if (fallDirectionArr[i][1] == 0) {
                idFallArr[i] = new int[] { idPositionArr[leftPointer][0], fallDirectionArr[i][0] };
                ++leftPointer;
            } else {
                idFallArr[i] = new int[] { idPositionArr[rightPointer][0], fallDirectionArr[i][0] };
                --rightPointer;
            }
        }

        Arrays.sort(idFallArr, (x, y) -> x[1] - y[1] != 0 ? x[1] - y[1] : x[0] - y[0]);

        System.out.print("Case #" + testNumber + ": ");
        for (int[] idFall : idFallArr) {
            System.out.print("" + idFall[0] + " ");
        }
        System.out.println();
    }
}