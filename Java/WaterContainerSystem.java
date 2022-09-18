
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

    // T = O(?) | S = O(?)
    // Where n is input array's length.
    private static int solve(HashMap<Integer, List<Integer>> containerTree, int litersAdded) throws Exception {
        preprocess(1, containerTree);

        int containersCompletelyFilled = 0;
        List<Integer> level = new ArrayList<>();
        level.add(1);
        while (!level.isEmpty() && level.size() <= litersAdded) {
            containersCompletelyFilled += level.size();
            litersAdded -= level.size();

            List<Integer> nextLevel = new ArrayList<>();
            for (int container : level) {
                if (containerTree.containsKey(container)) {
                    nextLevel.addAll(containerTree.get(container));
                }
            }

            level = nextLevel;
        }

        return containersCompletelyFilled;
    }

    private static void preprocess(Integer parent, HashMap<Integer, List<Integer>> containerTree) {
        if (!containerTree.containsKey(parent)) {
            return;
        }

        for (int child : containerTree.get(parent)) {
            containerTree.get(child).remove(parent);
            preprocess(child, containerTree);
        }
    }
}