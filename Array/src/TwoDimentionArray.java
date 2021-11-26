public class TwoDimentionArray {
    public static void main(String[] args) {
        int[][] nums = new int[2][];
        nums[0] = new int[]{1, 2, 3};
        nums[1] = new int[]{1,2};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.println(nums[i][j]);
            }
        }
    }
}
