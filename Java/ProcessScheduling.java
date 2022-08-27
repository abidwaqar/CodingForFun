import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Multiprocessor systems at Amazon involve multiple CPUs for performing various
 * tasks,
 * which increases throughput and reduces response time. A multiprocessor system
 * has a certain number of processors.
 * Each processor has the ability to schedule a limited number of processes in
 * one second. However, after each scheduling, the processor's ability is
 * reduced to ability/2 rounded dowry to the nearest number. Only one processor
 * can work to schedule processes each second. As an Amazonian you are tasked to
 * find the minimum time required to schedule all the processes in the system
 * given the processor's abilities and the number of processes.
 * 
 * Write an algorithm that returns minimum time required to schedule the
 * processes.
 * 
 * Input
 * The input to the function/method consists of three arguments:
 * num, an integer representing the number of processors;
 * ability, a list of integers representing the ability of the processors;
 * processes, a long integer representing the number of processes to be
 * scheduled.
 * 
 * Output
 * Return an integer representing the minimum time required to schedule the
 * processes.
 * 
 * Constraints
 * 1 <= num <= 10^5
 * 1 <= ability[i] <= 10^6
 * 1 <= processes <= 10^12
 * 0 <= i < num
 * 
 * Note
 * It is guaranteed that the processes can be scheduled using the given
 * multiprocessor system.
 */
public class ProcessScheduling {

    // T = O(p * log(n) * log(n)) | S = O(n)
    // Where n is input array's length and p is the number of processes.
    public static int solve(int[] abilities, int processes) {
        PriorityQueue<Integer> processorsAbilitysMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int ability : abilities) {
            processorsAbilitysMaxHeap.add(ability);
        }

        int count = 0;
        while (processes > 0) {
            int ability = processorsAbilitysMaxHeap.poll();

            processes -= ability;

            processorsAbilitysMaxHeap.add(ability / 2);

            ++count;
        }

        return count;
    }
}
