class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        // Arrays.sort(nums); 
        // int temp = 1;

        // for (int num : nums) {
        //     if (num == temp) {
        //         temp++;
        //     }
        // }

        // return temp;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}