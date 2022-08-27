import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time of 
// meeting i and F[i] is the finish time of meeting i. The task is to find the maximum number of meetings that can be 
// accommodated in the meeting room. Print all meeting numbers
public class MaxMeetingsInOneRoom {

    // T = O(nlog(n)) | S = O(n) - where n is the size of the array.
    public static List<Integer> solve(int[] startingTimes, int[] endingTimes) throws Exception {
        Integer[] indexes = new Integer[startingTimes.length];
        for (int i = 0; i < startingTimes.length; ++i) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (x, y) -> Double.compare(endingTimes[x], endingTimes[y]));

        int lastMeetingEndTime = 0;
        List<Integer> possibleMeetings = new ArrayList<>();
        for (int index : indexes) {
            if (lastMeetingEndTime <= startingTimes[index]) {
                possibleMeetings.add(index);
                lastMeetingEndTime = endingTimes[index];
            }
        }

        return possibleMeetings;
    }
}
