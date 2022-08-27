import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an undirected connected graph of g nodes nodes and M connections,
 * traverse all of the nodes at least once and store the order of traversal in
 * array A.
 * 
 * Select traversal A to create the lexicographically largest array B possible.
 * Return the resulting array B.
 */
public class DistinctOrderTraversal {

    // T = O(v * e * log(v)) | S = O(v + e)
    // Where n is input array's length.
    public static List<Integer> solve(int nodes, int[] gFrom, int[] gTo) {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 1; i <= nodes; ++i) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < gFrom.length; ++i) {
            adjacencyList.get(gFrom[i]).add(gTo[i]);
            adjacencyList.get(gTo[i]).add(gFrom[i]);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(nodes);

        boolean[] visited = new boolean[nodes];
        List<Integer> lexicographicallyOrderedArray = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int node = maxHeap.poll();
            visited[node - 1] = true;
            lexicographicallyOrderedArray.add(node);

            for (int neighborNode : adjacencyList.get(node)) {
                if (maxHeap.contains(neighborNode) || visited[neighborNode - 1]) {
                    continue;
                }

                maxHeap.add(neighborNode);
            }
        }

        return lexicographicallyOrderedArray;
    }
}
