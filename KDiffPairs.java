import java.util.HashSet;
import java.util.Set;

class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        Set<Integer> duplicateSet = new HashSet<>();
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            if (numsSet.contains(num))
                duplicateSet.add(num);
            else
                numsSet.add(num);
        }

        if (k == 0) {
            return duplicateSet.size();
        }

        int count = 0;
        for (int num : nums) {
            if (numsSet.contains(num)) {
                numsSet.remove(num);
                if (numsSet.contains(num + k))
                    ++count;
                if (numsSet.contains(num - k))
                    ++count;
            }
        }

        return count;
    }
}