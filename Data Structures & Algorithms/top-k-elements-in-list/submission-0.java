class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> count = new HashMap<>();

        for(int i : nums) {
            count.put(i, count.getOrDefault(i,0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int i : count.keySet()) {
            buckets[count.get(i)].add(i);
        }

        int index = 0;

        for(int i = buckets.length - 1; i >= 0; i--) {
            for(int j : buckets[i]) {
                res[index] = j;
                index++;

                if(index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
