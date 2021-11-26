public class findMax {
    public static void main(String[] args) {
        int[] num = {1,4,6,3,5,8,2};
        int maxIndex = 0;
        for (int i = 1; i < num.length; i++) {
            if(num[i]>num[maxIndex]){
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
        System.out.println(num[maxIndex]);
    }
}
