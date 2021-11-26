public class ArrayExpand {
    public static void main(String[] args) {
        int[] num = {1,4,66,43,6,54,8};
        int[] temp = new int[num.length*2];
        for (int i = 0; i < num.length; i++) {
            temp[i] = num[i];
        }
        num = temp;
        num[7]= 8;
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
