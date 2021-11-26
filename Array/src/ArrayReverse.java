public class ArrayReverse {
    public static void main(String[] args) {
        int[] num = {1,44,32,5,45,7};
        //first method
        int[] temp = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            temp[i] = num[num.length-1-i];
        }
       num = temp;
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        //method two
        for (int i = 0; i < num.length / 2; i++) {
            int temperal = num[i];
            num[i] = num[num.length-1-i];
            num[num.length-1-i] = temperal;
        }
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
