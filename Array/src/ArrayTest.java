import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int result = -1;
        for (int i = 0; i < num.length; i++) {
            if(target == num[i]){
                result = i;
                System.out.println(result);
                break;
            }
        }
    }
}
