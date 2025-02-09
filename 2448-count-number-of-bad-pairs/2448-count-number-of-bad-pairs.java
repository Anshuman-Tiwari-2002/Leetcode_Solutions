class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - i;
        }
        
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(nums[i])) {
                ans += mp.get(nums[i]);
            }
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        
        long total = (long) n * (n - 1) / 2;
        return total - ans;
    }
}
