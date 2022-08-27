import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class KDiffPairs {
    // T = O(n) | S = O(n) - where n is the length of array
    public int findPairsSolution1(int[] nums, int k) {
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

    // T = O(nlog(n)) | S = O(n) - where n is the length of array
    public int findPairsSolution2(int[] nums, int k) {
        Arrays.sort(nums);

        HashSet<String> pairs = new HashSet<>();
        int left = 0, right = 1;
        while (right < nums.length) {
            int currentDiff = Math.abs(nums[left] - nums[right]);
            if (currentDiff < k) {
                ++right;
            } else if (currentDiff > k) {
                ++left;
                if (left == right) {
                    ++right;
                }
            } else {
                pairs.add("" + nums[left] + "|" + nums[right]);
                ++left;
                ++right;
            }
        }

        return pairs.size();
    }
}