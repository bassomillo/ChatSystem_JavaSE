public class YangHuiTriangle {
    public static void main(String[] args) {
        int Height = 10000;
        int[][] nums= new int[Height][];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new int[i];
        }
        for (int i = 0; i < Height; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (j==0 || j==nums[i].length-1){
                    nums[i][j] = 1;
                }else {
                    nums[i][j] = nums[i-1][j-1]+nums[i-1][j];
                }
            }
        }
        for (int i = 0; i < Height; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }

    }
}
