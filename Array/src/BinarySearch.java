import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,8,9,10,12,14,16};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put search content");
        int target = scanner.nextInt();
        if(target < nums[0] || target >nums[nums.length-1]){
            System.out.println("out range");
        }else {
            int left = 0;
            int right = nums.length-1;
            int res = -1;
            while (left <= right){
                int middle = (left+right)/2;
                if(nums[middle]==target){
                    res = middle;
                    break;
                }else if(nums[middle]>target){
                    right = middle-1;
                }else {
                    left = middle+1;
                }
            }
            System.out.println(res);
        }
    }
}
