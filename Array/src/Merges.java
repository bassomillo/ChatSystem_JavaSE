public class Merges {
    public static void main(String[] args) {
        int[] array1 = {1,3,5,7,8,9};
        int[] array2 = {2,4,5,7,9,12,15};
        int[] merge = new int[array1.length+array2.length];
        int index1=0;
        int index2=0;
        while (index1<array1.length||index2<array2.length){
            if(index1==array1.length){
                merge[index1+index2] = array2[index2];
                index2++;
                continue;
            }
            if(index2==array1.length){
                merge[index1+index2] = array1[index1];
                index1++;
                continue;
            }
            if(array1[index1]>array2[index2]){
                merge[index1+index2] = array2[index2];
                index2++;
            }else {
                merge[index1+index2] = array1[index1];
                index1++;
            }
        }
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i]);
        }
    }
}
