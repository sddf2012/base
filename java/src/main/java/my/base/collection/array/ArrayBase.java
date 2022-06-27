package my.base.collection.array;

/**
 * @author liu peng bo
 * @date 2022/6/16 下午7:44
 */
public class ArrayBase {
    public static  void main(String[] args) {
        int[] a=new int[2];
        a[0]=1;
        a[1]=2;
        System.out.println(a);

       int[] b= new int[]{1,2,3};
       String s="abc";
        System.out.println(s.toCharArray());
        int[][] ab={{1,1,3},{1,1,3}};
    }
}
