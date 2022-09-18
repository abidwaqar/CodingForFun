
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class WaterContainerSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 1; i <= T; ++i) {
                int N = sc.nextInt();
                int Q = sc.nextInt();

                HashMap<Integer, List<Integer>> containerTree = new HashMap<>();
                for (int j = 0; j < N - 1; ++j) {
                    int c1 = sc.nextInt();
                    int c2 = sc.nextInt();

                    if (!containerTree.containsKey(c1)) {
                        containerTree.put(c1, new ArrayList<>());
                    }

                    containerTree.get(c1).add(c2);

                    if (!containerTree.containsKey(c2)) {
                        containerTree.put(c2, new ArrayList<>());
                    }

                    containerTree.get(c2).add(c1);
                }

                for (int j = 0; j < Q; j++) {
                    sc.nextInt();
                }

                System.out.println("Case #" + i + ": " + solve(containerTree, Q));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // T = O(n) | S = O(n)
    // Where n is input array's length.
    private static int solve(HashMap<Integer, List<Integer>> containerTree, int litersAdded) throws Exception {
        List<Integer> levelContainersCount = new ArrayList<>();
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        bfs.offer(1);
        while (!bfs.isEmpty()) {
            levelContainersCount.add(bfs.size());
            for (int i = bfs.size() - 1; i >= 0; --i) {
                int currentContainer = bfs.poll();
                seen.add(currentContainer);

                if (!containerTree.containsKey(currentContainer)) {
                    continue;
                }

                for (int child : containerTree.get(currentContainer)) {
                    if (!seen.contains(child)) {
                        bfs.offer(child);
                    }
                }
            }
        }

        int containersCompletelyFilled = 0;
        for (int i = 0; i < levelContainersCount.size() && levelContainersCount.get(i) <= litersAdded; ++i) {
            containersCompletelyFilled += levelContainersCount.get(i);
            litersAdded -= levelContainersCount.get(i);
        }

        return containersCompletelyFilled;
    }
}