package my.base.reference;

import lombok.Data;

/**
 * @author liu peng bo
 * @date 2022-8-5 10:53
 */

@Data
class RefA{
    private int a;

    public RefA(int a) {
        this.a = a;
    }
}
@Data
class RefB{
  private RefA refA;

    public RefB(RefA refA) {
        if(refA==null){
            refA=new RefA(123);
        }
        this.refA = refA;
    }
}


public class RefDemo {
    public static void main(String[] args) {
        /*RefB refB=m1();
        System.out.println(1);*/
        RefA refA=null;
        RefB refB=new RefB(refA);
        System.out.println(refA);

    }

    public static RefB m1(){
        RefA refA=new RefA(1);
        RefB refB=new RefB(refA);
        refA=new RefA(2);
        return refB;
    }
}
