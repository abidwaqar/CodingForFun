/**
 * Given N, count all ‘a’(>=1) and ‘b’(>=0) that satisfy the condition a3 + b3 =
 * N.
 */
public class PairCubeCount {
    static int pairCubeCount(int N) {
        int resultCount = 0;
        double cubeRootN = Math.cbrt(N);
        for (int a = 0; a <= cubeRootN; a++) {
            for (int b = a; b <= cubeRootN; b++) {
                if (b == 0)
                    continue;
                if ((Math.pow(a, 3) + Math.pow(b, 3)) == N) {
                    ++resultCount;
                    if (a != 0)
                        ++resultCount;
                }
            }
        }

        return resultCount;
    }

    static int pairCubeCountOptimized(int N) {
        int resultCount = 0, aCube, diff;
        double diffCubeRoot;
        double cubeRootN = Math.cbrt(N);
        for (int a = 1; a <= cubeRootN; a++) {
            aCube = a * a * a;
            diff = N - aCube;
            diffCubeRoot = Math.cbrt(diff);

            if (diffCubeRoot % 1 == 0)
                ++resultCount;
        }

        return resultCount;
    }
}
