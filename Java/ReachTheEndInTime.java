/**
 * A 2-D grid consisting of some blocked (represented as '#) and some unblocked
 * (represented as '.) cells is given. The starting position of a pointer is in
 * the top-left corner of the grid. It is guaranteed that the starting position
 * is in an unblocked cell. It is also guaranteed that the bottom-right cell is
 * unblocked. Each cell of the grid is connected with its right, left, top, and
 * bottom cells (if those cells exist). It takes 1 second for a pointer to move
 * from a cell to its adjacent cell. If the pointer can reach the bottom-right
 * corner of the grid within k seconds, return the string Yes. Otherwise, return
 * the string 'No'
 */
public class ReachTheEndInTime {

    private enum CellState {
        UNVISITED(-1), VISITING(-2), BLOCKED(-3);

        private int value;

        CellState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        };
    }

    // T = O(n * m) | S = O(n * m)
    // Where n and m are input array's height and width.
    public static String solve(char[][] grid, int t) throws Exception {
        if (grid.length == 0 || grid[0].length == 0) {
            throw new Exception("Grid cannot be emtpy.");
        }

        int[][] cache = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '.') {
                    cache[i][j] = CellState.UNVISITED.value;
                } else if (grid[i][j] == '#') {
                    cache[i][j] = CellState.BLOCKED.value;
                }
            }
        }

        // Time to go from end to end is 0
        cache[cache.length - 1][cache[0].length - 1] = 0;

        return minTimeToReachEnd(0, 0, cache) <= t ? "Yes" : "No";
    }

    private static int minTimeToReachEnd(int row, int column, int[][] cache) {
        if (row < 0
                || row >= cache.length
                || column < 0
                || column >= cache[row].length
                || cache[row][column] == CellState.BLOCKED.value
                || cache[row][column] == CellState.VISITING.value) {
            return -1;
        }

        if (cache[row][column] == CellState.UNVISITED.value) {
            cache[row][column] = CellState.VISITING.value;

            int minTimeToReachTheEnd = Integer.MAX_VALUE;

            // Right
            int timeToReachTheEnd = minTimeToReachEnd(row, column + 1, cache);
            minTimeToReachTheEnd = timeToReachTheEnd == -1 ? minTimeToReachTheEnd
                    : Math.min(minTimeToReachTheEnd, timeToReachTheEnd);

            // Down
            timeToReachTheEnd = minTimeToReachEnd(row + 1, column, cache);
            minTimeToReachTheEnd = timeToReachTheEnd == -1 ? minTimeToReachTheEnd
                    : Math.min(minTimeToReachTheEnd, timeToReachTheEnd);

            // Left
            timeToReachTheEnd = minTimeToReachEnd(row, column - 1, cache);
            minTimeToReachTheEnd = timeToReachTheEnd == -1 ? minTimeToReachTheEnd
                    : Math.min(minTimeToReachTheEnd, timeToReachTheEnd);

            // Up
            timeToReachTheEnd = minTimeToReachEnd(row - 1, column, cache);
            minTimeToReachTheEnd = timeToReachTheEnd == -1 ? minTimeToReachTheEnd
                    : Math.min(minTimeToReachTheEnd, timeToReachTheEnd);

            cache[row][column] = minTimeToReachTheEnd == Integer.MAX_VALUE ? CellState.UNVISITED.value
                    : minTimeToReachTheEnd + 1;
        }

        return cache[row][column];
    }
}
